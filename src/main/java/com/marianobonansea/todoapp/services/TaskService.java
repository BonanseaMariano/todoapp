package com.marianobonansea.todoapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marianobonansea.todoapp.models.Task;
import com.marianobonansea.todoapp.repository.TaskRepository;

/**
 * Service class for managing tasks.
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Constructs a new TaskService with the given TaskRepository.
     *
     * @param taskRepository the repository to manage tasks
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Retrieves all tasks.
     *
     * @return a list of all tasks
     */
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    /**
     * Creates a new task with the given title.
     *
     * @param title the title of the new task
     */
    public Task createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        return taskRepository.save(task);
    }

    /**
     * Deletes the task with the given ID.
     *
     * @param id the ID of the task to delete
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Toggles the completion status of the task with the given ID.
     *
     * @param id the ID of the task to toggle
     * @throws IllegalArgumentException if the task with the given ID does not exist
     */
    public Task toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

}
