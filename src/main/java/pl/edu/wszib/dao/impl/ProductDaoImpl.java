package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.ProductDao;
import pl.edu.wszib.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    private Map<Long, Product> productMap;
    private static Long id = 1L;

    public ProductDaoImpl() {
        this.productMap = new HashMap<>();
        prepareProductList();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void removeProduct(Long id) {
        productMap.remove(id);
    }

    @Override
    public void saveProduct(Product product) {
        if (product.getId() < 1) {
            product.setId(id);
            id++;
        }
        productMap.put(product.getId(), product);
    }

    @Override
    public Product getById(Long id) {
        return productMap.get(id);
    }

    private void prepareProductList() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(10.00);
        product1.setAvailable(true);
        product1.setQuantity(5);

        saveProduct(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(25.50);
        product2.setAvailable(false);
        product2.setQuantity(6);

        saveProduct(product2);
    }
}
