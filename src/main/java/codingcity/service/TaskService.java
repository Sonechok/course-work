package codingcity.service;

import codingcity.dto.TaskDTO;
import codingcity.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDTO createTask (TaskDTO taskDTO, Long courseId);

    TaskDTO updateTask (TaskDTO taskDTO, Long courseId);

    List<Task> findAllByCourseId(Long courseId);

    Task findById(Long taskId);

    Task findByNumberOfDayAndCourseName(Integer numberOfDay, String courseName);
}
