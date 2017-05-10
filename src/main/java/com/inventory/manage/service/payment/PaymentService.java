/**
 * 
 */
package com.inventory.manage.service.payment;

import java.util.List;

import com.inventory.manage.model.Payment;

/**
 * @author Noura
 *
 */
public interface PaymentsService {

	/**
	 * Add new payment
	 * @param payment
	 * @return An Payment
	 */
	public Payment addPayment(Payment payment);
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * Get all payments
	 * @return
	 * @throws DAOException
	 */
    public List<Payment> getAllPayments();

    /**
     * Delete an Payment
     * @param payment
     * @return
     */
	public boolean delete(Payment payment);
}
