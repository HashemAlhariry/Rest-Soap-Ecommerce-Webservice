package backend.dto;


import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement
public class OrderDto {


    private int orderId;
    private String address;
    private LocalDateTime time;
    private String email;
    private String phoneNumber;
    private int totalPrice;

    private List<OrderDetailsDto> orderDetailsDto;

    public List<OrderDetailsDto> getOrderDetailsDto() {
        return orderDetailsDto;
    }

    public void setOrderDetailsDto(List<OrderDetailsDto> orderDetailsDto) {
        this.orderDetailsDto = orderDetailsDto;
    }

    public OrderDto(int orderId , String address, LocalDateTime time, String email, String phoneNumber, int totalPrice) {
        this.orderId=orderId;
        this.address = address;
        this.time = time;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderDto() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}



