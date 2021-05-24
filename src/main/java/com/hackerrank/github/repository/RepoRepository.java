package com.hackerrank.github.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.github.model.Repo;

public interface RepoRepository  extends CrudRepository<Repo, Long>  {

}
