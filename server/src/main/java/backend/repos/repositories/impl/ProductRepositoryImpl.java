package backend.repos.repositories.impl;

import backend.repos.entities.ProductEntity;
import backend.repos.repositories.ProductRepository;
import jakarta.persistence.EntityManager;

public class ProductRepositoryImpl  extends RepositoryImpl<ProductEntity,Integer> implements ProductRepository {

    public ProductRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }



}
