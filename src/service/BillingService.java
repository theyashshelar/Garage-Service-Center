package service;

import entity.Invoice;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BillingService {
    public static CustomerService customerService = new CustomerService();
    public static InvoiceService invoiceService = new InvoiceService();

    public static void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException {
        for (int serviceId : serviceIds) {
            invoiceService.addInvoice(new Invoice(0, customerId, vehicleId, serviceId));
        }
        System.out.println("Invoice(s) generated successfully");
    }

    public void showAllInvoices() throws SQLException {
        invoiceService.printAllInvoiceDetails();
    }

    public void showInvoicesByCustomer() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        invoiceService.printInvoiceByCustomerId(customerId);
    }
}
