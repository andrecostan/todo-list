package uece.esd.bigdata.todolist.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import uece.esd.bigdata.todolist.model.Task;

import java.util.UUID;

@Repository
public interface TaskRepository extends CassandraRepository<Task, UUID> {
}
