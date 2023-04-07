package isp.lab4.exercise1;

import java.time.LocalDateTime;


enum ProductCategory {
    ELECTRONICS, FASHION, HOME_AND_GARDEN, BEAUTY, TOYS
}

class Address {
    private String street;
    private String city;
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

// getters and setters for all attributes

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // association with Customer class
    private Customer[] customers;

    public void addCustomer(Customer customer) {
        // add the customer to the customers array
    }

    public void removeCustomer(Customer customer) {
        // remove the customer from the customers array
    }

    public Customer[] getCustomers() {
        return customers;
    }
}

class Product {
    private String productId;
    private String name;
    private double price;
    private ProductCategory productCategory;

    public Product(String productId, String name, double price, ProductCategory productCategory) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    // getters and setters for all attributes

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    // association with Customer class
    private Customer[] customers;

    public void addCustomer(Customer customer) {
        // add the customer to the customers array
    }

    public void removeCustomer(Customer customer) {
        // remove the customer from the customers array
    }

    public Customer[] getCustomers() {
        return customers;
    }

    // association with Order class
    private Order[] orders;

    public void addOrder(Order order) {
        // add the order to the orders array
    }

    public void removeOrder(Order order) {
        // remove the order from the orders array
    }

    public Order[] getOrders() {
        return orders;
    }
}

class Order {
    private String orderId;
    private final LocalDateTime date;
    private double totalPrice;

    public Order(String orderId, LocalDateTime date, double totalPrice) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    // getters and setters for all attributes

    public String getOrderId()
    {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // association with Product class
    private Product[] products;

    public void addProduct(Product product) {
        // add the product to the products array
    }

    public void removeProduct(Product product) {
        // remove the product from the products array
    }

    public Product[] getProducts() {
        return products;
    }

    // association with Customer class
    private Customer[] customers;

    public void addCustomer(Customer customer) {
        // add the customer to the customers array
    }

    public void removeCustomer(Customer customer) {
        // remove the customer from the customers array
    }

    public Customer[] getCustomers() {
        return customers;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address;

    public Customer(String customerId, String name, String phone, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    // getters and setters for all attributes

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // association with Product class
    private Product[] products;

    public void addProduct(Product product) {
        // add the product to the products array
    }

    public void removeProduct(Product product) {
        // remove the product from the products array
    }

    public Product[] getProducts() {
        return products;
    }

    // association with Order class
    private Order[] orders;

    public void addOrder(Order order) {
        // add the order to the orders array
    }

    public void removeOrder(Order order) {
        // remove the order from the orders array
    }

    public Order[] getOrders() {
        return orders;
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        // create some addresses
        Address address1 = new Address("123 Main St", "Anytown");
        Address address2 = new Address("456 Oak Ave", "Somecity");

        // create some customers
        Customer customer1 = new Customer("1", "John Doe", "555-1234", address1);
        Customer customer2 = new Customer("2", "Jane Smith", "555-5678", address2);

        // create some products
        Product product1 = new Product("1", "Widget", 9.99, ProductCategory.ELECTRONICS);
        Product product2 = new Product("2", "Gadget", 19.99, ProductCategory.ELECTRONICS);

        // create some orders
        Order order1 = new Order("1", LocalDateTime.now(), 29.98);
        Order order2 = new Order("2", LocalDateTime.now(), 39.98);

        // add associations between objects
        customer1.addOrder(order1);
        customer2.addOrder(order2);

        product1.addOrder(order1);
        product2.addOrder(order2);

        order1.addCustomer(customer1);
        order1.addProduct(product1);

        order2.addCustomer(customer2);
        order2.addProduct(product2);

    }
}

