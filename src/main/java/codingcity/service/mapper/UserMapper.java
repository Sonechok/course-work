package codingcity.service.mapper;

import codingcity.dto.UserDTO;
import codingcity.entity.Role;
import codingcity.entity.User;
import codingcity.entity.UserDetailsImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO (User user);

    User toEntity (UserDTO userDTO);

    @Mapping(source = "roles", target = "authorities")
    UserDetailsImpl toUserDetails(User user);
}
