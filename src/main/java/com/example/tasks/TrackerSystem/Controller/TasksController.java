package com.example.tasks.TrackerSystem.Controller;

import com.example.tasks.TrackerSystem.Api.ApiResopnse;
import com.example.tasks.TrackerSystem.Model.Tasks;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tracker-system")

//create a new task(title, description, status) done
//Display all tasks >> show . done
//add task.  done
//Update task.  done
//Delete task. done
//change the task status as done or not done. >> if condition.   done
//search for a task by given title.>> i have to search how to search? .. done

public class TasksController {
    ArrayList<Tasks> tasks = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Tasks> getTask(){
        return tasks;
    }

    @PostMapping("/add")
    public ApiResopnse addTask(@RequestBody Tasks task){
        tasks.add(task);
        return new ApiResopnse("task added successfully");
    }
    @PutMapping("/update/{index}")
    public ApiResopnse updateTask(@PathVariable int index, @RequestBody Tasks task){
        tasks.set(index, task);
        return new ApiResopnse("Task Updated Successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResopnse deleteTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResopnse("Task deleted Successfully");
    }

    @DeleteMapping("delete/all")
    public ApiResopnse deleteAllTasks(){
        tasks.clear();
        return new ApiResopnse("All Tasks Deleted Successfully!");
    }


    @PutMapping("/change-status/{id}")
    public ApiResopnse changeTaskStatus(@PathVariable String id){
        for (Tasks task : tasks){
            if (task.getID().equals(id)){
                task.setStatus((!task.isStatus()));
                return new ApiResopnse("Taks Status changed successfully!");
            }
        }
        return new ApiResopnse("Task not found!");
    }

    @GetMapping("/search/{title}")
    public ArrayList<Tasks> searchTaskByTitle(@PathVariable String title){
        ArrayList<Tasks> result = new ArrayList<>();
        for (Tasks task : tasks){
            if (task.getTitle().equalsIgnoreCase(title)){
                result.add(task);
            }
        }
        return result;
    }



}
