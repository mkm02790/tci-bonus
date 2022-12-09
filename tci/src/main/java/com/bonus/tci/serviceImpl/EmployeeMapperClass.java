package com.bonus.tci.serviceImpl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bonus.tci.model.Bonus;
import com.bonus.tci.model.Employee;
import com.bonus.tci.service.EmployeeMapper;
/*This EmployeeMapper class takes the list of the filtered 
 * Bonus objects and maps these to Employee objects */
@Component
public class EmployeeMapperClass implements EmployeeMapper {

	@Override
	public Map<String, List<Employee>> map(List<Bonus> lb) {
		
		Map<String, List<Employee>> map = new HashMap<String, List<Employee>>();
   	   for(Bonus bonus: lb) {	
		 try {
		        if(!map.containsKey(bonus.getCurrency())) {
		            ArrayList<Employee> al = new ArrayList<Employee>();
		            Employee employee = new Employee(bonus.getEmpName(),bonus.getAmount());
		            al.add(employee);
		            map.put(bonus.getCurrency(), al);
		        } else {
		        	ArrayList<Employee> al = (ArrayList<Employee>) map.get(bonus.getCurrency());
		            Employee employee = new Employee(bonus.getEmpName(),bonus.getAmount());		           
		            al.add(employee);
		            }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
		    }
			return map;	
	}
}
