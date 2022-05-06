package backend.network.rest;


import backend.dto.OrderDetailsDto;
import backend.dto.OrderDto;
import backend.services.ServicesFactoryMethod;
import backend.services.inter.OrderService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;


@Path("orders")
public class OrderRestResource {

    private OrderService orderService = ServicesFactoryMethod.getOrderServiceImpl();

    @GET
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

}
