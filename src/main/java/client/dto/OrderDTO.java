package client.dto;

import java.time.LocalDateTime;

public class OrderDTO {
    private String orderId;
    private ShoppingCartDTO shoppingCartDTO;
    private CustomerDTO customerDTO;
    private LocalDateTime orderTime;
    private LocalDateTime checkoutTime;
    private double orderTotal;


    public OrderDTO(){}

    public double getOrderTotal() {
        return orderTotal;
    }

    public OrderDTO(String orderId, ShoppingCartDTO shoppingCartDTO, double orderTotal, CustomerDTO customerDTO, LocalDateTime orderTime, LocalDateTime checkoutTime) {
        this.orderId = orderId;
        this.shoppingCartDTO = shoppingCartDTO;
        this.orderTotal = orderTotal;
        this.customerDTO = customerDTO;
        this.orderTime = orderTime;
        this.checkoutTime = checkoutTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public ShoppingCartDTO getShoppingCartDTO() {
        return shoppingCartDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    @Override
    public String toString() {
        String response = "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", shoppingCartDTO=" + shoppingCartDTO;
        if(customerDTO != null){
            response += ", customerDTO=" + customerDTO +
                        ", orderTime=" + orderTime;
        }
        return  response +
                ", checkoutTime=" + checkoutTime +
                ", orderTotal=" + orderTotal +
                '}';
    }
}
