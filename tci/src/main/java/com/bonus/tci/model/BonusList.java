package com.bonus.tci.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BonusList {
	
	
	@JsonProperty(value = "bonus")
	List<Bonus> bonus = new ArrayList<>();

	public List<Bonus> getBonus() {
		return bonus;
	}

	public void setBonus(List<Bonus> bonus) {
		this.bonus = bonus;
	}

}
