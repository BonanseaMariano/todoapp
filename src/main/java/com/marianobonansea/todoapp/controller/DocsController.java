package com.marianobonansea.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller that handles documentation-related routes.
 * Provides access to both technical documentation and API documentation.
 * 
 * @author Mariano Bonansea
 * @version 1.0
 * @since 2025-01-11
 */
@Controller
@RequestMapping("/docs")

public class DocsController {

    /**
     * Displays the main documentation page.
     * This page contains links to both API documentation (Swagger)
     * and technical documentation (JavaDoc).
     * 
     * @return String - The name of the Thymeleaf view to render ("docs/index")
     * 
     * @see <a href="/swagger-ui.html">Swagger Documentation</a>
     * @see <a href="https://bonanseamariano.github.io/todoapp/javadoc/">JavaDoc
     *      Documentation</a>
     */
    @GetMapping
    public String index() {
        return "docs/index";
    }
}