package pkg_16082025;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerProductDAO service = new CustomerProductDAO();
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Insert Customer");
            System.out.println("2. Insert Product");
            System.out.println("3. Buy Product");
            System.out.println("4. Display Customer Products");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Insert Customer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Gender (M/F/O): ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter Zipcode: ");
                    String zip = sc.nextLine();

                    Customer c = new Customer(0, name, contact, gender, addr, city, zip);
                    if (service.insertCustomer(c)) {
                        System.out.println("Customer Inserted.");
                    } else {
                        System.out.println("Insert Failed.");
                    }
                    break;

                case 2: // Insert Product
                    System.out.print("Enter Customer ID (existing): ");
                    int custIdP = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Product Code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String exp = sc.nextLine();

                    Product p = new Product(0, custIdP, code, desc, price, qty, Date.valueOf(exp));
                    if (service.insertProduct(p, custIdP)) {
                        System.out.println("Product Inserted.");
                    } else {
                        System.out.println("Insert Failed.");
                    }
                    break;

                case 3: // Buy Product
                    System.out.print("Enter Product ID: ");
                    int buyPid = sc.nextInt();
                    System.out.print("Enter Quantity to Buy: ");
                    int buyQty = sc.nextInt();
                    if (service.buyProduct(buyPid, buyQty)) {
                        System.out.println("Purchase successful.");
                    } else {
                        System.out.println("Not enough stock.");
                    }
                    break;

                case 4: // Display
                    System.out.print("Enter Customer ID: ");
                    int displayCid = sc.nextInt();
                    service.displayCustomerProducts(displayCid);
                    break;

                case 5: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
