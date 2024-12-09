import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public abstract class Rental {
    private Date startDate; // Fecha de inicio del alquiler
    private Date endDate;   // Fecha de finalización del alquiler
    private Car car;             // Coche alquilado
    private RentalOffice pickUpOffice; // Oficina de recogida
    private RentalOffice deliveryOffice; // Oficina de entrega
    private int deliveryTime; // Hora de entrega en formato 0-23

    // Constructor
    public Rental(Date startDate, Date endDate, Car car, RentalOffice pickUpOffice, RentalOffice deliveryOffice, int deliveryTime) {
        if (startDate.toInstant().isAfter(endDate.toInstant())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de finalización.");
        }
        if (!car.getAssignedOffice().equals(pickUpOffice)) {
            throw new IllegalArgumentException("La oficina de recogida debe coincidir con la oficina asignada al coche.");
        }
        if (deliveryOffice != null && !pickUpOffice.equals(deliveryOffice) && (deliveryTime < 0 || deliveryTime > 23 || deliveryTime >= 13)) {
            throw new IllegalArgumentException("Si las oficinas de recogida y entrega son diferentes, la hora de entrega debe ser un número entre 0 y 23, y anterior a las 13.");
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.pickUpOffice = pickUpOffice;
        this.deliveryOffice = deliveryOffice;
        this.deliveryTime = deliveryTime;
    }

    // Getters y setters
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate.toInstant().isAfter(this.endDate.toInstant())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de finalización.");
        }
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if (this.startDate.toInstant().isAfter(endDate.toInstant())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de finalización.");
        }
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("El coche no puede ser nulo.");
        }
        this.car = car;
    }

    public RentalOffice getPickUpOffice() {
        return pickUpOffice;
    }

    public void setPickUpOffice(RentalOffice pickUpOffice) {
        if (!car.getAssignedOffice().equals(pickUpOffice)) {
            throw new IllegalArgumentException("La oficina de recogida debe coincidir con la oficina asignada al coche.");
        }
        this.pickUpOffice = pickUpOffice;
    }

    public RentalOffice getDeliveryOffice() {
        return deliveryOffice;
    }

    public void setDeliveryOffice(RentalOffice deliveryOffice) {
        if (deliveryOffice != null && !pickUpOffice.equals(deliveryOffice) && (deliveryTime < 0 || deliveryTime > 23 || deliveryTime >= 13)) {
            throw new IllegalArgumentException("Si las oficinas de recogida y entrega son diferentes, la hora de entrega debe ser un número entre 0 y 23, y anterior a las 13.");
        }
        this.deliveryOffice = deliveryOffice;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        if (deliveryOffice != null && !pickUpOffice.equals(deliveryOffice) && (deliveryTime < 0 || deliveryTime > 23 || deliveryTime >= 13)) {
            throw new IllegalArgumentException("Si las oficinas de recogida y entrega son diferentes, la hora de entrega debe ser un número entre 0 y 23, y anterior a las 13.");
        }
        this.deliveryTime = deliveryTime;
    }

    // Método abstracto para ser implementado en las subclases
    public abstract String getDetails();

    @Override
    public String toString() {
        return "Rental{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", car=" + car +
                ", pickUpOffice=" + pickUpOffice +
                ", deliveryOffice=" + deliveryOffice +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}
