package backend.repos.repositories.impl;

import backend.repos.entities.UserEntity;
import backend.repos.repositories.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserRepositoryImpl extends RepositoryImpl<UserEntity,Integer> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


}
