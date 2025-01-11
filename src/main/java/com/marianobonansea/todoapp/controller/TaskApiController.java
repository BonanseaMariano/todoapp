package com.marianobonansea.todoapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marianobonansea.todoapp.models.Task;
import com.marianobonansea.todoapp.services.TaskService;

/**
 * REST Controller for managing tasks through API endpoints.
 * 
 * This controller provides RESTful endpoints for task operations:
 * - GET /api/tasks: Retrieve all tasks
 * - POST /api/tasks: Create a new task
 * - DELETE /api/tasks/{id}: Delete a specific task
 * - PATCH /api/tasks/{id}/toggle: Toggle task completion status
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskApiController {

    private final TaskService taskService;

    /**
     * Constructs a new TaskApiController with the specified TaskService.
     *
     * @param taskService the service to handle task operations
     */
    public TaskApiController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Retrieves all tasks.
     *
     * @return ResponseEntity containing the list of all tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    /**
     * Creates a new task.
     *
     * @param title the title of the new task
     * @return ResponseEntity containing the created task
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody String title) {
        Task newTask = taskService.createTask(title);
        return ResponseEntity.status(201).body(newTask);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id the ID of the task to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Toggles the completion status of a task.
     *
     * @param id the ID of the task to toggle
     * @return ResponseEntity containing the updated task
     */
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTask(@PathVariable Long id) {
        Task task = taskService.toggleTask(id);
        return ResponseEntity.ok(task);
    }
}