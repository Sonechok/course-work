package codingcity.controller;

import codingcity.dto.CourseDTO;
import codingcity.dto.UserDTO;
import codingcity.entity.*;
import codingcity.entity.enums.Status;
import codingcity.service.CourseService;
import codingcity.service.TaskService;
import codingcity.service.UserProgressService;
import codingcity.service.UserService;
import codingcity.service.mapper.UserProgressMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CabinetController {
    private final UserService userService;
    private final UserProgressService userProgressService;
    private final CourseService courseService;
    private final TaskService taskService;
    private final UserProgressMapper userProgressMapper;

    public CabinetController(UserService userService, UserProgressService userProgressService, CourseService courseService, TaskService taskService, UserProgressMapper userProgressMapper) {
        this.userService = userService;
        this.userProgressService = userProgressService;
        this.courseService = courseService;
        this.taskService = taskService;
        this.userProgressMapper = userProgressMapper;
    }

    @GetMapping("/cabinet")
    public ModelAndView getCabinetPage(ModelAndView modelAndView, Principal principal){
        modelAndView.setViewName("cabinet");
        List<Stats> statuses = new ArrayList<>(Status.valuesString());
        String email = principal.getName();
        UserDTO userDTO = userService.findByEmail(email);
        User user = userService.findUserByEmail(email);
        Set<Course> usersCourses = new HashSet<>(user.getCourses());
        List<UserProgress> progresses = new ArrayList<>();
        for (Course courseFromSet:usersCourses) {
            Set<Task> tasks = courseFromSet.getTasks();
            for (Task taskFromSet:tasks) {
                UserProgress userProgress = userProgressService.findByUserIdAndTaskId(user.getId(), taskFromSet.getId());
                if(userProgress == null){
                    userProgress = userProgressService.createUserProgressNoDTOForTask(new UserProgress(Status.none.toString(), taskFromSet), user.getId());
                }
                progresses.add(userProgress);
            }
        }
        List<Day> days = new ArrayList<>(createArrayOfDays(30));
        modelAndView.getModelMap().addAttribute("user", userDTO);
        modelAndView.getModelMap().addAttribute("courses", usersCourses);
        modelAndView.getModelMap().addAttribute("size", usersCourses.size());
        modelAndView.getModelMap().addAttribute("coursesAll", courseService.findAll());
        modelAndView.getModelMap().addAttribute("progresses", progresses);
        modelAndView.getModelMap().addAttribute("days", days);
        modelAndView.getModelMap().addAttribute("statuses", statuses);
        modelAndView.getModelMap().addAttribute("courseRes", new CourseAndDay());
        return modelAndView;
    }

    @PostMapping("/cabinet")
    public String setCourse(@ModelAttribute("courseRes")CourseAndDay courseAndDay, Principal principal){
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        Task task = taskService.findByNumberOfDayAndCourseName(courseAndDay.getDay(), courseAndDay.getName());
        if(task == null){
            return "progress_error";
        } else {
            userProgressService.updateUserProgress(task.getId(), user.getId(), courseAndDay.getStatus());
            return "main";
        }
    }

    public List<Day> createArrayOfDays (Integer countOfDays){
        List<Day> days = new ArrayList<>(30);
        for (Integer i = 1; i <= countOfDays;i++){
            days.add(new Day(i));
        }
        return days;
    }
}
