package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.User;

//@Resource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {

}