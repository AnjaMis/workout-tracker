package com.example.workoutTracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
	List<Workout> findByActivity(String activity);
}
