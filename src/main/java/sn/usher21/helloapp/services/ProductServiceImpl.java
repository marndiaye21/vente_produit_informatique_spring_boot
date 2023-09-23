package sn.usher21.helloapp.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.ProductSpec;
import sn.usher21.helloapp.models.ProductSuccursale;
import sn.usher21.helloapp.models.Specification;
import sn.usher21.helloapp.models.Succursale;
import sn.usher21.helloapp.repositories.ProductRepository;
import sn.usher21.helloapp.repositories.ProductSpecRepository;
import sn.usher21.helloapp.repositories.ProductSuccursaleRepository;
import sn.usher21.helloapp.repositories.SpecRepository;
import sn.usher21.helloapp.repositories.SuccursaleRepository;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductSuccursaleRepository productSuccursaleRepository;
    SuccursaleRepository succursaleRepository;
    SpecRepository specRepository;
    ProductSpecRepository productSpecRepository;

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        List<Succursale> succursales = new ArrayList<>();

        Product newProduct = Product.builder()
                .label(product.getLabel())
                .marque(product.getMarque())
                .code(product.getCode())
                .description(product.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        newProduct = productRepository.save(newProduct);

        Succursale succursale = product.getSuccursales().get(0);
        Succursale foundSuccursale = this.succursaleRepository.findById(succursale.getId()).orElse(null);
        if (foundSuccursale != null) {
            this.addSuccursaleProduct(foundSuccursale, newProduct);
            // foundSuccursale.setProductSuccursale(null);
        }

        List<Specification> specifications = product.getSpecifications();
        this.addProductSpecs(newProduct, specifications);

        succursales.add(foundSuccursale);
        newProduct.setSuccursales(succursales);

        return newProduct;
    }

    @Override
    public ProductSuccursale addSuccursaleProduct(Succursale succursale, Product product) {
        ProductSuccursale productSuccursale = succursale.getProductSuccursale().get(0);
        productSuccursale.setProduct(product);
        productSuccursale.setSuccursale(succursale);
        return this.productSuccursaleRepository.save(productSuccursale);
    }

    @Override
    public List<ProductSpec> addProductSpecs(Product newProduct, List<Specification> specifications) {
        List<ProductSpec> productSpecs = new ArrayList<>();

        for (Specification specification : specifications) {
            ProductSpec productSpec = specification.getProductSpecs().get(0);
            productSpec.setProduct(newProduct);

            Specification foundSpecification = this.specRepository.findByLabel(specification.getLabel());
            if (foundSpecification != null) {
                productSpec.setSpecification(foundSpecification);
            } else {
                Specification newSpecification = new Specification(LocalDateTime.now(), LocalDateTime.now(),
                        specification.getLabel(), null);
                productSpec.setSpecification(this.specRepository.save(newSpecification));
            }

            productSpecs.add(productSpec);
        }

        return this.productSpecRepository.saveAll(productSpecs);
    }
}
