package backend.network.soap;


import backend.dto.OrderDto;
import backend.services.ServicesFactoryMethod;
import backend.services.inter.OrderService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class OrderSoapResource {
    private OrderService orderService = ServicesFactoryMethod.getOrderServiceImpl();

    @WebMethod
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
