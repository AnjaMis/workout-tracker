package com.example.workoutTracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workout {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String activity;
	private int duration;
	private String date;
	private int calories;
	
	
	//Constructors
	public Workout() {}
	
	public Workout(String activity, int duration, String date, int calories) {
		super();
		this.activity = activity;
		this.duration = duration;
		this.date = date;
		this.calories = calories;
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", activity=" + activity + ", duration=" + duration + ", date=" + date
				+ ", calories=" + calories + "]";
	}



}
