package pkg_16082025;
import java.sql.*;

public class CustomerProductDAO {

    // Insert Customer
    public boolean insertCustomer(Customer c) {
        String sql = "INSERT INTO customer(cust_name,cust_contact,cust_gender,cust_addr,city,zipcode) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCustName());
            ps.setString(2, c.getCustContact());
            ps.setString(3, c.getCustGender());
            ps.setString(4, c.getCustAddr());
            ps.setString(5, c.getCity());
            ps.setString(6, c.getZipcode());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Insert Product for a customer
    public boolean insertProduct(Product p, int custId) {
        String sql = "INSERT INTO product(cust_id,product_code,product_desc,product_price,product_qty,product_expdate) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, custId);
            ps.setString(2, p.getProductCode());
            ps.setString(3, p.getProductDesc());
            ps.setDouble(4, p.getProductPrice());
            ps.setInt(5, p.getProductQty());
            ps.setDate(6, p.getProductExpdate());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Buy Product (reduce quantity)
    public boolean buyProduct(int productId, int qty) {
        String sql = "UPDATE product SET product_qty = product_qty - ? WHERE product_id = ? AND product_qty >= ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, qty);
            ps.setInt(2, productId);
            ps.setInt(3, qty);

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Display customer and products with total price
    public void displayCustomerProducts(int custId) {
        String sql = "SELECT c.cust_name, p.product_code, p.product_desc, p.product_price, p.product_qty " +
                     "FROM customer c JOIN product p ON c.cust_id=p.cust_id WHERE c.cust_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, custId);
            ResultSet rs = ps.executeQuery();

            double total = 0;
            System.out.println("Customer Products:");
            while (rs.next()) {
                String name = rs.getString("cust_name");
                String code = rs.getString("product_code");
                String desc = rs.getString("product_desc");
                double price = rs.getDouble("product_price");
                int qty = rs.getInt("product_qty");

                System.out.println("Customer: " + name + " | Product: " + code + " | " + desc + " | Price: " + price + " | Qty: " + qty);
                total += price * qty;
            }
            System.out.println("Total Price: " + total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
