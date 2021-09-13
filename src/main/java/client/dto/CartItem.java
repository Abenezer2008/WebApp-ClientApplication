package client.dto;

public class CartItem {
    private String cartId;
    private Product product;
    private int quantity;

    public CartItem(){}

    public CartItem(String cartId, Product product, int quantity) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getCartId() {
        return cartId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartId='" + cartId + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
