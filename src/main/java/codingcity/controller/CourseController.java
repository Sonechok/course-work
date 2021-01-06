package codingcity.controller;

import codingcity.dto.CourseDTO;
import codingcity.dto.UserDTO;
import codingcity.entity.Course;
import codingcity.entity.User;
import codingcity.service.CourseService;
import codingcity.service.UserService;
import codingcity.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public CourseController(CourseService courseService, UserService userService, UserMapper userMapper) {
        this.courseService = courseService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/courses")
    public ModelAndView getCoursesPage( ModelAndView modelAndView){
        modelAndView.setViewName("courses");
        List<Course> courses = courseService.findAll();
        List<String> namesOfCourses = new ArrayList<>();
        for (Course course: courses) {
            namesOfCourses.add(course.getName());
        }
        modelAndView.getModelMap().addAttribute("courses", courseService.findAll());
        modelAndView.getModelMap().addAttribute("namesOfCourses", namesOfCourses);
        modelAndView.getModelMap().addAttribute("courseRes", new CourseDTO());
        return modelAndView;
    }

    @PostMapping("/courses")
    public String setCourse(@ModelAttribute("courseRes") @Valid CourseDTO courseDTO, BindingResult result, Principal principal){
        if(result.hasErrors()){
            return "courses";
        }
        Course course = courseService.findByName(courseDTO.getName());
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        if (course.getPrice()>user.getAmountOfMoney()){
            return "money";
        } else {
            user.setAmountOfMoney(user.getAmountOfMoney()-course.getPrice());
            user.getCourses().add(course);
            UserDTO userAfterUpdate = userService.updateUser(user);
            return "main";
        }
    }


}
