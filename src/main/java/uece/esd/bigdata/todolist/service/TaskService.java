package uece.esd.bigdata.todolist.service;

import org.springframework.stereotype.Service;
import uece.esd.bigdata.todolist.model.Task;
import uece.esd.bigdata.todolist.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(UUID id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        task.setId(UUID.randomUUID());
        return repository.save(task);
    }

    public Task updateTask(UUID id, Task taskDetails) {
        return repository.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setCompleted(taskDetails.isCompleted());
                    return repository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(UUID id) {
        repository.deleteById(id);
    }
}
