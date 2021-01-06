package codingcity.repository;

import codingcity.dto.TaskDTO;
import codingcity.entity.Task;
import codingcity.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskRepositoryTest {
    @Autowired
    private TaskService taskService;

    @Test
    void createTask() {
        TaskDTO taskDTO = new TaskDTO(1, "Task1", "Links");
        TaskDTO result = taskService.createTask(taskDTO, 5L);
        Assertions.assertEquals("Task1", result.getTask());
    }

    @Test
    void findAllByCourseId() {
        List<Task> result = taskService.findAllByCourseId(2L);
        int countOfTasks = 4;
        Assertions.assertEquals(countOfTasks, result.size());
    }

    @Test
    void findByNumberOfDayAndCourseName() {
        Task result = taskService.findByNumberOfDayAndCourseName(2, "Java");
        Assertions.assertEquals(2, result.getNumberOfDay());
    }
}