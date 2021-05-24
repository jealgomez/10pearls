package com.hackerrank.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

	@Autowired
	EventService service;

	@PostMapping()
	public ResponseEntity<String> save(@RequestBody Event event) {

		ResponseEntity<String> response;
		Event eventSave = service.save(event);
		if (eventSave != null) {
			response = new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> findById(@PathVariable("id") Long id) {

		ResponseEntity<Event> response;
		Event event = service.findById(id);
		if (event != null) {
			response = new ResponseEntity<Event>(event, HttpStatus.OK);
		} else {

			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;

	}

	@GetMapping("/actors/{actorID}")
	public ResponseEntity<List<Event>> findByActorId(@PathVariable("actorID") Long id) {

		ResponseEntity<List<Event>> response;
		List<Event> event = service.findByActorId(id);
		if (event != null && !event.isEmpty()) {
			response = new ResponseEntity<List<Event>>(event, HttpStatus.OK);
		} else {

			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;

	}

	@GetMapping()
	public ResponseEntity<List<Event>> findAll() {

		ResponseEntity<List<Event>> response;
		List<Event> event = service.findAll();

		response = new ResponseEntity<List<Event>>(event, HttpStatus.OK);

		return response;

	}

}
