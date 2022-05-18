package com.calculation.operations.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Getter
@Setter
@JsonIgnoreProperties
@Entity
public class Input {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Transient
	private double firstNumber;
	@Transient
	private double secondNumber;
	private double answer;
	private String operationPerformed;
	
}
