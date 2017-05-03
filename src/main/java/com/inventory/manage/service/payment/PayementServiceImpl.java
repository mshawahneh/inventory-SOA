/**
 * 
 */
package com.inventory.manage.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.repositories.PaymentRepository;

/**
 * @author mshawahn
 *
 */
@Service("payementService")
@Transactional
public class PayementServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
}
