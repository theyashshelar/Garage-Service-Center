package service;

import config.DbConfig;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    public static void addVehicle(Vehicle vehicle) throws SQLException {
        Connection con = DbConfig.getConnection();
        String sql = "INSERT INTO vehicles (cust_id, number_plate, model) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, vehicle.getCustId());
        ps.setString(2, vehicle.getNumberPlate());
        ps.setString(3, vehicle.getModel());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public static List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> list = new ArrayList<>();
        Connection con = DbConfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM vehicles");

        while (rs.next()) {
            Vehicle v = new Vehicle(
                    rs.getInt("id"),
                    rs.getInt("cust_id"),
                    rs.getString("number_plate"),
                    rs.getString("model")
            );
            list.add(v);
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }

    public static Vehicle getVehicleById(int id) throws SQLException {
        Vehicle vehicle = null;
        Connection con = DbConfig.getConnection();
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            vehicle = new Vehicle(
                    rs.getInt("id"),
                    rs.getInt("cust_id"),
                    rs.getString("number_plate"),
                    rs.getString("model")
            );
        }

        rs.close();
        ps.close();
        con.close();
        return vehicle;
    }

    public static void printAllVehicles() throws SQLException {
        List<Vehicle> vehicles = getAllVehicles();
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle ID: " + v.getId() +
                    ", Customer ID: " + v.getCustId() +
                    ", Plate: " + v.getNumberPlate() +
                    ", Model: " + v.getModel());
        }
    }
}
