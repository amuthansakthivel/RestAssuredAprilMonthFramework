package com.tmb.requests.builders;

import com.tmb.requests.pojo.FavFood;

public class FavFoodBuilder {
	
	private String breakfast;
	private String lunch;
	private String dinner;
	
	public FavFoodBuilder given() {
		return this;
	}
	public FavFoodBuilder then() {
		return this;
	}
	
	public FavFoodBuilder when() {
		return this;
	}
	public FavFoodBuilder and() {
		return this;
	}
	
	public String getBreakfast() {
		return breakfast;
	}
	public FavFoodBuilder setBreakfast(String breakfast) {
		this.breakfast = breakfast;
		return this;
	}
	public String getLunch() {
		return lunch;
	}
	public FavFoodBuilder setLunch(String lunch) {
		this.lunch = lunch;
		return this;
	}
	public String getDinner() {
		return dinner;
	}
	public FavFoodBuilder setDinner(String dinner) {
		this.dinner = dinner;
		return this;
	}
	
	public FavFoodBuilder build() {
		return this;
	}
	
	public FavFood perform() {
		return new FavFood(this.breakfast,this.lunch,this.dinner);
	}

}
