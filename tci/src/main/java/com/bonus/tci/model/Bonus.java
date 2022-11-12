
package com.bonus.tci.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
//shape=JsonFormat.Shape.STRING, 
public class Bonus {
	
	@JsonProperty(value = "empName")
	public String empName;
	@JsonProperty(value = "amount")
	public long amount;
	@JsonProperty(value = "currency")
	public String currency;
	@JsonProperty(value = "joiningDate")
	@JsonFormat(pattern="MMM-dd-yyyy")
	public Date joiningDate;
	@JsonProperty(value = "exitDate")
	@JsonFormat(pattern="MMM-dd-yyyy")
	public Date exitDate;
	
	public Bonus() {
		super();
		
	}
	public Bonus(String empName, long amount, String currency, Date joiningDate, Date exitDate) {
		super();
		this.empName = empName;
		this.amount = amount;
		this.currency = currency;
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
	}
	@Override
	public String toString() {
		return "Bonus [empName=" + empName + ", amount=" + amount + ", currency=" + currency + ", joiningDate="
				+ joiningDate + ", exitDate=" + exitDate + "]";
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getExitDate() {
		return exitDate;
	}
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	
}
