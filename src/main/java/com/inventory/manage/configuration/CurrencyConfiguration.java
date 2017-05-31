package com.inventory.manage.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.inventory.manage.service.currency.CurrencyConverterSOAPServiceImpl;
import com.inventory.manage.service.soap.QuoteClient;

@Configuration
public class CurrencyConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.inventory.manage.wsdl");
		return marshaller;
	}

	@Bean
	public CurrencyConverterSOAPServiceImpl currencyClient(Jaxb2Marshaller marshaller) {
		CurrencyConverterSOAPServiceImpl client = new CurrencyConverterSOAPServiceImpl();
		client.setDefaultUri("http://www.webservicex.com/currencyconvertor.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
