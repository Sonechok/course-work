package codingcity.service.mapper;

import codingcity.dto.UserProgressDTO;
import codingcity.entity.UserProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProgressMapper {
    UserProgressDTO toDTO (UserProgress userProgress);

    UserProgress toEntity (UserProgressDTO userProgressDTO);
}
