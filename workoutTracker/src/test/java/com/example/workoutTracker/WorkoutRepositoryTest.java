package com.example.workoutTracker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.workoutTracker.domain.Location;
import com.example.workoutTracker.domain.Workout;
import com.example.workoutTracker.domain.WorkoutRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class WorkoutRepositoryTest {
	
	@Autowired
	private WorkoutRepository repository;

	@Test
	public void findByActivityShouldReturnDate() {
		List<Workout> workouts = repository.findByActivity("running");

		assertThat(workouts).hasSize(1);
		assertThat(workouts.get(0).getDate()).isEqualTo("28.11.2021");
	}

	@Test
	public void createNewWorkout() {
		Workout workout = new Workout("skiing", 60, "28.12.2021", 500,
				new Location("nature"));
		repository.save(workout);
		assertThat(workout.getId()).isNotNull();
	}

}
