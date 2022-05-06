package backend.services.impl;

import backend.dto.ProductDto;
import backend.repos.dbconnector.Connector;
import backend.repos.entities.ProductEntity;
import backend.repos.repositories.ProductRepository;
import backend.repos.repositories.impl.ProductRepositoryImpl;
import backend.repos.utils.Mapper;
import backend.services.inter.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private EntityManager entityManager =  Connector.getInstance().getEntityManager();
    private ProductRepository productRepository = new ProductRepositoryImpl(entityManager);

    @Override
    public List<ProductDto> getAllProducts() {
        Query query = entityManager.createQuery("SELECT c FROM ProductEntity c");
        return Mapper.productEntityToProductDto(query.getResultList());
    }

    @Override
    public String saveProduct(ProductEntity productEntity) {

        productRepository.save(productEntity);
        return "Done";
    }

    @Override
    public String updateProduct(ProductEntity productEntity) {
        productRepository.update(productEntity);
        return "Product Updated Successfully";
    }

    @Override
    public ProductEntity getProductById(int id) {
       return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(ProductEntity productEntity) {
        productRepository.delete(productEntity);
    }


}
