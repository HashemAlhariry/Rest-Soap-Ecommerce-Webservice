package backend.services.inter;

import backend.dto.UserDto;
import backend.repos.entities.UserEntity;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    String saveUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    UserEntity getUserById(int id);

    void deleteUser(UserEntity userEntity);

}
