package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.*;
import org.sid.inventoryservice.repository.*;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@AllArgsConstructor
public class InventoryRestRepositorry {
    private PhotoRepository photoRepository;
    private ProductRepository productRepository;
    private CategoryMenuRepository categoryMenuRepository;
    private CategoryChambreRepository categoryChambreRepository;
    private MenuRepository menuRepository;
    private ChambreRepository chambreRepository;
    private final CategoryRepository categoryRepository;


    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public List<byte[]>  getPhoto(@PathVariable(name="id") Long id) throws Exception {
        Product pd = productRepository.findById(id).get();
        PagedModel<Photo> photos = photoRepository.findPhotosByProduct(pd);
        List<byte[]> btl=new ArrayList<>();
        for (Photo p:photos){
          btl.add(Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/ecom/products/" + p.getNamePhoto())));
        }
        return btl;
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws IOException {
        Photo p = new Photo();
        Product pd = productRepository.findById(id).get();
        p.setNamePhoto(UUID.randomUUID().toString() +".jpg");
        p.setProduct(pd);
        Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getNamePhoto()),file.getBytes());
        photoRepository.save(p);
    }
//+++++++++++++++photo category menu-------------------------
    @GetMapping(path="/photoCategMenu/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getCategMenu(@PathVariable(name="id") Long id) throws Exception {
        CategoryMenu cme = categoryMenuRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/nysoahotel/menu/"+cme.getPhotoName()));
    }
    @PostMapping(path = "/uploadCategMenu/{id}")
    public void uploadCategMenu(MultipartFile file, @PathVariable(name="id") Long id) throws IOException {
        CategoryMenu cme = categoryMenuRepository.findById(id).get();
        cme.setPhotoName(id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+"/nysoahotel/menu/"+cme.getPhotoName()),file.getBytes());
        categoryMenuRepository.save(cme);
    }
    //--------------photo menu-------------------------------
    @GetMapping(path="/photoMenu/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getMenu(@PathVariable(name="id") Long id) throws Exception {
        Menu cme = menuRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/nysoahotel/menu/"+cme.getPhotoName()));
    }
    @PostMapping(path = "/uploadMenu/{id}")
    public void uploadMenu(MultipartFile file, @PathVariable Long id) throws IOException {
        Menu cme = menuRepository.findById(id).get();
        cme.setPhotoName(id+".jpg");
        Files.write(Paths.get(System.getProperty("user.home")+"/nysoahotel/menu/"+cme.getPhotoName()),file.getBytes());
        menuRepository.save(cme);
    }
    //------------photo category chambre----------------------
    @GetMapping(path="/photoCategCham/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getCategChambre(@PathVariable(name="id") Long id) throws Exception {
        CategoryChambre cme = categoryChambreRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/nysoahotel/chambre/"+cme.getPhotoName()));
    }
    @PostMapping(path = "/uploadCategCham/{id}")
    public void uploadCategChambre(MultipartFile file, @PathVariable(name="id") Long id) throws IOException {
        CategoryChambre cme = categoryChambreRepository.findById(id).get();
        cme.setPhotoName(id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+"/nysoahotel/chambre/"+cme.getPhotoName()),file.getBytes());
        categoryChambreRepository.save(cme);
    }
    //-------------photo chambre---------------
    @GetMapping(path="/photoChambre/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getChambre(@PathVariable(name="id") Long id) throws Exception {
        Chambre cme = chambreRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/nysoahotel/chambre/"+cme.getPhotoname()));
    }
    @PostMapping(path = "/uploadChambre/{id}")
    public void uploadChambre(MultipartFile file, @PathVariable(name="id") Long id) throws IOException {
        Chambre cme = chambreRepository.findById(id).get();
        cme.setPhotoname(id+".jpg");
        Files.write(Paths.get(System.getProperty("user.home")+"/nysoahotel/chambre/"+cme.getPhotoname()),file.getBytes());
        chambreRepository.save(cme);
    }
}
