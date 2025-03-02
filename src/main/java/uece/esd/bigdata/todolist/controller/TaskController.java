package uece.esd.bigdata.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import uece.esd.bigdata.todolist.model.Task;
import uece.esd.bigdata.todolist.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "Gerenciamento de Tarefas")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas as tarefas", description = "Retorna todas as tarefas cadastradas")
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Retorna uma tarefa específica pelo seu ID")
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable UUID id) {
        return service.getTaskById(id);
    }

    @Operation(summary = "Criar uma nova tarefa", description = "Adiciona uma nova tarefa ao banco de dados")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @Operation(summary = "Atualizar uma tarefa", description = "Modifica uma tarefa existente pelo ID")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @Operation(summary = "Deletar uma tarefa", description = "Remove uma tarefa pelo ID")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        service.deleteTask(id);
    }
}