package com.anonymous.entity;

import java.time.LocalDate;

public class ToDo {
	private String taskNameString;
	private LocalDate dueDate;
	private boolean isCompleted;
	private LocalDate dateComplete;
	private LocalDate dateCreated;
	public String getTaskNameString() {
		return taskNameString;
	}
	public void setTaskNameString(String taskNameString) {
		this.taskNameString = taskNameString;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public LocalDate getDateComplete() {
		return dateComplete;
	}
	public void setDateComplete(LocalDate dateComplete) {
		this.dateComplete = dateComplete;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
}
