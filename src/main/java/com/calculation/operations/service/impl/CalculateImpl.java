package com.calculation.operations.service.impl;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculation.operations.dao.InputRepository;
import com.calculation.operations.exception.DivideByZeroException;
import com.calculation.operations.model.Input;
import com.calculation.operations.service.Calculate;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CalculateImpl implements Calculate {
	
	@Autowired
	private InputRepository inputRepository;
	
	PriorityQueue<Integer> history = new PriorityQueue<>();

	@Override
	public double addition(Input input) {
		input.setAnswer(input.getFirstNumber()+input.getSecondNumber());
		input.setOperationPerformed("Addition");
		inputRepository.save(input);
		return input.getAnswer();
	}

	@Override
	public double subtraction(Input input) {
		input.setAnswer(input.getFirstNumber()-input.getSecondNumber());
		input.setOperationPerformed("Subtraction");
		inputRepository.save(input);
		return input.getAnswer();
	}

	@Override
	public double multiplication(Input input) {
		input.setAnswer(input.getFirstNumber()*input.getSecondNumber());
		input.setOperationPerformed("Multiplication");
		inputRepository.save(input);
		return input.getAnswer();

	}

	@Override
	public double divide(Input input) throws DivideByZeroException {
		try {
			if(input.getSecondNumber()==0.0) {
				throw new DivideByZeroException("Number is divided by zero");
			}
			input.setAnswer(input.getFirstNumber()/input.getSecondNumber());
			input.setOperationPerformed("Division");
			inputRepository.save(input);
			return input.getAnswer();
		}
		catch(ArithmeticException e)
        {
			log.info("Arithmatic exception");
            throw new DivideByZeroException("Number is divided by zero");
        }
	}

	@Override
	public List<Input> getHistory() {
		List<Input> history = inputRepository.findLastTenHistory();
		Stream<Input> stream=history.stream();
		stream.forEach(e->{
			log.info(e.getOperationPerformed()+" : "+e.getAnswer());
		});
		return history;
	}

}
