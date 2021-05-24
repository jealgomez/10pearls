package com.hackerrank.github.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	ActorRepository actorRepo;

	@Autowired
	EventService eventService;

	public Actor update(Actor actor) {
		Actor rs = null;

		Optional<Actor> option = actorRepo.findById(actor.getId());

		if (option.isPresent() && (option.get().getLogin().equals(actor.getLogin()))) {

			rs = actorRepo.save(actor);
		}
		return rs;
	}

	public List<Actor> findAll() {

		List<Event> list = eventService.findAll();

		Map<Actor, Long> mapa = list.stream().collect(Collectors.groupingBy(Event::getActor, Collectors.counting()))
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))

				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (u, v) -> {
					throw new IllegalStateException();
				}, HashMap::new));

		System.out.println(mapa);

		List<Actor> rs = new ArrayList<>(mapa.keySet());

		return rs;
	}

}
