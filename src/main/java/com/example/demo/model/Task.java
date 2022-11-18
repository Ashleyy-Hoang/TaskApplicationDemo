package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="TaskTable")
public class Task {
	@Id
	private int taskId;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	private String taskTitle;
	private double duration;
	private String assignedTo;
	
}
