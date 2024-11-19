package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.Category;
import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.exceptions.ProduitException;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Override
    public PagedModel<Product> getAllProducts() {
        if (productRepository.findAll().isEmpty()) throw new ProduitException("Liste des produits vide");
        PagedModel<Product> products = (PagedModel<Product>) productRepository.findAll();
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Long idProd, Product product) {
        Product p = productRepository.findById(idProd).get();
        p.setCategory(product.getCategory());
        p.setName(product.getName());
        p.setDateExpiration(product.getDateExpiration());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setPrixpromo(product.getPrixpromo());
        p.setQuantity(product.getQuantity());
        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(Long idProd) {
        productRepository.deleteById(idProd);
    }

    @Override
    public void setSelected(Product product) {
        Product p = productRepository.findById(product.getId()).get();
        p.setSelected(p.getSelected()+1);
    }

    @Override
    public boolean setPromo(Product product) {
        Product p = productRepository.findById(product.getId()).get();
        p.setPromo(!product.isPromo());
        return p.isPromo();
    }

    @Override
    public boolean setAvailable(Product product) {
        Product p = productRepository.findById(product.getId()).get();
        p.setPromo(!product.isAvailable());
        return p.isAvailable();
    }

    @Override
    public PagedModel<Product> findProductsByCategory(Category c) throws ProduitException {
        PagedModel<Product> products = productRepository.findProductsByCategoryId(c.getId());
        return products;
    }

    @Override
    public PagedModel<Product> findProductsByPromotionIsTrue() {
        return null;
    }

    @Override
    public PagedModel<Product> findProductsByDisponibleIsTrue() {
        return null;
    }

    @Override
    public PagedModel<Product> findProductsByDisponibleIsFalse() {
        return null;
    }
}
