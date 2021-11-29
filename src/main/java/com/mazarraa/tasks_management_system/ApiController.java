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
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	TaskService task_service;

	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}

	@GetMapping("/task")
	private List<TaskModel> getAllTasks() {
		return task_service.getAllTasks();
	}

	@GetMapping("/task/{t_id}")
	private String getTasks(@PathVariable("t_id") int t_id) {
		try {
			return task_service.getTasksById(t_id).toString();
		} catch (Exception e) {
			return e.toString();
		}
	}

	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	private int addTask(@RequestBody TaskModel task) {
		task_service.saveOrUpdate(task);
		return task.get_t_id();
	}

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

	@DeleteMapping("/task/{t_id}")
	private void deleteTask(@PathVariable("t_id") int t_id) {
		task_service.delete(t_id);
	}

	@PutMapping("/task")
	private TaskModel update(@RequestBody TaskModel tasks) {
		try {
			task_service.saveOrUpdate(tasks);
			return tasks;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("/terminateTask/{t_id}")
	private String terminateTask(@PathVariable("t_id") int t_id) {
		if (task_service.has_active_children(t_id)) {
			return "Task has active subtasks, cannot be terminated!";
		} else {
			task_service.terminate_task(t_id);
			return "Task Terminated.";
		}
	}

}