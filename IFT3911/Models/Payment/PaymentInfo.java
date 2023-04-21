package Models.Payment;
public class PaymentInfo {

    private int cardNumber;
    private int cvv;

    public PaymentInfo(int cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }
}