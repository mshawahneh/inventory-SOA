/**
 * 
 */
package com.inventory.manage.service.currency;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.inventory.manage.wsdl.ConversionRateResponse;
import com.inventory.manage.wsdl.Currency;
import com.inventory.manage.wsdl.ConversionRate;
/**
 * @author mshawahn
 *
 */
@Service("currencyService")
public class CurrencyConverterSOAPServiceImpl extends WebServiceGatewaySupport implements CurrencyConverterSOAPService {

//	/**
//	 * @see com.inventory.manage.service.currency.CurrencyConverterSOAPService#convertCurrency(int, java.lang.String, java.lang.String)
//	 */
//	@Override
//	public int convertCurrency(int amount, String fromCurrency, String toCurrency) {
//
//		return 0;//getCurrencyConversionRate(fromCurrency, toCurrency) * amount;
//	}
	
	double getCurrencyConversionRate(String fromCurrency, String toCurrency){
		ConversionRate request = new ConversionRate();
	
		request.setFromCurrency(Currency.USD);
		request.setToCurrency(Currency.ILS);
		ConversionRateResponse response =(ConversionRateResponse)getWebServiceTemplate().marshalSendAndReceive("http://www.webservicex.com/currencyconvertor.asmx",
				request,
				new SoapActionCallback("http://www.webservicex.com/currencyconvertor"));//.asmx?op=ConversionRate"));
		double rate = 1;
		try{
			System.out.println(response);
			 rate = response.getConversionRateResult();
			 System.out.println("SOAP rate = "+rate);
			 if(rate < 0){
				 rate = 1;
			 }
		}catch (Exception e) {
			rate = 1;
		}
				
		return rate;
	}

	@Override
	public int convertCurrency(int ammount, String fromCurrency, String toCurrency) {
		
		return (int) (getCurrencyConversionRate(fromCurrency, toCurrency) * ammount);
	}

}
