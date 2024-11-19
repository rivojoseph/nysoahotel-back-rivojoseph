package org.sid.inventoryservice.security.sec_service;

import org.sid.inventoryservice.entities.AppRole;
import org.sid.inventoryservice.entities.AppUser;
import org.sid.inventoryservice.repository.AppRoleRepository;
import org.sid.inventoryservice.repository.AppUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.UserTransaction;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public AppUser addNewUser(String username, String password, String rePassword) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) throw new RuntimeException("User already exists");
        if (!password.equals(rePassword)) throw new RuntimeException("Please confirm your Password");
        AppUser appUser1 = new AppUser();
        appUser1.setPassword(passwordEncoder.encode(password));
        appUser1.setUsername(username);
        appUser1.setActive(true);
        AppUser user = appUserRepository.save(appUser1);
        return user;
    }
    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public void deleteRoleToUser(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        appUser.getAppRoles().remove(appUser.getAppRoles());
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        if (appUserRepository.findByUsername(username)!=null){
            AppUser appUser = appUserRepository.findByUsername(username);
            appUser.setActive(true);
            appUserRepository.save(appUser);
        }
        return appUserRepository.findByUsername(username);
    }

    @Override
    public Page<AppUser> listUsers(String role, int page, int size) {
        AppRole r = appRoleRepository.findByRoleName(role);
        return appUserRepository.findAllByAppRolesContains(r, PageRequest.of(page,size));
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public List<AppRole> listRoles() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppUser getOne(Long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public AppUser edit(Long id, AppUser appUser) {
        appUser.setId(id);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser setActive( AppUser appUser) {
        appUser.setActive(true);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser setDesactive(AppUser appUser) {
        appUser.setActive(false);
        return appUserRepository.save(appUser);
    }

    @Override
    public void logout(AppUser appUser) {
        setDesactive(appUser);
    }

    @Override
    public void delete(AppUser appUser) {
        appUserRepository.delete(appUser);
    }
}
