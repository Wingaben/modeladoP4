import java.util.Date;

public class WebRental extends Rental {
    private RentalOffice deliveryOffice; // Oficina de entrega
    private int deliveryTime;            // Hora de entrega (0-23)

    public WebRental(Date startDate, Date endDate, Car car, RentalOffice pickUpOffice, RentalOffice deliveryOffice, int deliveryTime) {
        super(startDate, endDate, car, pickUpOffice, deliveryOffice, deliveryTime);
        if (!pickUpOffice.equals(deliveryOffice) && deliveryTime >= 13) {
            throw new IllegalArgumentException("La hora de entrega debe ser anterior a las 13:00 si las oficinas son diferentes.");
        }
        this.deliveryOffice = deliveryOffice;
        this.deliveryTime = deliveryTime;
    }

    public RentalOffice getDeliveryOffice() {
        return deliveryOffice;
    }

    public void setDeliveryOffice(RentalOffice deliveryOffice) {
        this.deliveryOffice = deliveryOffice;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String getDetails() {
        return "WebRental{" +
                "deliveryOffice=" + deliveryOffice +
                ", deliveryTime=" + deliveryTime +
                "} " + super.toString();
    }
}
