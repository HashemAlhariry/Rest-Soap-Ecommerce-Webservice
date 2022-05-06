package backend.dto;


import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ProductDto {

    private int id;
    private String description;
    private double price;
    private String name;
    private int quantity;
    private int totalPurchasesNumber;

    public ProductDto(int id, String description, double price, String name, int quantity, int totalPurchasesNumber) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.totalPurchasesNumber = totalPurchasesNumber;
    }

    public ProductDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPurchasesNumber() {
        return totalPurchasesNumber;
    }

    public void setTotalPurchasesNumber(int totalPurchasesNumber) {
        this.totalPurchasesNumber = totalPurchasesNumber;
    }
}
