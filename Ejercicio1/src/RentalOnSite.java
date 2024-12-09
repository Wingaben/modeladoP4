import java.util.Date;

public class RentalOnSite extends Rental {
    private String comments; // Comentarios sobre el alquiler

    public RentalOnSite(Date startDate, Date endDate, Car car, RentalOffice pickUpOffice, RentalOffice deliveryOffice, int deliveryTime, String comments) {
        super(startDate, endDate, car, pickUpOffice, deliveryOffice, deliveryTime);  // Llamada al constructor de la clase base con 6 parámetros
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String getDetails() {
        return "RentalOnSite{" +
                "comments='" + comments + '\'' +
                "} " + super.toString();
    }
}
