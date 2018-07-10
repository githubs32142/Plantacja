package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Tariff;

@Repository
public interface TariffRepository extends JpaRepository<Tariff,Integer>{
	
	@Query("select max(t.id) from Tariff t ")
	public int getMaxId();
	
	@Query("select t From Tariff t join t.fields f where f.id=? ")
	public List<Tariff> getTariff(long idField);

}
