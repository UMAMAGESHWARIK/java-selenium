package pkg_16082025;

import org.junit.jupiter.api.Test;
import java.sql.Date;

public class Junit {

    CustomerProductDAO dao = new CustomerProductDAO();

    @Test
    public void testInsertCustomer() {
        Customer c = new Customer(0, "TestUser", "9999999999", "M", "TestAddr", "TestCity", "123456");
        boolean result = dao.insertCustomer(c);
       
    }

    @Test
    public void testInsertProduct() {
        int custId = 1; 
        Product p = new Product(0, custId, "TEST003", "Test Product", 100.50, 5, Date.valueOf("2026-01-01"));
        boolean result = dao.insertProduct(p, custId);
        
    }

    @Test
    public void testBuyProduct() {
        int productId = 1; 
        int qty = 1;
        boolean result = dao.buyProduct(productId, qty);
       
    }

    @Test
    public void testDisplayCustomerProducts() {
        int custId = 1;
        dao.displayCustomerProducts(custId);
    }
}
