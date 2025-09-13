package service;

import config.DbConfig;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    public void addInvoice(Invoice invoice) throws SQLException {
        Connection con = DbConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO invoices (cust_id, vehicle_id, service_id) VALUES (?,?,?)");
        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVehicleId());
        ps.setInt(3, invoice.getServiceId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> list = new ArrayList<>();
        Connection con = DbConfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM invoices");

        while (rs.next()) {
            list.add(new Invoice(
                    rs.getInt("id"),
                    rs.getInt("cust_id"),
                    rs.getInt("vehicle_id"),
                    rs.getInt("service_id")));
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }

    public void printAllInvoiceDetails() throws SQLException {
        Connection con = DbConfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT i.id, c.cust_name, c.phone_no, v.number_plate, v.model, " +
                        "s.description, s.cost, i.date " +
                        "FROM invoices i " +
                        "JOIN customer c ON i.cust_id = c.id " +
                        "JOIN vehicles v ON i.vehicle_id = v.id " +
                        "JOIN service s ON i.service_id = s.id"
        );

        while (rs.next()) {
            System.out.println("===== Invoice #" + rs.getInt("id") + " =====");
            System.out.println("Customer: " + rs.getString("cust_name"));
            System.out.println("Phone: " + rs.getString("phone_no"));
            System.out.println("Vehicle: " + rs.getString("number_plate") + " (" + rs.getString("model") + ")");
            System.out.println("Service: " + rs.getString("description"));
            System.out.println("Cost: ₹" + rs.getDouble("cost"));
            System.out.println("Date: " + rs.getTimestamp("date"));
            System.out.println("========================\n");
        }

        rs.close();
        st.close();
        con.close();
    }

    public void printInvoiceByCustomerId(int customerId) throws SQLException {
        Connection con = DbConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT i.id, c.cust_name, c.phone_no, v.number_plate, v.model, " +
                        "s.description, s.cost, i.date " +
                        "FROM invoices i " +
                        "JOIN customer c ON i.cust_id = c.id " +
                        "JOIN vehicles v ON i.vehicle_id = v.id " +
                        "JOIN service s ON i.service_id = s.id " +
                        "WHERE c.id = ?"
        );
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();

        boolean hasInvoice = false;

        while (rs.next()) {
            hasInvoice = true;
            System.out.println("===== Invoice #" + rs.getInt("id") + " =====");
            System.out.println("Customer: " + rs.getString("cust_name"));
            System.out.println("Phone: " + rs.getString("phone_no"));
            System.out.println("Vehicle: " + rs.getString("number_plate") + " (" + rs.getString("model") + ")");
            System.out.println("Service: " + rs.getString("description"));
            System.out.println("Cost: ₹" + rs.getDouble("cost"));
            System.out.println("Date: " + rs.getTimestamp("date"));
            System.out.println("========================\n");
        }

        if (!hasInvoice) {
            System.out.println("No invoices found for customer ID: " + customerId);
        }

        rs.close();
        ps.close();
        con.close();
    }
}
