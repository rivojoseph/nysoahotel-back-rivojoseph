package org.sid.inventoryservice.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.sid.inventoryservice.entities.AppRole;
import org.sid.inventoryservice.entities.AppUser;
import org.sid.inventoryservice.security.JWTUtil;
import org.sid.inventoryservice.security.sec_service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private AccountService accountService;

    @GetMapping(path = "/users/{role}")
    public Page<AppUser> appUsers(@PathVariable String role, @RequestParam int page, @RequestParam int size) {
        return accountService.listUsers(role,page,size);
    }
    @GetMapping(path = "/roles")
    public List<AppRole> appRoles() {
        return accountService.listRoles();
    }

    @GetMapping(path = "/user/getone/{id}")
    public AppUser getOne(@PathVariable Long id) {
        return accountService.getOne(id);
    }
    @GetMapping(path = "/user/getbyusername/{username}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public AppUser getByUserName(@PathVariable String username) {
        return accountService.loadUserByUsername(username);
    }
    @PatchMapping (path = "/user/edit/{id}")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser edit(@PathVariable Long id,@RequestBody AppUser appUser) {
        return accountService.edit(id,appUser);
    }
    @DeleteMapping(path = "/user")
    @RolesAllowed({"ADMIN","USER"})
    public void delete(@RequestBody AppUser appUser) {
        accountService.delete(appUser);
    }

    @PostMapping(path = "/register")
    public AppUser saveUser(@RequestBody AppUser appUser) {
        AppUser user= accountService.addNewUser(appUser);
        return user;
    }

    @PostMapping(path = "/login")
    public AppUser login(@RequestBody AppUser appUser) {
        return accountService.loadUserByUsername(appUser.getUsername());
    }

    @PostMapping(path = "/logout")
    public AppUser logout(@RequestBody AppUser appUser) {
        return accountService.setDesactive(appUser);
    }

    @PostMapping(path = "/roles")
    //@PostAuthorize("hasAuthority('ADMIN')")
    @RolesAllowed({"ADMIN","USER"})
    public AppRole saveRole(@RequestBody AppRole appRole) {
        return accountService.addNewRole(appRole);
    }

    @PostMapping(path = "/addRoleByCustomer")
    public void addRoleToUser(@RequestBody AppUser appUser) {
        accountService.addRoleToUser(appUser.getUsername(), "CUSTOMER");
    }
    @RolesAllowed({"ADMIN"})
    @PostMapping(path = "/deleteRoleByCustomer")
    public void deleteRoleToUser(@RequestBody AppUser appUser) {
        accountService.deleteRoleToUser(appUser.getUsername());
    }
    @PostMapping(path = "/addRoleByAdmin")
    @RolesAllowed({"ADMIN"})
    public void addRoleByAdmin(@RequestBody RoleUserForm roleUserForm) {
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
    }

    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authToken = request.getHeader(JWTUtil.AUTH_HEADER);
        if (authToken != null && authToken.startsWith(JWTUtil.PREFIX)) {
            try {
                String jwt = authToken.substring(JWTUtil.PREFIX.length());
                Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username = decodedJWT.getSubject();
                AppUser appUser = accountService.loadUserByUsername(username);
                String jwtAccessToken = JWT.create()
                        .withSubject(appUser.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_ACCESS_TOKEN))//expire 5 min
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", appUser.getAppRoles().stream().map(r -> r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> idToken = new HashMap<>();
                idToken.put("access-token", jwtAccessToken);
                idToken.put("refresh-token", jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new RuntimeException("Refresh token required!!!");
        }
    }

    @GetMapping(path = "/profile")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Authentication profile(Authentication authentication) {
        return authentication;
    }
}

@Data
class RoleUserForm {
    private String username;
    private String roleName;
}
