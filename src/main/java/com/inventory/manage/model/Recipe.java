/**
 * 
 */
package com.inventory.manage.model;

/**
 * @author rkhalayl
 *
 */
public class Recipe {
	private long id;
	private String name;
	private String description;
	private String cuisine;
	private String imageUrl;
	private String recipeurl;
	private long calories;
	private String nextRecipeApi;
	private String previousRecipeApi;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getRecipeurl() {
		return recipeurl;
	}
	public void setRecipeurl(String recipeurl) {
		this.recipeurl = recipeurl;
	}
	public long getCalories() {
		return calories;
	}
	public void setCalories(long calories) {
		this.calories = calories;
	}
	public String getNextRecipeApi() {
		return nextRecipeApi;
	}
	public void setNextRecipeApi(String nextRecipeApi) {
		this.nextRecipeApi = nextRecipeApi;
	}
	public String getPreviousRecipeApi() {
		return previousRecipeApi;
	}
	public void setPreviousRecipeApi(String previousRecipeApi) {
		this.previousRecipeApi = previousRecipeApi;
	}
	
	
}
