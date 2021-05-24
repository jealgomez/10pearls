package com.hackerrank.github.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.repository.RepoRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepo;
	@Autowired
	RepoRepository repoRepo;
	@Autowired
	ActorRepository actorRepo;

	public Event save(Event event) {
		if (findById(event.getId()) == null) {
			return eventRepo.save(event);
		}
		return null;

	}

	public void erase() {

		eventRepo.deleteAll();
		repoRepo.deleteAll();
		actorRepo.deleteAll();
	}

	public Event findById(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		if (event.isPresent()) {
			return event.get();
		}
		return null;

	}

	public List<Event> findByActorId(Long id) {

		Optional<Actor> actor = actorRepo.findById(id);
		if (actor.isPresent()) {
			List<Event> list = eventRepo.findByActor(actor.get());
			list.sort(Comparator.comparing(Event::getId));
			return list;

		}
		return null;
	}

	public List<Event> findAll() {

		List<Event> list = StreamSupport.stream(eventRepo.findAll().spliterator(), false).collect(Collectors.toList());

		list.sort(Comparator.comparing(Event::getId));
		return list;
	}

}
