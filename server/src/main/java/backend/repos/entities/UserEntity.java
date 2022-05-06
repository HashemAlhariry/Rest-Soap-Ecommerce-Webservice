package backend.repos.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=100;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String pass;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private BigDecimal creditLimit = new BigDecimal(0);

    @OneToMany(mappedBy = "user")
    private Set<OrderDetailsEntity> orderDetails = new HashSet<>();

    public UserEntity() {

    }

    public UserEntity(String userName, String email, String pass, String address, BigDecimal creditLimit) {
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", address='" + address + '\'' +
                ", creditLimit=" + creditLimit +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
