package com.flashStudyBuddy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flashStudyBuddy.model.*;
import com.flashStudyBuddy.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class Controller {

	@Autowired
	ModelRepo repo;
	
	@GetMapping("models")
	public List<Models>getAllModels(){
		return repo.findAll();
	}
	
	@GetMapping("models/{id}")
	public Models getModelById(@PathVariable(value="id")long id){
		return repo.findById(id);
	}
	
	@PostMapping("models/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Models addModels(@RequestBody Models model) {
		return repo.save(model);
	}
	
	@PutMapping("models/update/{id]")
	public ResponseEntity<Models> updateModels(@PathVariable(value="id")Long id,
			@RequestBody Models modelDetails){
		Optional<Models> opt = repo.findById(id);
		Models model=null;
		if(opt.isPresent()) {
			model=opt.get();
			model.setId(model.getId());
			model.setName(model.getName());
			model.setDefinition(model.getDefinition());
			return new ResponseEntity<>(repo.save(model),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("models/delete/{id}")
	public ResponseEntity<HttpStatus>deleteModel(@PathVariable(value="id")Long id){
			try {
				repo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	
	
}
