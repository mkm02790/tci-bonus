package com.bonus.tci.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bonus.tci.model.Bonus;
import com.bonus.tci.model.Employee;
import com.bonus.tci.service.BonusCalculator;
import com.bonus.tci.service.EmployeeMapper;
/*This BonusCalculator class will  filter out the employees who are not active as of today
 *   (which means those who have either exited or not yet joined)*/
@Component
public class BonusCalculatorImpl implements BonusCalculator{
	
	@Autowired
	EmployeeMapper employeeMapper ;
	
	Map<String, List<Employee>> res =null ;
	
	@Override
	public Map<String, List<Employee>> calculate(List<Bonus> bn) {
		Date todaysDate =new java.util.Date();
		List<Bonus> bonusList = new ArrayList<>();

//Filtration of Employee who have either exit or not yet joined With Using Java Stream 
		bonusList =bn.stream().filter((a) -> todaysDate.after(a.joiningDate)).filter((a) -> todaysDate.before(a.exitDate)).collect(Collectors.toList());
		if(null!=bonusList)	{
		     try {
			res = employeeMapper.map(bonusList);
	    }catch (NullPointerException ne) { 
		   	ne.printStackTrace();
	    }catch (Exception e) {
			e.printStackTrace();
		}}else 
			System.out.println("Null Obj");
		return res;
	}
	

}