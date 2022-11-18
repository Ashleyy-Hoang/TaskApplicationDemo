package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.model.TaskRepo;

@RestController
public class TaskController {

	@Autowired
	TaskRepo trep;

	// add,delete,update and view Task

	@PostMapping("/add")
	public Task insertTask(@RequestBody Task tk) {
		Task t = trep.save(tk);
		return t;
	}

	@PutMapping("/update")
	public Task updateTask(@RequestBody Task obj) {
		Optional<Task> uptask = trep.findById(obj.getTaskId());
		Task update = null;
		if (uptask.isPresent()) {
			update = uptask.get();
			update.setTaskId(obj.getTaskId());
			update.setTaskTitle(obj.getTaskTitle());
			update.setDuration(obj.getDuration());
			update.setAssignedTo(obj.getAssignedTo());
			trep.save(update);
		}
		return update;
	}

	@GetMapping("/view")
	public List<Task> getTask() {
		return trep.findAll();
	}

	// user retrieve record according to assinedTo
	@GetMapping("/view/{assignedTo}")
	public Task getTaskByAssignedTo(@PathVariable String assignedTo) {
		Optional<Task> tobj = trep.findByAssignedTo(assignedTo);
		Task retreivtobj = null;
		if (tobj.isPresent()) {
			retreivtobj = tobj.get();
		}
		return retreivtobj;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Task obj) {
		Optional<Task> deltask = trep.findById(obj.getTaskId());
		if (deltask.isPresent()) {
			trep.deleteById(obj.getTaskId());
			System.out.println("Delete Successsully");
		} else {
			System.out.println("Task Not Found");
		}
	}

}
