/**
 * 
 */
package com.inventory.manage.service.orchestration;

import com.inventory.manage.model.Bmi;
import com.inventory.manage.model.Health;
import com.inventory.manage.model.Recipe;

/**
 * @author rkhalayl
 *
 */
public interface HealthInfo {
	
	public Health getEmployeeHealthInfo(String id);
	
	public Bmi getBmi(int weight, int height);
	
	public Recipe getRecipe(int id);
}
