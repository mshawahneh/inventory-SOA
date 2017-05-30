/**
 * 
 */
package com.inventory.manage.service.orchestration;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import com.inventory.manage.model.Bmi;
import com.inventory.manage.model.Health;
import com.inventory.manage.model.Recipe;

/**
 * @author rkhalayl
 *
 */
public class HealthInfoImpl implements HealthInfo{

	final static Logger logger = Logger.getLogger(HealthInfoImpl.class);
	public static String BASE_URL = "http://bzu-nutriserve.appspot.com";
	public static String HEALTH_STATUS_URL = "/healthstatus?userid={id}";
	public static String BMI_URL = "/bmi?weight={weight}&length={height}";
	public static String RECIPE_URL = "/recipe/{id}";
	
	/**
	 * Call an external service to get some health information about the employee
	 */
	@Override
	public Health getEmployeeHealthInfo(String id) {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 Health healthInfo = restTemplate.getForObject(BASE_URL + HEALTH_STATUS_URL, Health.class, id);
		 logger.debug("Employee Info :" + healthInfo);
		return healthInfo;
	}

	/**
	 * Call an external service to get the BMI value based on the weight and height
	 * @param weight
	 * @param height
	 */
	@Override
	public Bmi getBmi(int weight, int height) {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 Bmi bmi = restTemplate.getForObject(BASE_URL + BMI_URL, Bmi.class, weight, height);
		 logger.debug("BMI Info :" + bmi);
		return bmi;
	}
	
	/**
	 * Call and external service to get Free Personal Recipes supported for NutreServe users
	 * @param id
	 */
	@Override
	public Recipe getRecipe(int id) {
		RestTemplate restTemplate = new RestTemplate();
		 
		Recipe recipe = restTemplate.getForObject(BASE_URL + RECIPE_URL, Recipe.class, id);
		logger.debug("RECIPE Info :" + recipe);
		return recipe;
	}
	

}
