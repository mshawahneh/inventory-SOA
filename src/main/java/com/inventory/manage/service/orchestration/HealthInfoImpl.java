/**
 * 
 */
package com.inventory.manage.service.orchestration;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.inventory.manage.model.Health;

/**
 * @author rkhalayl
 *
 */
public class HealthInfoImpl implements HealthInfo{

	final static Logger logger = Logger.getLogger(HealthInfoImpl.class);
	
	private final static String EXTERNAL_SERVICE_URL = "http://bzu-nutriserve.appspot.com/healthstatus?userid={id}";
	/**
	 * Call an external service to get some health information about the employee
	 */
	@Override
	public Health getEmployeeHealthInfo(String id) {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 Health healthInfo = restTemplate.getForObject(EXTERNAL_SERVICE_URL, Health.class, id);
		 logger.debug("Employee Info :" + healthInfo);
		return healthInfo;
	}
	
	
	

}
