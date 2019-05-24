package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<User> find(@PathVariable("id") Integer id) {
		return repository.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

	@PutMapping(path = "/{id}")
	public User update(@PathVariable("id") Integer id, @RequestBody User user) throws BadHttpRequest {
		if (repository.existsById(id)) {
			user.setId(id);
			return repository.save(user);
		} else {
			throw new BadHttpRequest();
		}
	}

}