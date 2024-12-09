public class Model {
    private String name;        // Nombre del modelo
    private int pricePerDay;    // Precio por día de alquiler

    // Constructor
    public Model(String name, int pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    // Método para mostrar información del modelo
    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
