package backend.repos.utils;

import backend.dto.*;
import backend.repos.entities.OrderDetailsEntity;
import backend.repos.entities.OrderEntity;
import backend.repos.entities.ProductEntity;
import backend.repos.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<UserDto> userEntityToUserDto(List<UserEntity> userEntityList){
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            UserDto userDto = new UserDto(userEntity.getUserName(),userEntity.getEmail(),userEntity.getAddress());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public static List<ProductDto> productEntityToProductDto (List<ProductEntity> productEntities){
        List<ProductDto> productDtos = new ArrayList<>();
        for(ProductEntity productEntity: productEntities){
            ProductDto productDto= new ProductDto(productEntity.getId(),productEntity.getDescription(),productEntity.getPrice(),productEntity.getName(),productEntity.getQuantity(),productEntity.getTotalPurchasesNumber());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static UserEntity userDtoToUserEntity(UserRegisterDto userRegisterDto){
        return new UserEntity(userRegisterDto.getUserName(),userRegisterDto.getEmail(),userRegisterDto.getPass(),userRegisterDto.getAddress(),userRegisterDto.getCreditLimit());
    }

    public static ProductEntity productDtoToProductEntity(ProductDto productDto){
        return new ProductEntity(productDto.getId(),productDto.getName(),productDto.getPrice(),productDto.getQuantity(),productDto.getDescription(),productDto.getTotalPurchasesNumber());
    }


    public static List<OrderDto> OrderEntityToOrderDto(List<OrderEntity> orderEntityList) {
        List<OrderDto> OrderDto = new ArrayList<>();
        for(OrderEntity orderEntity: orderEntityList){
            OrderDto orderDto= new OrderDto(orderEntity.getId(),orderEntity.getAddress(),orderEntity.getDateTime(),orderEntity.getEmail(),orderEntity.getPhoneNumber(),orderEntity.getTotalPrice().intValue());
            OrderDto.add(orderDto);
        }
        return OrderDto;
    }

    public static List<OrderDetailsDto> OrderDetailsEntityToOrderDetailsDto(List<OrderDetailsEntity> orderDetailsEntities) {
        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();
        //  public OrderDetailsDto(int orderId, int userId, int productId, int totalPrice, int quantity)
        for(OrderDetailsEntity orderDetailsEntity:orderDetailsEntities){
            OrderDetailsDto orderDetailsDto = new OrderDetailsDto(orderDetailsEntity.getId().getOrderId(),
                    orderDetailsEntity.getId().getUserId(),
                    (int) orderDetailsEntity.getId().getProductId(),
                    orderDetailsEntity.getPrice().intValue(),
                    orderDetailsEntity.getQuantity());

            orderDetailsDtoList.add(orderDetailsDto);
        }
        return orderDetailsDtoList;
    }
}
