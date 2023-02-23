package com.flashStudyBuddy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flashStudyBuddy.model.Models;
@Repository
public interface ModelRepo extends JpaRepository<Models,Long> {
	List<Models> findAll();
	Models findById(long id);
}
