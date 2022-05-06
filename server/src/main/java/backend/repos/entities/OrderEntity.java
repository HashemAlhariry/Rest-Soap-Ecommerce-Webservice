package backend.repos.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter

public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateTime;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private String phoneNumber;
    private String address;
    private String email;

    private int userId;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetailsEntity> orderDetails = new HashSet<>();


    public OrderEntity(LocalDateTime dateTime, BigDecimal totalPrice, String phoneNumber, String address, Set<OrderDetailsEntity> orderDetails,int userId) {

        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderDetails = orderDetails;
        this.userId=userId;
    }

    public OrderEntity() {

    }
}
