package com.mazarraa.tasks_management_system.repository;

import com.mazarraa.tasks_management_system.model.TaskModel;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskModel, Integer> {
}