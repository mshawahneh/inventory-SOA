/**
 * 
 */
package com.inventory.manage.service.currency;

/**
 * @author mshawahn
 *
 */
public interface CurrencyConverterSOAPService {

	/**
	 * Convert an amount of currency from one to another in order to support currency 
	 * exchange in order.
	 * @param ammount
	 * @param fromCurrency
	 * @param toCurrency
	 * @return
	 */
	int convertCurrency(int ammount, String fromCurrency, String toCurrency);
}
