import entity.Customer;
import entity.Vehicle;
import service.BillingService;
import service.CustomerService;
import service.VehicleService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BillingService billingService = new BillingService();

        while (true) {
            System.out.println("1. Add Customer with Vehicle\n2. Generate Invoice \n3. Show Invoice\n4. Show Invoices by Customer\n5. Show All Customers\n6. Show All Vehicles\n7. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Customer name: ");
                    String name = sc.next();
                    System.out.print("Customer Phone no: ");
                    String phone = sc.next();

                    CustomerService.addCustomer(new Customer(0, name, phone));
                    Customer customerBasedOnNum = CustomerService.getCustomerBasedOnNum(phone);

                    System.out.print("Enter Vehicle number: ");
                    String vehicleNum = sc.next();
                    System.out.print("Enter Vehicle model: ");
                    String model = sc.next();
                    VehicleService.addVehicle(new Vehicle(customerBasedOnNum.getId(), vehicleNum, model));
                    System.out.println("Customer and Vehicle added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Customer Id: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter Vehicle Id: ");
                    int vid = sc.nextInt();
                    System.out.print("Enter Number of Services: ");
                    int n = sc.nextInt();
                    List<Integer> sids = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter the Service id: ");
                        sids.add(sc.nextInt());
                    }
                    BillingService.createInvoice(cid, vid, sids);
                    break;

                case 3:
                    billingService.showAllInvoices();
                    break;

                case 4:
                    billingService.showInvoicesByCustomer();
                    break;

                case 5:
                    CustomerService.printAllCustomers();
                    break;

                case 6:
                    VehicleService.printAllVehicles();
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter a valid Choice");
            }
        }
    }
}
