package com.example.workoutTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.workoutTracker.domain.Workout;
import com.example.workoutTracker.domain.WorkoutRepository;


@SpringBootApplication
public class WorkoutTrackerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WorkoutTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkoutTrackerApplication.class, args);
	} 
	
	@Bean
	public CommandLineRunner workoutDemo(WorkoutRepository repository) {
		return (args) -> {
			log.info("save a couple of workouts");
			repository.save(new Workout("running", 30, "28.11.2021", 464));
			repository.save(new Workout("swimming", 45, "26.11.2021", 320));
			repository.save(new Workout("rope jumping", 20, "21.11.2021", 471));
			repository.save(new Workout("running", 65, "19.11.2021", 989));
			repository.save(new Workout("wrestling", 60, "17.11.2021", 350));



			log.info("fetch all workouts");
			for (Workout workout : repository.findAll()) {
				log.info(workout.toString());
			}

		};
	}
}
