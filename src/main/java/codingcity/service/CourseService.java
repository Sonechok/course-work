package codingcity.service;

import codingcity.dto.CourseDTO;
import codingcity.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);

    Course findById(Long id);

    List<Course> findAll();

    long count();

    Course findByName(String name);
}
