package backend.network.rest;

import backend.dto.OrderDto;
import backend.dto.UserDto;
import backend.dto.UserRegisterDto;
import backend.repos.entities.UserEntity;
import backend.repos.utils.Mapper;
import backend.services.ServicesFactoryMethod;
import backend.services.inter.OrderService;
import backend.services.inter.UserService;
import jakarta.ws.rs.*;

import java.util.List;

@Path("users")
public class UserRestResource {


    private UserService userService = ServicesFactoryMethod.getUserServiceImpl();
    private OrderService orderService = ServicesFactoryMethod.getOrderServiceImpl();


    @GET
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    public String addUser(UserRegisterDto userRegisterDto){

        UserEntity userEntity = Mapper.userDtoToUserEntity(userRegisterDto);
        userService.saveUser(userEntity);
        return "User Created Successfully";
    }

    @PUT
    @Path("{id}")
    public String updateUser(UserRegisterDto userRegisterDto , @PathParam("id") int id){

        UserEntity userEntity = Mapper.userDtoToUserEntity(userRegisterDto);
        userEntity.setId(id);
        userService.updateUser(userEntity);
        return "User Updated Successfully";

    }

    @GET
    @Path("{id}")
    public UserEntity getUser(@PathParam("id") int id) {
        return   userService.getUserById(id);
    }

    @DELETE
    @Path("{id}")
    public String deleteUser(@PathParam("id") int id) {
        UserEntity userEntity = userService.getUserById(id);
        if(userEntity!=null){
            userService.deleteUser(userEntity);
            return  "User Deleted Successfully";
        }
        return "User not found";
    }

    @GET
    @Path("{id}/orders")
    public List<OrderDto> getUserOrders(@PathParam("id") int id) {
        return orderService.getAllOrdersToUser(id);
    }

}

