package backend.dto;


import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class OrderDetailsDto {
     private int orderId;
     private int userId;
     private int productId;
     private int totalPrice;
     private int quantity;


     public OrderDetailsDto() {
     }

     public OrderDetailsDto(int orderId, int userId, int productId, int totalPrice, int quantity) {
          this.orderId = orderId;
          this.userId = userId;
          this.productId = productId;
          this.totalPrice = totalPrice;
          this.quantity = quantity;

     }

     public int getOrderId() {
          return orderId;
     }

     public void setOrderId(int orderId) {
          this.orderId = orderId;
     }

     public int getUserId() {
          return userId;
     }

     public void setUserId(int userId) {
          this.userId = userId;
     }

     public int getProductId() {
          return productId;
     }

     public void setProductId(int productId) {
          this.productId = productId;
     }

     public int getTotalPrice() {
          return totalPrice;
     }

     public void setTotalPrice(int totalPrice) {
          this.totalPrice = totalPrice;
     }

     public int getQuantity() {
          return quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }


}
