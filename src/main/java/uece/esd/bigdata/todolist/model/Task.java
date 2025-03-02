package uece.esd.bigdata.todolist.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;
import lombok.*;

@Table("tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @PrimaryKey
    private UUID id;
    private String title;
    private String description;
    private boolean completed;

}

