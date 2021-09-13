package client;

import client.dto.CustomerDTO;
import client.dto.OrderDTO;
import client.dto.ProductDTO;
import client.dto.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
    @Autowired
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/";

        //add Customer
       ResponseEntity<CustomerDTO> resp = restTemplate.postForEntity(serverUrl+"/customers",new CustomerDTO("111","john","doe","12345","jdoe@mail.com","street1","city1","zip1"),CustomerDTO.class);
       CustomerDTO respDTO = resp.getBody();

       //retrieve Customer
       System.out.println("Retrieving Customer");
       ResponseEntity<CustomerDTO> resp1 = restTemplate.getForEntity(serverUrl+"/customers/111",CustomerDTO.class);
       CustomerDTO respDTO1 = resp1.getBody();
       System.out.println("Customer : "  + respDTO1);

       //add Product
        ResponseEntity<ProductDTO> resp2 = restTemplate.postForEntity(serverUrl+"/products",new ProductDTO("222","Dell Monitor",274,"27'' monitor",16),ProductDTO.class);
        ProductDTO respDTO2 = resp2.getBody();


        //add Product
        ResponseEntity<ProductDTO> resp3 = restTemplate.postForEntity(serverUrl+"/products",new ProductDTO("223","ZTE mobile",187,"4G connectivity",13),ProductDTO.class);
        ProductDTO respDTO3 = resp3.getBody();

        //Retrieve Product
        System.out.println("Retrieving Product");
        ResponseEntity<ProductDTO> resp8 = restTemplate.getForEntity(serverUrl+"/products/223",ProductDTO.class);
        ProductDTO respDTO8 = resp8.getBody();
        System.out.println("Product : " + respDTO8);

        //create Cart
        ResponseEntity resp4 = restTemplate.postForEntity(serverUrl+"/carts/command/333",null,Object.class);

        //add to Cart
        restTemplate.put(serverUrl+"/carts/command/add-product/333/quantity/4",respDTO2);

        //add to Cart
        restTemplate.put(serverUrl+"/carts/command/add-product/333/quantity/3",respDTO2);

        //remove from Cart
        restTemplate.put(serverUrl+"/carts/command/remove-product/333/quantity/2",respDTO2);

        Thread.sleep(5000);

        //Retrieve Cart
        System.out.println("Retrieving Shopping Cart");
        ResponseEntity<ShoppingCartDTO> resp5 = restTemplate.getForEntity(serverUrl+"/carts/query/cart/333",ShoppingCartDTO.class);
        ShoppingCartDTO respDTO5 = resp5.getBody();
        System.out.println("Shopping Cart : " + respDTO5);

        //Check Out Cart
        System.out.println("Checking Out");
        ResponseEntity<OrderDTO> resp6 = restTemplate.postForEntity(serverUrl+"/carts/query/checkout/333/order/444",null,OrderDTO.class);
        OrderDTO respDTO6 = resp6.getBody();
        System.out.println("Order : " + respDTO6);

        //add Customer to Order and Place Order
        restTemplate.put(serverUrl+"/orders/444",respDTO1);

        //Retrieve Order
        System.out.println("Retrieving Order");
        ResponseEntity<OrderDTO> resp7 = restTemplate.getForEntity(serverUrl+"/orders/444",OrderDTO.class);
        OrderDTO respDTO7 = resp7.getBody();
        System.out.println("Order : " + respDTO7);

    }

    @Bean
    RestOperations restTemplate(){return new RestTemplate();}
}
