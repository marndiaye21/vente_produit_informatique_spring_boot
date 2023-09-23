package sn.usher21.helloapp.services;

import java.util.List;

import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.ProductSpec;
import sn.usher21.helloapp.models.ProductSuccursale;
import sn.usher21.helloapp.models.Specification;
import sn.usher21.helloapp.models.Succursale;

public interface ProductService {
    public List<Product> getProducts();
    public Product saveProduct(Product product);
    public ProductSuccursale addSuccursaleProduct(Succursale succursale, Product product);
    public List<ProductSpec> addProductSpecs(Product newProduct, List<Specification> specifications);
}
