package codingcity.repository;

import codingcity.dto.UserProgressDTO;
import codingcity.entity.UserProgress;
import codingcity.entity.enums.Status;
import codingcity.service.TaskService;
import codingcity.service.UserProgressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserProgressRepositoryTest {
    @Autowired
    private UserProgressService userProgressService;
    @Autowired
    private TaskService taskService;

    @Test
    void createUserProgressForTask() {
        UserProgress userProgress = new UserProgress(Status.inProgress.toString());
        Long taskId = 8L;
        userProgress.setTask(taskService.findById(taskId));
        Long userId = 13L;
        UserProgressDTO result = userProgressService.createUserProgressForTask(userProgress, userId);
        Assertions.assertEquals(Status.inProgress.toString(), result.getProgress());
    }

    @Test
    void updateUserProgress() {
        UserProgressDTO result = userProgressService.updateUserProgress(9L, 3L, "toDo");
        Assertions.assertEquals(Status.done.toString(), result.getProgress());
    }

    @Test
    void findByUserIdAndTaskId(){
        Long taskId = 8L;
        Long userId = 3L;
        UserProgress result = userProgressService.findByUserIdAndTaskId(userId, taskId);
        Assertions.assertNull(result);
    }
}