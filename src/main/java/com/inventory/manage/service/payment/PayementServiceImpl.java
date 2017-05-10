/**
 * 
 */
package com.inventory.manage.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Payment;
import com.inventory.manage.repositories.PaymentRepository;

/**
 * @author Noura
 *
 */
@Service("paymentsService")
@Transactional
public class PayementServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean isExist(String name) {
		// TODO To be implemented
		return false;
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean delete(Payment payment) {
		// TODO To be implemented
		return false;
	}
}
