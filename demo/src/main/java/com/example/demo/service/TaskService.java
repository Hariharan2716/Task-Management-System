package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public Task createTask(Long userId, Task task) {
        User user = userRepo.findById(userId).orElseThrow();
        task.setUser(user);
        task.setCreatedDate(LocalDate.now());
        return taskRepo.save(task);
    }

    public List<Task> getUserTasks(Long userId) {
        return taskRepo.findByUserId(userId);
    }

    public Task updateTask(Long taskId, Task updated) {
        Task existing = taskRepo.findById(taskId).orElseThrow();
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        existing.setDueDate(updated.getDueDate());
        return taskRepo.save(existing);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
