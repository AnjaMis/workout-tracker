package com.example.workoutTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.workoutTracker.domain.Location;
import com.example.workoutTracker.domain.LocationRepository;
import com.example.workoutTracker.domain.User;
import com.example.workoutTracker.domain.UserRepository;
import com.example.workoutTracker.domain.Workout;
import com.example.workoutTracker.domain.WorkoutRepository;

@SpringBootApplication
public class WorkoutTrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(WorkoutTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkoutTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner workoutDemo(WorkoutRepository wrepository, LocationRepository lrepository,
			UserRepository urepository) {
		return (args) -> {

			log.info("save a couple of locations");
			lrepository.save(new Location("gym"));
			lrepository.save(new Location("home"));
			lrepository.save(new Location("outside"));

			log.info("save a couple of workouts");
			wrepository.save(new Workout("running", 30, "28.11.2021", 464, lrepository.findByName("outside").get(0)));
			wrepository.save(new Workout("swimming", 45, "26.11.2021", 320, lrepository.findByName("gym").get(0)));
			wrepository.save(new Workout("rope jumping", 20, "21.11.2021", 471, lrepository.findByName("home").get(0)));
			wrepository.save(new Workout("jumping jacks", 65, "19.11.2021", 989, lrepository.findByName("gym").get(0)));
			wrepository.save(new Workout("wrestling", 60, "17.11.2021", 350, lrepository.findByName("gym").get(0)));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$HvJV.bEuomTKBbZbxCudG.l.wkiqftREj99na20.5vVTw1VloSGFm",
					"anja@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$AgK37txcCYS2gIwcc8gNw.QZ.6EWJtwXSUG855yyKWLDngHPWSF1W",
					"mis@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all workouts");
			for (Workout workout : wrepository.findAll()) {
				log.info(workout.toString());
			}

		};
	}
}
