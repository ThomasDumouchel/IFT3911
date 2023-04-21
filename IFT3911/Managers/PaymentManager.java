package Managers;

import Models.Payment.Payment;
import Models.Payment.PaymentInfo;

public class PaymentManager {

	/**
	 * 
	 * @param paymentInfo
	 */
	public Payment makePayment(PaymentInfo paymentInfo) {
		return new Payment(paymentInfo);
	}

}