package com.bonus.tci.service;
import java.util.List;
import java.util.Map;

import com.bonus.tci.model.Bonus;
import com.bonus.tci.model.Employee;

public interface BonusCalculator{	    
		public Map<String, List<Employee> > calculate( List<Bonus> bn);
	}


