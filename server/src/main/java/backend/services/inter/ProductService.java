package backend.services.inter;

import backend.dto.ProductDto;
import backend.repos.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();
    String saveProduct(ProductEntity productEntity);

    String updateProduct(ProductEntity productEntity);

    ProductEntity getProductById(int id);

    void deleteProduct(ProductEntity productEntity);

}
