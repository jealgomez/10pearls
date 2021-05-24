package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventService;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
	
	@Autowired
	EventService service;
	
	@DeleteMapping
	public ResponseEntity<String> delete() {

		service.erase();
		ResponseEntity<String> save= new ResponseEntity<>(HttpStatus.OK);
		return save;

	}

	

}
