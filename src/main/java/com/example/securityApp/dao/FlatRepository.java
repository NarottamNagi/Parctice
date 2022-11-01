package com.example.securityApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.securityApp.model.FlatEntity;

public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
	@Query("SELECT u.flatnumber  FROM FlatEntity u")
    public List<String> getUserName();


}
