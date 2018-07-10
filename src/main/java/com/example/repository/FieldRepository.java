package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long>{
	@Query("select t from Field t where t.provider.id= ?")
	public List<Field> findByIdProvider(long idProvider);
	
	@Query("select t from Field t where t.id= ?")
	public Field findById(long id);
}
