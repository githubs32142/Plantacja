package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
	@Query("select max(r.id) from Result r ")
	public int getMaxId();
	
	@Query("select r From Result r where r.date BETWEEN ? AND ?")
	public List<Result> getResultBeetwen(Date start,Date end);
}
