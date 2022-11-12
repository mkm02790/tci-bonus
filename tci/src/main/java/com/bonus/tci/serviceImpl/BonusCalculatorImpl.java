package com.bonus.tci.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bonus.tci.dataTransalater.EmployeeMapper;
import com.bonus.tci.model.Bonus;
import com.bonus.tci.model.Employee;
import com.bonus.tci.service.BonusCalculator;
@Component
public class BonusCalculatorImpl implements BonusCalculator{
	
	@Autowired
	EmployeeMapper employeeMapper ;
	
	Map<String, List<Employee>> res =null ;
	
	@Override
	public Map<String, List<Employee>> calculate(List<Bonus> bn) {
		Date todaysDate =new java.util.Date();
		List<Bonus> bonusList = new ArrayList<>();
		for(Bonus bno : bn) {
			if(todaysDate.after(bno.joiningDate)  && todaysDate.before(bno.exitDate)) {
				bonusList.add(bno);				
			}
		}
		if(bonusList== null) {
			System.out.println("Null Obj");
			}
		try {
		res = employeeMapper.map(bonusList);
		}
		catch (NullPointerException ne) { 
			ne.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	

}//(a) -> a.getJoiningDate() <= todaysDate && a.getExitDate() > todaysDate