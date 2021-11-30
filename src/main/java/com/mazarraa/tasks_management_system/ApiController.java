package com.mazarraa.tasks_management_system;

import java.util.List;

import com.mazarraa.tasks_management_system.model.TaskModel;
import com.mazarraa.tasks_management_system.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Map all the API Endpoints under the path "/api"
@RequestMapping("/api")
public class ApiController {

	@Autowired
	TaskService task_service;

	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}

	// Map the API Endpoint GET from "/api/task" to the method "getAllTasks"
	@GetMapping("/task")
	private List<TaskModel> getAllTasks() {
		return task_service.getAllTasks();
	}

	// Map the API Endpoint GET from "/api/task/{t_id}" to the method "getTasksById"
	@GetMapping("/task/{t_id}")
	private TaskModel getTasks(@PathVariable("t_id") int t_id) {
		try {
			return task_service.getTasksById(t_id);
		} catch (Exception e) {
			return null;
		}
	}

	
	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	private int addTask(@RequestBody TaskModel task) {
		task_service.saveOrUpdate(task);
		return task.get_t_id();
	}

	// Map the API Endpoint POST from "/api/task" to the method "addTask"
	@PostMapping(path = "/addTask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String saveTask(@RequestBody TaskModel tasks) {
		try {
			// System.out.println("Tasks value (controller) : ");
			// System.out.println(tasks.toString());
			task_service.saveOrUpdate(tasks);
			return tasks.toString();
		} catch (Exception e) {
			return e.toString();
		}
	}

	// Map the API Endpoint DELETE "/api/task/{t_id}" to the method "deleteTask"
	@DeleteMapping("/task/{t_id}")
	private void deleteTask(@PathVariable("t_id") int t_id) {
		task_service.delete(t_id);
	}

	// Map the API Endpoint PUT from "/api/task" to the method "updateTask"
	@PutMapping("/task")
	private TaskModel update(@RequestBody TaskModel tasks) {
		try {
			task_service.saveOrUpdate(tasks);
			return tasks;
		} catch (Exception e) {
			return null;
		}
	}

	// Map the API Endpoint GET from "/api/task/{t_id}" to the method "terminateTask"
	// This method will check if the task has active children or not
	// If there are active children, it will not be terminated unless all the children are terminated
	// Else, it will be terminated
	@GetMapping("/terminateTask/{t_id}")
	private String terminateTask(@PathVariable("t_id") int t_id) {
		if (task_service.terminate_task(t_id)) {
			return "Task Terminated.";
		} else {
			return "Task has active subtasks, cannot be terminated!";
		}
	}

}