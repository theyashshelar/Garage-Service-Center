package entity;

public class Vehicle {
    private int id;
    private int custId;
    private String numberPlate;
    private String model;

    public Vehicle(int custId, String numberPlate, String model) {
        this.custId = custId;
        this.numberPlate = numberPlate;
        this.model = model;
    }

    public Vehicle(int id, int custId, String numberPlate, String model) {
        this.id = id;
        this.custId = custId;
        this.numberPlate = numberPlate;
        this.model = model;
    }

    // Getters and Setters

    public int getId() { return id; }
    public int getCustId() { return custId; }
    public String getNumberPlate() { return numberPlate; }
    public String getModel() { return model; }

    public void setId(int id) { this.id = id; }
    public void setCustId(int custId) { this.custId = custId; }
    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }
    public void setModel(String model) { this.model = model; }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", custId=" + custId +
                ", numberPlate='" + numberPlate + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
