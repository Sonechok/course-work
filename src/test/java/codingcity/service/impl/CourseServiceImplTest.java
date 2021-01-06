package codingcity.service.impl;

import codingcity.dto.CourseDTO;
import codingcity.repository.CourseRepository;
import codingcity.service.CourseService;
import codingcity.service.mapper.CourseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CourseServiceImplTest {
    CourseService courseService;

    CourseMapper courseMapper;

    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository = Mockito.mock(CourseRepository.class);
        courseMapper = Mockito.mock(CourseMapper.class);
        courseService = new CourseServiceImpl(courseMapper, courseRepository);
    }

    @Test
    void createCourse() {
        CourseDTO courseDTO = new CourseDTO("First", "description", 100);
        when(courseMapper.toDTO(any())).thenReturn(courseDTO);
        CourseDTO result = courseService.createCourse(courseDTO);
        Assertions.assertEquals("First", result.getName());
        verify(courseMapper).toDTO(any());
        verify(courseMapper).toEntity(any());
        verify(courseRepository).save(any());
    }
}