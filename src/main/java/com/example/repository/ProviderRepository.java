package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Provider;
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
	public Provider findByNameCompany(String name);
	public Provider findById(long id);
}
