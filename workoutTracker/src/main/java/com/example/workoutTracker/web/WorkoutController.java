package com.example.workoutTracker.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.workoutTracker.domain.Workout;
import com.example.workoutTracker.domain.WorkoutRepository;
import com.example.workoutTracker.domain.LocationRepository;



@Controller
public class WorkoutController {
	@Autowired
	private WorkoutRepository wrepository; 
	
	@Autowired
	private LocationRepository lrepository;
	
	//listing workouts
    @RequestMapping(value= {"/", "/workout"})
    public String workout(Model model) {	
        model.addAttribute("workouts", wrepository.findAll());
        return "workout";
    }
    
 // RESTful service to get all workouts
 	@RequestMapping(value = "/workouts", method = RequestMethod.GET)
 	public @ResponseBody List<Workout> workoutRest() {
 		return (List<Workout>) wrepository.findAll();
 	}

 	// RESTful service to get workout by id
 	@RequestMapping(value = "/workout/{id}", method = RequestMethod.GET)
 	public @ResponseBody Optional<Workout> findWorkoutRest(@PathVariable("id") Long id) {
 		return wrepository.findById(id);
 	}

    //adding some workouts to the list
    @RequestMapping(value = "/add")
    public String addWorkout(Model model){
    	model.addAttribute("workout", new Workout());
        return "addWorkout";
    }     
    
    //saving workouts to the list
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Workout workout){
        wrepository.save(workout);
        return "redirect:workout";
    } 
    
    //deleting a workout
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") Long workoutId, Model model) {
    	wrepository.deleteById(workoutId);
        return "redirect:../workout";
    }  
    
    //editing a workout
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editWorkout(@PathVariable("id") Long workoutId, Model model) {
    	model.addAttribute("workout", wrepository.findById(workoutId));
    	model.addAttribute("locations", lrepository.findAll());
    	return "editWorkout";
    }  
}
