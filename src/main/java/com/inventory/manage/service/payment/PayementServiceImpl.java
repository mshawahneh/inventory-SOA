/**
 * 
 */
package com.inventory.manage.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Payment;
import com.inventory.manage.repositories.PaymentRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author Noura
 *
 */
@Service("paymentsService")
//@Transactional
public class PayementServiceImpl implements PaymentService {

//	@Autowired
//	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		PersistenceService.save(payment);
		
		return (Payment) PersistenceService.getById(payment.getId());
	}

	@Override
	public boolean isExist(String id) {
		return PersistenceService.getById(id) != null;
	}

	@Override
	public List<Payment> getAllPayments() {
		return PersistenceService.getAllPayments();
	}

	@Override
	public boolean delete(Payment payment) {
		PersistenceService.delete(payment);
		return true;
	}
}
