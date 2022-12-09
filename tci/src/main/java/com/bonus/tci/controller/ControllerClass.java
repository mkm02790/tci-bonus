package com.bonus.tci.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		try {	
			res =bonusCalculator.calculate(request.getBonus());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>("Error Occured while processing req :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		    return new ResponseEntity<>(res ,HttpStatus.OK);
				
		
    }
}

