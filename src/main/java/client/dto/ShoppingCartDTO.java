package client.dto;


import java.util.List;

public class ShoppingCartDTO {
    private String cardId;
    private List<CartItem> cartItems;

    public ShoppingCartDTO(){}

    public ShoppingCartDTO(String cardId, List<CartItem> cartItems) {
        this.cardId = cardId;
        this.cartItems = cartItems;
    }

    public String getCardId() {
        return cardId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "cardId='" + cardId + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }
}
