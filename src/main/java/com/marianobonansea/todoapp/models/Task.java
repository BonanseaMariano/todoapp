package com.marianobonansea.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Represents a task entity with an id, title, and completion status.
 * This class is annotated with JPA annotations to map it to a database table.
 * 
 * Annotations:
 * 
 * @Entity - Specifies that the class is an entity and is mapped to a database
 *         table.
 * @Data - Lombok annotation to generate getters, setters, toString, equals, and
 *       hashCode methods.
 * 
 *       Fields:
 * @Id - Specifies the primary key of an entity.
 * @GeneratedValue - Provides the specification of generation strategies for the
 *                 values of primary keys.
 *                 private Long id - The unique identifier for the task.
 *                 private String title - The title or description of the task.
 *                 private boolean completed - The status of the task,
 *                 indicating whether it is completed or not.
 */
@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean completed;

}
