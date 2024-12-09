public class Car {
    private String licensePlate; // Matrícula del coche
    private Model model;         // Modelo al que pertenece el coche
    private RentalOffice assignedOffice; // Oficina asignada al coche

    // Constructor
    public Car(String licensePlate, Model model, RentalOffice assignedOffice) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.assignedOffice = assignedOffice;
    }

    // Getters y setters
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public RentalOffice getAssignedOffice() {
        return assignedOffice;
    }

    public void setAssignedOffice(RentalOffice assignedOffice) {
        this.assignedOffice = assignedOffice;
    }

    // Método para mostrar información del coche
    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", model=" + model.getName() +
                ", assignedOffice=" + assignedOffice.getAddress() +
                '}';
    }
}
