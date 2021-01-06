package codingcity.repository;

import codingcity.dto.UserDTO;
import codingcity.entity.User;
import codingcity.service.CourseService;
import codingcity.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @Test
    void createUser() {
        UserDTO userDTO = new UserDTO("sasha", "hladun", "olexandr", "USER", 5 );
        UserDTO result = userService.createUser(userDTO);
        Assertions.assertEquals("sasha", result.getFirstName());
    }


    @Test
    void createAdminUser() {
        UserDTO userDTO = new UserDTO("ADMIN", "ADMIN", "ADMIN@ADMIN", "NIMDA12345", 0);
        UserDTO result = userService.createUser(userDTO);
        Assertions.assertEquals("ADMIN", result.getFirstName());
    }



    @Test
    void updateUser(){
        User user = new User(1L,"Sasha", "hladun", "email","3", 9 );
        Long courseId = 2L;
        user.getCourses().add(courseService.findById(courseId));
        UserDTO result = userService.updateUser(user);
        Assertions.assertEquals("Sasha", result.getFirstName());
        Assertions.assertEquals(9, result.getAmountOfMoney());
    }

    @Test
    void findByEmail() {
        UserDTO result = userService.findByEmail("4");
        Assertions.assertEquals("Sasha", result.getFirstName());
    }
}
