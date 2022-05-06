package backend.repos.repositories.impl;

import backend.dto.OrderDetailsDto;
import backend.dto.OrderDto;
import backend.repos.entities.OrderEntity;
import backend.repos.repositories.OrderRepository;
import backend.repos.utils.Mapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;


public class OrderRepositoryImpl extends RepositoryImpl<OrderEntity,Integer>  implements OrderRepository {

    public OrderRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public List<OrderDto> getOrdersByUserId(int id) {
        Query query = entityManager.createQuery("SELECT c FROM OrderEntity c where c.userId = "+id);
        List<OrderDto> orderDtoList = Mapper.OrderEntityToOrderDto(query.getResultList());

        for (int i=0;i<orderDtoList.size();i++){
            int currOrderId = orderDtoList.get(i).getOrderId();
            Query queryOrderDetails = entityManager.createQuery("SELECT c from OrderDetailsEntity  c where c.id.userId =  "+ id +" AND c.id.orderId =  "+currOrderId);
            List<OrderDetailsDto> orderDetailsDtos = Mapper.OrderDetailsEntityToOrderDetailsDto(queryOrderDetails.getResultList());
            orderDtoList.get(i).setOrderDetailsDto(orderDetailsDtos);
        }

        return  orderDtoList;

    }
}

