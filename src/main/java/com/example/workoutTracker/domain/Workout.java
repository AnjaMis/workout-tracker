package com.example.workoutTracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Workout {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String activity;
	private int duration;
	private String date;
	private int calories;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location location;
	
	//Constructors
	public Workout() {}
	
	public Workout(String activity, int duration, String date, int calories, Location location) {
		super();
		this.activity = activity;
		this.duration = duration;
		this.date = date;
		this.calories = calories;
		this.location = location;
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
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		if (this.location != null) {

			return "Workout [id=" + id + ", activity=" + activity + ", duration=" + duration + ", date=" + date
					+ ", calories=" + calories + ", location =" + this.getLocation() + "]";
		}
		else {
		return "Workout [id=" + id + ", activity=" + activity + ", duration=" + duration + ", date=" + date
				+ ", calories=" + calories + "]";
		}
	}



}
