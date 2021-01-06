package codingcity.service.mapper;

import codingcity.dto.CourseDTO;
import codingcity.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDTO(Course course);

    Course toEntity(CourseDTO courseDTO);
}
