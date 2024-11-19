package org.sid.inventoryservice;

import net.bytebuddy.utility.RandomString;
import org.sid.inventoryservice.entities.*;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.repository.*;
import org.sid.inventoryservice.security.sec_service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class InventoryServiceApplication {
    private final CommandeRepository commandeRepository;

    public InventoryServiceApplication(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder()  {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(
            RepositoryRestConfiguration restConfiguration,
            CategoryMenuRepository menuRepository,
            CategoryChambreRepository chambreRepository,
            MenuRepository repositoryMen,
            ChambreRepository repositoryChambre,
            AccountService accountService,
            MenuItemRepository menuItemRepository

    ){
        return args -> {

            accountService.addNewRole(new AppRole(null, "CUSTOMER"));
            accountService.addNewRole(new AppRole(null, "USER"));
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRole(null, "BILLS_MANAGER"));

            accountService.addNewUser( "user1", "1234","1234");
            accountService.addNewUser("admin", "1234","1234");
            accountService.addNewUser("customer", "1234","1234");
            accountService.addNewUser("user2", "1234","1234");
            accountService.addNewUser("user3", "1234","1234");
            accountService.addNewUser("user4", "1234","1234");
            accountService.addNewUser("customer1", "1234","1234");
            accountService.addNewUser("customer2", "1234","1234");
            accountService.addNewUser("customer3", "1234","1234");
            accountService.addNewUser("customer4", "1234","1234");

            accountService.addRoleToUser("user1", "USER");
            accountService.addRoleToUser("admin", "USER");
            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("user2", "USER");
            accountService.addRoleToUser("user2", "CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3", "PRODUCT_MANAGER");
            accountService.addRoleToUser("customer", "CUSTOMER");
            accountService.addRoleToUser("customer1", "CUSTOMER");
            accountService.addRoleToUser("customer2", "CUSTOMER");
            accountService.addRoleToUser("customer3", "CUSTOMER");
            accountService.addRoleToUser("customer4", "CUSTOMER");
            accountService.addRoleToUser("user4", "USER");
            accountService.addRoleToUser("user4", "BILLS_MANAGER");



            Random rnd= new Random();
            restConfiguration.exposeIdsFor(Product.class, Category.class);
            menuRepository.saveAll(
                    List.of(
                            CategoryMenu.builder().deco("Lovely").nameCat("Dinner").photoName("m121.png").build(),
                            CategoryMenu.builder().deco("Popular").nameCat("Breakfast").photoName("m128.png").build(),
                            CategoryMenu.builder().deco("Savoureux").nameCat("Grillade").photoName("m125.png").build(),
                            CategoryMenu.builder().deco("Fraîcheur").nameCat("Boisson").photoName("m129.png").build(),
                            CategoryMenu.builder().deco("??????").nameCat("Crudité").photoName("m122.png").build()

                    )
            );

            menuRepository.findAll().forEach(cm->{
                for(int i=0;i<10;i++) {
                    repositoryMen.saveAll(
                            List.of(
                                    Menu.builder()
                                            .name(RandomString.make(6))
                                            .ingredient(RandomString.make(30))
                                            .prix(rnd.nextInt(100,600000))
                                            .promo(rnd.nextBoolean())
                                            .prixpromo(rnd.nextInt(2,50))
                                            .vailable(rnd.nextBoolean())
                                            .selected(rnd.nextInt(1,6000))
                                            .photoName(""+rnd.nextInt(1,17))
                                            .categoryMenu(cm)
                                            .build()
                            )
                    );
                }
            });

            chambreRepository.saveAll(
                    List.of(
                            CategoryChambre.builder().deco("Confort").nameCat("Particulier").photoName("").build(),
                            CategoryChambre.builder().deco("Chaleureux").nameCat("Famillial").photoName("").build(),
                            CategoryChambre.builder().deco("Merveilleux").nameCat("Salle de cérémonie").photoName("").build(),
                            CategoryChambre.builder().deco("Large").nameCat("Salle de conférence").photoName("").build(),
                            CategoryChambre.builder().deco("Abordable").nameCat("Passage").photoName("").build()

                    )
            );
            chambreRepository.findAll().forEach(c -> {

                for (int i=0; i<10;i++){

                    repositoryChambre.saveAll(List.of(
                            Chambre.builder()
                                    .numeroChambre(rnd.nextInt(1,33))
                                    .detailChambre(RandomString.make(30))
                                    .sonorisation(rnd.nextBoolean())
                                    .prixsono(rnd.nextDouble(100000,400000))
                                    .decoration(rnd.nextBoolean())
                                    .prixdeco(rnd.nextDouble(200000,600000))
                                    .nombrePerson(rnd.nextInt(1,100))
                                    .tv(rnd.nextBoolean())
                                    .wifi(rnd.nextBoolean())
                                    .eauChaude(rnd.nextBoolean())
                                    .climatiseur(rnd.nextBoolean())
                                    .nombrelit(rnd.nextInt(1,4))
                                    .prix(rnd.nextDouble(25000,120000))
                                    .promo(rnd.nextBoolean())
                                    .prixpromo(rnd.nextInt(2,50))
                                    .photoname(""+rnd.nextInt(1,19))
                                    .selected(rnd.nextInt(1,100000))
                                    .disponible(rnd.nextBoolean())
                                    .categoryChambre(c)
                                    .build()
                    ));

                }
            });

            Random random = new Random();
            List<AppUser> appUsers = accountService.listUsers();
            List<Menu> menus = repositoryMen.findAll();
            for (int i=0;i<20;i++){
                Commande commande = Commande.builder()
                        .appUser(appUsers.get(random.nextInt(appUsers.size())))
                        .dateCreation(new Date())
                        .status(Math.random()>0.5? StatuCommande.CREATED:StatuCommande.PENDING)
                        .build();
                Commande commande1= commandeRepository.save(commande);
                for (int j = 0; j <menus.size(); j++) {
                    if(Math.random()>0.70){
                        MenuItem menuItem = MenuItem.builder()
                                .commande(commande1)
                                .menu(menus.get(j))
                                .prix(menus.get(j).getPrix())
                                .quantity(1+random.nextInt(10))
                                .discout(random.nextInt(2,50))
                                .build();
                        menuItemRepository.save(menuItem);
                    }
                }

            }

        };
    }
}
