package backend.services;

import backend.services.impl.OrderServiceImpl;
import backend.services.impl.ProductServiceImpl;
import backend.services.impl.UserServiceImpl;

public class ServicesFactoryMethod {

    public static UserServiceImpl getUserServiceImpl(){
        return new UserServiceImpl();
    }
    public static ProductServiceImpl getProductServiceImpl(){
        return new ProductServiceImpl();
    }

    public static OrderServiceImpl getOrderServiceImpl() {
        return new OrderServiceImpl();
    }

}
