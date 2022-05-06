package backend.network.soap;


import backend.dto.UserDto;
import backend.dto.UserRegisterDto;
import backend.repos.entities.UserEntity;
import backend.repos.utils.Mapper;
import backend.services.ServicesFactoryMethod;
import backend.services.inter.UserService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class UserSoapResource {

    private UserService userService = ServicesFactoryMethod.getUserServiceImpl();

    @WebMethod
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @WebMethod
    public String saveUser(UserRegisterDto userRegisterDto){

        UserEntity userEntity = Mapper.userDtoToUserEntity(userRegisterDto);
        userService.saveUser(userEntity);
        return "User Created Successfully";
    }
    @WebMethod
    public String updateUser(UserRegisterDto userRegisterDto ){

        UserEntity userEntity =Mapper.userDtoToUserEntity(userRegisterDto);
        userService.updateUser(userEntity);
        return "User Updated Successfully";
    }

    @WebMethod
    public UserEntity getUser(int id) {
        return  userService.getUserById(id);
    }
    @WebMethod
    public String deleteUser(int id) {
        UserEntity userEntity = userService.getUserById(id);
        if(userEntity!=null){
            userService.deleteUser(userEntity);
            return  "User Deleted Successfully";
        }

        return "User not found";

    }
}
