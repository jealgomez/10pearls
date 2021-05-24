package com.hackerrank.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.service.ActorService;

@RestController
@RequestMapping(value = "/actors")
public class ActorsController {

	@Autowired
	ActorService service;

	@PutMapping
	public ResponseEntity<String> findByActorId(@RequestBody Actor actor) {
		ResponseEntity<String> response;

		Actor rs = service.update(actor);
		if (rs != null) {
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {

			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping()
	public ResponseEntity<List<Actor>> findAll() {

		ResponseEntity<List<Actor>> response;
		List<Actor> actors = service.findAll();

		response = new ResponseEntity<>(actors, HttpStatus.OK);

		return response;

	}

}
