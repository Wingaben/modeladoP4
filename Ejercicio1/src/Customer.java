import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String dni;            // Identificación del cliente
    private String name;           // Nombre del cliente
    private List<Rental> rentals;  // Lista de alquileres del cliente

    // Constructor
    public Customer(String dni, String name) {
        this.dni = dni;
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    // Getters y setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    // Método para añadir un alquiler con validación de solapamiento
    public void addRental(Rental rental) {
        for (Rental existingRental : rentals) {
            if (datesOverlap(existingRental, rental)) {
                throw new IllegalArgumentException("No se pueden solapar las fechas de alquiler.");
            }
        }
        rentals.add(rental);
    }

    // Método auxiliar para verificar solapamiento de fechas
    private boolean datesOverlap(Rental r1, Rental r2) {
        return !(r1.getEndDate().toInstant().isBefore(r2.getStartDate().toInstant())) || r2.getEndDate().toInstant().isBefore(r1.getStartDate().toInstant());
    }

    // Operación: número de alquileres web con oficinas diferentes
    public int numberOfRentalsWithDifferentOffices() {
        int count = 0;
        for (Rental rental : rentals) {
            if (rental instanceof WebRental) {
                WebRental webRental = (WebRental) rental;
                if (!webRental.getPickUpOffice().equals(webRental.getDeliveryOffice())) {
                    count++;
                }
            }
        }
        return count;
    }

    // Método para mostrar información del cliente
    @Override
    public String toString() {
        return "Customer{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", rentals=" + rentals +
                '}';
    }
}
