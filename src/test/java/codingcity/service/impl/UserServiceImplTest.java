package codingcity.service.impl;

import codingcity.dto.UserDTO;
import codingcity.entity.User;
import codingcity.repository.RoleRepository;
import codingcity.repository.UserRepository;
import codingcity.service.UserService;
import codingcity.service.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserService userService;

    UserRepository userRepository;

    UserMapper userMapper;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        userService = new UserServiceImpl(userRepository, userMapper, bCryptPasswordEncoder, roleRepository);

    }

    @Test
    void createUser() {
        UserDTO userDTO = new UserDTO("sasha", "hladun", "newEmail","3",  5 );
        when(userMapper.toDTO(any())).thenReturn(userDTO);
        UserDTO result = userService.createUser(userDTO);
        Assertions.assertEquals("sasha", result.getFirstName());
        verify(userMapper, times(1)).toDTO(any());
        verify(userMapper).toEntity(any());
        verify(userRepository).save(any());

    }


    @Test
    void updateUser(){
        User user = new User(1L,"Sasha", "hladun", "email","3", 5 );
        UserDTO result = userService.updateUser(user);
        Assertions.assertEquals("Sasha", result.getFirstName());
    }

    @Test
    void findByEmail() {
    }
}
