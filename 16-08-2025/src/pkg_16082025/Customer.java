package pkg_16082025;
public class Customer {
    private int custId;
    private String custName;
    private String custContact;
    private String custGender;
    private String custAddr;
    private String city;
    private String zipcode;

    // Constructor
    public Customer(int custId, String custName, String custContact, String custGender,
                    String custAddr, String city, String zipcode) {
        this.custId = custId;
        this.custName = custName;
        this.custContact = custContact;
        this.custGender = custGender;
        this.custAddr = custAddr;
        this.city = city;
        this.zipcode = zipcode;
    }

    // Getters
    public int getCustId() {
    	return custId; 
    	}
    public String getCustName() {
    	return custName; 
    	}
    public String getCustContact() { 
    	return custContact; 
    	}
    public String getCustGender() {
    	return custGender; 
    	}
    public String getCustAddr() { 
    	return custAddr; 
    	}
    public String getCity() {
    	return city; 
    	}
    public String getZipcode() {
    	return zipcode; 
    	}
}
