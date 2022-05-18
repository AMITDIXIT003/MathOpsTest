package com.calculation.operations.service;

import java.util.List;

import com.calculation.operations.exception.DivideByZeroException;
import com.calculation.operations.model.Input;

public interface Calculate {

	public double addition(Input input);

	public double subtraction(Input input);

	public double multiplication(Input input);

	public double divide(Input input) throws DivideByZeroException;

	public List<Input> getHistory();
}
