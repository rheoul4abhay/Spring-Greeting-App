package com.spring.Spring_Greeting_App.repository;

import com.spring.Spring_Greeting_App.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
