package backend.services.impl;

import backend.dto.OrderDetailsDto;
import backend.dto.OrderDto;
import backend.repos.dbconnector.Connector;
import backend.repos.repositories.OrderRepository;
import backend.repos.repositories.impl.OrderRepositoryImpl;
import backend.repos.utils.Mapper;
import backend.services.inter.OrderService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;


public class OrderServiceImpl implements OrderService {
    private EntityManager entityManager =  Connector.getInstance().getEntityManager();
    private OrderRepository orderRepository = new OrderRepositoryImpl(entityManager);


    @Override
    public List<OrderDto> getAllOrders() {

        Query query = entityManager.createQuery("SELECT c FROM OrderEntity c");
        List<OrderDto> orderDtoList = Mapper.OrderEntityToOrderDto(query.getResultList());

        for (int i=0;i<orderDtoList.size();i++){
            int currOrderId = orderDtoList.get(i).getOrderId();
            Query queryOrderDetails = entityManager.createQuery("SELECT c from OrderDetailsEntity  c where c.id.orderId = "+currOrderId);
            List<OrderDetailsDto> orderDetailsDtos = Mapper.OrderDetailsEntityToOrderDetailsDto(queryOrderDetails.getResultList());
            orderDtoList.get(i).setOrderDetailsDto(orderDetailsDtos);
        }

        return  orderDtoList;
    }

    @Override
    public List<OrderDto> getAllOrdersToUser(int id) {
        return  orderRepository.getOrdersByUserId(id);
    }


}

