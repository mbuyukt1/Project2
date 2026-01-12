package pl.edu.vistula.first_rest_api_spring.product.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ProductRequest {
    private final String name;

    @JsonCreator
    public ProductRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}