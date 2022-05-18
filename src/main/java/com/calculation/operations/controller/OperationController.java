package com.calculation.operations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculation.operations.exception.DivideByZeroException;
import com.calculation.operations.model.Input;
import com.calculation.operations.service.Calculate;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class OperationController {
	
	@Autowired
	private Calculate calculate;

	@PostMapping(value="/add", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> addition(@RequestBody Input input ){
		try {
			double sum=calculate.addition(input);
			return new ResponseEntity<String>("On Addition : "+sum,HttpStatus.OK);
		}catch(Exception ex){
			log.error("Exception occurred {}",ex.getMessage());
			return new ResponseEntity<String>("Exception Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value="/subtract", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> subtraction(@RequestBody Input input ){
		try {
			double sub=calculate.subtraction(input);
			return new ResponseEntity<String>("On Subtraction : "+sub,HttpStatus.OK);
		}catch(Exception ex){
			log.error("Exception occurred {}",ex.getMessage());
			return new ResponseEntity<String>("Exception Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value="/multiply", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> multiplication(@RequestBody Input input ){
		try {
			double multiply=calculate.multiplication(input);
			return new ResponseEntity<String>("On Multiplication : "+multiply,HttpStatus.OK);
		}catch(Exception ex){
			log.error("Exception occurred {}",ex.getMessage());
			return new ResponseEntity<String>("Exception Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping(value="/divide", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> divide(@RequestBody Input input ){
		try {
			double divide=calculate.divide(input);
			return new ResponseEntity<String>("On Division : "+divide,HttpStatus.OK);
		}
		catch(DivideByZeroException ex){
			log.error("DivideByZeroException occurred {}",ex.getMessage());
			return new ResponseEntity<String>("DivideByZeroException occurred as "+ex.getMessage(),HttpStatus.BAD_REQUEST);
		}catch(Exception ex){
			log.error("Exception occurred {}",ex.getMessage());
			return new ResponseEntity<String>("Exception Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value="/history", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Input>> getHistory(){
		List<Input> history=null;
		try {
			history=calculate.getHistory();
			return new ResponseEntity<List<Input>>(history,HttpStatus.OK);
		}catch(Exception ex){
			log.error("Exception occurred {}",ex.getMessage());
			return new ResponseEntity<List<Input>>(history,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
