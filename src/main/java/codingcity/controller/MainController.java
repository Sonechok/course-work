package codingcity.controller;

import codingcity.entity.Statistic;
import codingcity.repository.CourseRepository;
import codingcity.repository.UserRepository;
import codingcity.service.CourseService;
import codingcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private  final CourseService courseService;
    private final UserService userService;

    @Autowired
    public MainController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/main")
    public ModelAndView createMainPage(ModelAndView modelAndView) {
        modelAndView.setViewName("main");
        Statistic statistic = new Statistic();
        statistic.setCountOfUsers(userService.count());
        statistic.setCountOfCourses(courseService.count());
        if(userService.count()<5){
            statistic.setCountOfAppliedUsers(userService.count());
        } else {
            statistic.setCountOfAppliedUsers(userService.count()-3);
        }
        modelAndView.getModelMap().addAttribute("statistic", statistic);
        return modelAndView;
    }
}
