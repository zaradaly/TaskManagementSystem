package com.mazarraa.tasks_management_system.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mazarraa.tasks_management_system.model.TaskModel;
import com.mazarraa.tasks_management_system.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        List<TaskModel> tasks = new ArrayList<TaskModel>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    public TaskModel getTasksById(int t_id) {
        return taskRepository.findById(t_id).get();
    }

    public void saveOrUpdate(TaskModel tasks) {
        taskRepository.save(tasks);
    }

    public void delete(int t_id) {
        taskRepository.deleteById(t_id);
    }

    public void update(TaskModel tasks, int t_id) {
        taskRepository.save(tasks);
    }

    public boolean has_active_children(int parent_id) {
        List<TaskModel> tasks = new ArrayList<TaskModel>();
        taskRepository.findAll().forEach(
                task -> {
                    // if task is child of parent and is active
                    if ( (task.get_t_parent_id() == parent_id) && (task.get_t_status() == 1) ) {
                        tasks.add(task);
                    }
                });
        return (tasks.size() > 0 );
    }

    public void terminate_task(int t_id) {
        TaskModel task = taskRepository.findById(t_id).get();
        task.set_t_status(0);
        taskRepository.save(task);
    }
}
