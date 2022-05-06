package backend.repos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter @Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    private String description;
    private int totalPurchasesNumber;

    public  ProductEntity(){

    }


    public ProductEntity(String name, double price, int quantity, String description ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public ProductEntity(int id, String name, double price, int quantity, String description, int totalPurchasesNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.totalPurchasesNumber = totalPurchasesNumber;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", totalPurchasesNumber=" + totalPurchasesNumber +
                '}';
    }


}
