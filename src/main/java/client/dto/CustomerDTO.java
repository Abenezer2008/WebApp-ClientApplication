package client.dto;

public class CustomerDTO {
    private String customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String zip;

    public CustomerDTO(){}

    public CustomerDTO(String customerId, String firstName, String lastName, String phone, String email, String street, String city, String zip) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
