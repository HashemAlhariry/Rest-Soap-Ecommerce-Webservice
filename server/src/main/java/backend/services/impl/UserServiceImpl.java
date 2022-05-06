package backend.services.impl;

import backend.dto.UserDto;
import backend.repos.dbconnector.Connector;
import backend.repos.entities.UserEntity;
import backend.repos.repositories.UserRepository;
import backend.repos.repositories.impl.UserRepositoryImpl;
import backend.repos.utils.Mapper;
import backend.services.inter.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UserServiceImpl implements UserService {

    private EntityManager entityManager =  Connector.getInstance().getEntityManager();
    private UserRepository userRepository = new UserRepositoryImpl(entityManager);

    @Override
    public List<UserDto>  getAllUsers() {
        Query query = entityManager.createQuery("SELECT c FROM UserEntity c");
        return Mapper.userEntityToUserDto(query.getResultList());
    }

    @Override
    public String saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return "Done";
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userRepository.update(userEntity);
    }

    @Override
    public UserEntity getUserById(int id) {
       return userRepository.findById(id);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }


}
