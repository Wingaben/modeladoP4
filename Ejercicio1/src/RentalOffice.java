public class RentalOffice {
    private String address;       // Dirección de la oficina
    private int feeForDelivery;   // Cargo por entrega en otra oficina

    // Constructor
    public RentalOffice(String address, int feeForDelivery) {
        if (feeForDelivery < 0) {
            throw new IllegalArgumentException("El cargo por entrega no puede ser negativo.");
        }
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }

    // Getters y setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFeeForDelivery() {
        return feeForDelivery;
    }

    public void setFeeForDelivery(int feeForDelivery) {
        if (feeForDelivery < 0) {
            throw new IllegalArgumentException("El cargo por entrega no puede ser negativo.");
        }
        this.feeForDelivery = feeForDelivery;
    }

    @Override
    public String toString() {
        return "RentalOffice{" +
                "address='" + address + '\'' +
                ", feeForDelivery=" + feeForDelivery +
                '}';
    }
}
