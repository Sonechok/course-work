package codingcity.controller;

import codingcity.dto.CourseDTO;
import codingcity.dto.UserDTO;
import codingcity.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateCourseController {
    private final CourseService courseService;

    @Autowired
    public CreateCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/admin/create_courses")
    public String getLoginPage(Model model){
        model.addAttribute("course", new CourseDTO());
        return "create_course";
    }

    @PostMapping("/admin/create_courses")
    public String getRegistrationPage(@ModelAttribute("course") CourseDTO course) {
        courseService.createCourse(course);
        return "create_course";
    }
}
