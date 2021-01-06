package codingcity.service.mapper;

import codingcity.dto.TaskDTO;
import codingcity.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDTO (Task task);

    Task toEntity (TaskDTO taskDTO);
}
