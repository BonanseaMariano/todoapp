package com.marianobonansea.todoapp.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.marianobonansea.todoapp.models.Task;
import com.marianobonansea.todoapp.services.TaskService;

/**
 * Controller for handling task-related web views and templates.
 * 
 * This controller manages the web interface for task operations:
 * - GET /: Displays the main task list page
 * - POST /: Handles task creation form submission
 * - GET /{id}/delete: Processes task deletion requests
 * - GET /{id}/toggle: Handles task completion status toggle
 * 
 * All operations redirect back to the main view after completion.
 */
@Controller
@RequestMapping("/")
public class TaskViewController {

    private static final String REDIRECT_ROOT = "redirect:/";
    private final TaskService taskService;

    /**
     * Constructs a new TaskViewController with the specified TaskService.
     *
     * @param taskService the service to handle task operations
     */
    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Displays the main task list page.
     *
     * @param model the Spring MVC model for view rendering
     * @return the name of the view template to render
     */
    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    /**
     * Processes task creation form submission.
     *
     * @param title the title of the new task
     * @return redirect to the main view
     */
    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return REDIRECT_ROOT;
    }

    /**
     * Handles task deletion requests.
     *
     * @param id the ID of the task to delete
     * @return redirect to the main view
     */
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return REDIRECT_ROOT;
    }

    /**
     * Processes task completion status toggle requests.
     *
     * @param id the ID of the task to toggle
     * @return redirect to the main view
     */
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return REDIRECT_ROOT;
    }
}
