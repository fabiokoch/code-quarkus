package br.com.crud.service;

import br.com.crud.dto.ProductDTO;
import br.com.crud.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {
    public List<Product> listProduct() {
        return Product.listAll();
    }

    @Transactional
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        product.persist();
        return product;
    }

    @Transactional
    public void updateProduct(Long id, ProductDTO productDTO) {
        Product product = new Product();
        Optional<Product> productOp = Product.findByIdOptional(id);

        if (productOp.isEmpty()) {
            throw new NullPointerException("Product not found");
        }

        product = productOp.get();
        product.setNome(productDTO.getNome());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.persist();
    }

    @Transactional
    public void deleteProduct(Long id) {
        Optional<Product> productOp = Product.findByIdOptional(id);

        if (productOp.isEmpty()) {
            throw new NullPointerException("Product not found");
        }

        Product entityBase = productOp.get();
        entityBase.delete();
    }
}
