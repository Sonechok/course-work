package codingcity.service;

import codingcity.dto.UserProgressDTO;
import codingcity.entity.UserProgress;

public interface UserProgressService {
    UserProgressDTO createUserProgressForTask(UserProgress userProgress, Long userId);

    UserProgress createUserProgressNoDTOForTask(UserProgress userProgress, Long userId);

    UserProgressDTO updateUserProgress(Long taskId, Long userId, String status);

    UserProgress findById(Long progressId);

    UserProgress findByUserIdAndTaskId(Long userId, Long taskId);
}
