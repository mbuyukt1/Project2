package pl.edu.vistula.first_rest_api_spring.product.repository;

import org.springframework.stereotype.Repository;
import pl.edu.vistula.first_rest_api_spring.product.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final Map<Long, Product> database = new HashMap<>();
    private Long idCounter = 0L;

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(++idCounter);
        }
        database.put(product.getId(), product);
        return product;
    }
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }
    public void deleteById(Long id) {
        database.remove(id);
    }
    public void deleteAll() {
        database.clear();
    }
}