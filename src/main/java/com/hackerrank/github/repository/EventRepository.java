package com.hackerrank.github.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;  

public interface EventRepository  extends CrudRepository<Event, Long>  {

	
	List<Event> findByActor(Actor a);
}
