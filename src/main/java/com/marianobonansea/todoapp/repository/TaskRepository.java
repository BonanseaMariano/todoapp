package com.marianobonansea.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marianobonansea.todoapp.models.Task;

/**
 * Repository interface for {@link Task} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations
 * and additional query methods for the {@link Task} entity.
 * </p>
 * 
 * @see JpaRepository
 * @see Task
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
