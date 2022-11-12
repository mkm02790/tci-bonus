package com.bonus.tci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bonus.tci.model.Bonus;
import com.bonus.tci.model.BonusList;
import com.bonus.tci.model.Employee;
import com.bonus.tci.service.BonusCalculator;


@RestController
public class ControllerClass {
	
	@Autowired
	BonusCalculator bonusCalculator;
	
	Map<String, List<Employee> > res = null;

    @PostMapping(value ="/tci/bonus/eligibility" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> bonusEligibility(@RequestBody BonusList request){
    	
		List<Bonus> bn = new ArrayList<Bonus>();		
		for(Bonus bonus : request.getBonus()) {				
		        bn.add(bonus);
		}
				
		try {	
			res =bonusCalculator.calculate(bn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(!(res==null)) 
		{
		return new ResponseEntity<>(res ,HttpStatus.OK);
		}else return new ResponseEntity<>(res ,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
    }
}

