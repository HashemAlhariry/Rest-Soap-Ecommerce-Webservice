package backend.services.inter;

import backend.dto.OrderDetailsDto;
import backend.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrdersToUser(int id);

}
