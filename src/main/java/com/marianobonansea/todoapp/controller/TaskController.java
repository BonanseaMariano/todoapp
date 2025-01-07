package com.marianobonansea.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marianobonansea.todoapp.models.Task;
import com.marianobonansea.todoapp.services.TaskService;

/**
 * Controller for handling task-related requests.
 * 
 * Endpoints:
 * - GET /: Retrieves all tasks and adds them to the model.
 * - POST /: Creates a new task with the given title and redirects to the root.
 * - GET /{id}/delete: Deletes the task with the specified ID and redirects to
 * the root.
 * - GET /{id}/toggle: Toggles the completion status of the task with the
 * specified ID and redirects to the root.
 * 
 * Dependencies:
 * - TaskService: A service that provides task-related operations.
 * 
 */
@Controller
public class TaskController {

    private final TaskService taskService;

    /**
     * Constructs a new TaskController with the specified TaskService.
     *
     * @param taskService the TaskService to be used by this controller
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Handles GET requests to the root URL and retrieves all tasks.
     *
     * @param model the model to which the tasks will be added
     * @return the name of the view to be rendered
     */
    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    /**
     * Handles POST requests to the root URL and creates a new task.
     *
     * @param title the title of the new task
     * @return a redirect to the root URL
     */
    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";
    }

    /**
     * Handles GET requests to delete a task by its ID.
     *
     * @param id the ID of the task to be deleted
     * @return a redirect to the root URL
     */
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    /**
     * Handles GET requests to toggle the completion status of a task by its ID.
     *
     * @param id the ID of the task to be toggled
     * @return a redirect to the root URL
     */
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
