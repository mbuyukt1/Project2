package pl.edu.vistula.first_rest_api_spring.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.first_rest_api_spring.product.api.request.ProductRequest;
import pl.edu.vistula.first_rest_api_spring.product.api.response.ProductResponse;
import pl.edu.vistula.first_rest_api_spring.product.domain.Product;
import pl.edu.vistula.first_rest_api_spring.product.repository.ProductRepository;
import pl.edu.vistula.first_rest_api_spring.product.support.ProductMapper;
import pl.edu.vistula.first_rest_api_spring.product.support.exception.ProductExceptionSupplier;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));

        product.setName(productRequest.getName());

        Product updatedProduct = productRepository.save(product);
        return productMapper.toProductResponse(updatedProduct);
    }

    public void delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(id);
    }
}