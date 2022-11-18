package com.example.demo.model;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Integer> {
	public Optional<Task> findByAssignedTo(String name);

}
