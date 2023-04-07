package isp.lab4.exercise1;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Exercise1Test {

    @Test
    public void testAddress() {
        Address address = new Address("123 Main St", "Anytown");
        assertEquals("123 Main St", address.getStreet());
        assertEquals("Anytown", address.getCity());
    }

    @Test
    public void testProduct() {
        Product product = new Product("1", "Widget", 9.99, ProductCategory.ELECTRONICS);
        assertEquals("1", product.getProductId());
        assertEquals("Widget", product.getName());
        assertEquals(9.99, product.getPrice(), 0.0001);
        assertEquals(ProductCategory.ELECTRONICS, product.getProductCategory());
    }

    @Test
    public void testOrder() {
        Order order = new Order("1", LocalDateTime.now(), 29.98);
        assertEquals("1", order.getOrderId());
        assertNotNull(order.getDate());
        assertEquals(29.98, order.getTotalPrice(), 0.0001);
    }

    @Test
    public void testCustomer() {
        Address address = new Address("123 Main St", "Anytown");
        Customer customer = new Customer("1", "John Doe", "555-1234", address);
        assertEquals("1", customer.getCustomerId());
        assertEquals("John Doe", customer.getName());
        assertEquals("555-1234", customer.getPhone());
        assertEquals(address, customer.getAddress());
    }
}