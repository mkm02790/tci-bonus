package com.bonus.tci.dataTransalater;

import java.util.List;
import java.util.Map;

import com.bonus.tci.model.Bonus;
import com.bonus.tci.model.Employee;

public interface EmployeeMapper {
	public Map<String, List<Employee>> map (List<Bonus> lb);
	

}
