package com.calculation.operations.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calculation.operations.model.Input;

@Repository
public interface InputRepository extends JpaRepository<Input,String> {

	@Query(value="select * from input order by id desc limit 10;",nativeQuery=true)
	List<Input> findLastTenHistory();

}
