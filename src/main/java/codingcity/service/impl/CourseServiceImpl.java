package codingcity.service.impl;

import codingcity.dto.CourseDTO;
import codingcity.entity.Course;
import codingcity.error.ResourceNotFoundException;
import codingcity.repository.CourseRepository;
import codingcity.service.CourseService;
import codingcity.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper, CourseRepository courseRepository) {
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public CourseDTO createCourse(CourseDTO courseDTO) {
        if(courseDTO.getPrice() == null){
            courseDTO.setPrice(0);
        }
        Course course = courseMapper.toEntity(courseDTO);
        return courseMapper.toDTO(courseRepository.save(course));
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",id.toString()));
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public long count() {
        return courseRepository.count();
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name).orElseThrow(()->new ResourceNotFoundException("name",name));
    }
}
