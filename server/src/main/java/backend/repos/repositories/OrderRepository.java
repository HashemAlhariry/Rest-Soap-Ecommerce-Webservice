package backend.repos.repositories;

import backend.dto.OrderDto;
import backend.repos.entities.OrderEntity;

import java.util.List;

public interface OrderRepository extends Repository<OrderEntity,Integer>{
    List<OrderDto> getOrdersByUserId(int id);
}
