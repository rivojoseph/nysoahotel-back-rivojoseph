package org.sid.inventoryservice.security.sec_service;



import org.sid.inventoryservice.entities.AppRole;
import org.sid.inventoryservice.entities.AppUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(String username, String password, String rePassword);
    AppUser addNewUser(AppUser appUser);


    AppRole addNewRole(AppRole appRole);

    void addRoleToUser(String username, String roleName);
    void deleteRoleToUser(String username);

    AppUser loadUserByUsername(String username);

    Page<AppUser> listUsers(String role,int page,int size);
    List<AppUser> listUsers();
    List<AppRole>listRoles();
    AppUser getOne(Long id);
    AppUser edit(Long id, AppUser appUser);
    AppUser setActive(AppUser appUser);
    AppUser setDesactive(AppUser appUser);
    void logout(AppUser appUser);
    void delete(AppUser appUser);
}
