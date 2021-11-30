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

    public boolean terminate_task(int t_id) {
        TaskModel parentTask = taskRepository.findById(t_id).get();
        List<TaskModel> tasks = new ArrayList<TaskModel>();
        taskRepository.findAll().forEach(
                task -> {
                    // if task is child and is active, add it to the list
                    if ( (task.get_t_parent_id() == t_id) && (task.get_t_status() == 1) ) {
                        tasks.add(task);
                    }
                });
        // if the list is empty, then there are no active children => terminate parent task
        // if the list is not empty, then there are active children -> do not terminate parent task
        if (tasks.size() == 0 ) {
            parentTask.set_t_status(0);
            taskRepository.save(parentTask);
            return true;
        }
        return false;
    }
}
