package com.example.workoutTracker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.workoutTracker.domain.Workout;
import com.example.workoutTracker.domain.WorkoutRepository;


@Controller
public class WorkoutController {
	@Autowired
	private WorkoutRepository repository; 
	
	//listing workouts
    @RequestMapping(value= {"/", "/workout"})
    public String workout(Model model) {	
        model.addAttribute("workouts", repository.findAll());
        return "workout";
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
        repository.save(workout);
        return "redirect:workout";
    } 
    
    //delete a workout
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") Long workoutId, Model model) {
    	repository.deleteById(workoutId);
        return "redirect:../workout";
    }  
}
