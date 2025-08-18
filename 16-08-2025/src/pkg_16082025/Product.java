package pkg_16082025;
import java.sql.Date;

public class Product {
    private int productId;
    private int custId;
    private String productCode;
    private String productDesc;
    private double productPrice;
    private int productQty;
    private Date productExpdate;

    public Product(int productId, int custId, String productCode, String productDesc,
                   double productPrice, int productQty, Date productExpdate) {
        this.productId = productId;
        this.custId = custId;
        this.productCode = productCode;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productExpdate = productExpdate;
    }

    public int getProductId() {
    	return productId;
    	}
    public int getCustId() {
    	return custId; 
    	}
    public String getProductCode() {
    	return productCode; 
    	}
    public String getProductDesc() {
    	return productDesc;
    	}
    public double getProductPrice() {
    	return productPrice;
    	}
    public int getProductQty() {
    	return productQty;
    	}
    public Date getProductExpdate() {
    	return productExpdate;
    	}
}
