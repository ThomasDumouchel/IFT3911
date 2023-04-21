package Models.Payment;

import java.util.Date;

public class Payment {

	private int cardNumber;
	private Date paymentDate;

	public Payment(PaymentInfo paymentInfo) {
		this.cardNumber = paymentInfo.getCardNumber();
		this.paymentDate = new Date();
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

}