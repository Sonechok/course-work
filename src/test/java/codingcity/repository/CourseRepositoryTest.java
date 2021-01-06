package codingcity.repository;

import codingcity.dto.CourseDTO;
import codingcity.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    CourseService courseService;

    @Test
    void createCourse() {
        String name = "Python";
        String description = "Python is an interpreted, high-level, general-purpose programming language.PYTHON IS GOOD";
        CourseDTO courseDTO = new CourseDTO(name, description, 5000);
        CourseDTO result = courseService.createCourse(courseDTO);
        Assertions.assertEquals(name, result.getName());
    }
}