package codingcity.service.impl;

import codingcity.dto.UserProgressDTO;
import codingcity.entity.User;
import codingcity.entity.UserProgress;
import codingcity.error.ResourceNotFoundException;
import codingcity.repository.TaskRepository;
import codingcity.repository.UserProgressRepository;
import codingcity.repository.UserRepository;
import codingcity.service.UserProgressService;
import codingcity.service.mapper.UserProgressMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserProgressServiceImpl implements UserProgressService {
    private final UserProgressRepository userProgressRepository;
    private final TaskRepository taskRepository;
    private final UserProgressMapper userProgressMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserProgressServiceImpl(UserProgressRepository userProgressRepository, TaskRepository taskRepository, UserProgressMapper userProgressMapper, UserRepository userRepository) {
        this.userProgressRepository = userProgressRepository;
        this.taskRepository = taskRepository;
        this.userProgressMapper = userProgressMapper;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserProgressDTO createUserProgressForTask(UserProgress progress, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id",userId.toString()));
        userProgressRepository.save(progress);
        user.getProgresses().add(progress);
        userRepository.save(user);
        return userProgressMapper.toDTO(progress);
    }

    @Override
    public UserProgress createUserProgressNoDTOForTask(UserProgress progress, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id",userId.toString()));
        userProgressRepository.save(progress);
        user.getProgresses().add(progress);
        userRepository.save(user);
        return progress;
    }

    @Override
    @Transactional
    public UserProgressDTO updateUserProgress(Long taskId, Long userId, String status) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id",userId.toString()));
        Set<UserProgress> userProgresses = user.getProgresses();
        UserProgress userProgressUpdate = null;
        for (UserProgress userProgress:userProgresses) {
            if(userProgress.getTask().getId().equals(taskId)){
                userProgressUpdate = userProgress;
            }
        }
        if (userProgressUpdate == null){
            return null;
        }
        UserProgress userProgressToUpdate = userProgressRepository.getOne(userProgressUpdate.getId());
        userProgressToUpdate.setProgress(status);
        return userProgressMapper.toDTO(userProgressRepository.save(userProgressToUpdate));
    }

    @Override
    public UserProgress findById(Long progressId) {
        return userProgressRepository.findById(progressId).orElseThrow(()->new ResourceNotFoundException("progress id",progressId.toString()));
    }

    @Override
    @Transactional
    public UserProgress findByUserIdAndTaskId(Long userId, Long taskId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id",userId.toString()));
        Set<UserProgress> progressesByUserId = user.getProgresses();

        UserProgress progressesByTaskIdAndUserId = null;
        for (UserProgress progress:progressesByUserId) {
            if (progress.getTask().getId().equals(taskId)){
                progressesByTaskIdAndUserId = progress;
            }
        }
/*        if (progressesByTaskIdAndUserId==null){
            String error = "[" + userId.toString() + "] [" + taskId.toString() + "]";
            throw new ResourceNotFoundException("[user progress by [userId] and [taskId]  ]",error);
        }*/
        return progressesByTaskIdAndUserId;
    }
}
