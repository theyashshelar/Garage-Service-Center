package service;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public static void addCustomer(Customer customer) throws SQLException {
        Connection con = DbConfig.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO customer (cust_name, phone_no) VALUES (?,?)");
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public static Customer getCustomerBasedOnNum(String number) throws SQLException {
        Customer customer = null;
        Connection con = DbConfig.getConnection();
        String query = "SELECT * FROM customer WHERE phone_no = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, number);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            customer = new Customer(
                    rs.getInt("id"),
                    rs.getString("cust_name"),
                    rs.getString("phone_no")
            );
        }

        rs.close();
        ps.close();
        con.close();
        return customer;
    }

    public static List<Customer> getAllCustomers() throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection con = DbConfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customer");
        while (rs.next()) {
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("cust_name"), rs.getString("phone_no")));
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

    public static void printAllCustomers() throws SQLException {
        List<Customer> customers = getAllCustomers();
        for (Customer c : customers) {
            System.out.println("Customer ID: " + c.getId() + ", Name: " + c.getName() + ", Phone: " + c.getPhone());
        }
    }
}
