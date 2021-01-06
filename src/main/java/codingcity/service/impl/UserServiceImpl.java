package codingcity.service.impl;

import codingcity.dto.UserDTO;
import codingcity.entity.User;
import codingcity.entity.Role;
import codingcity.error.ResourceNotFoundException;
import codingcity.repository.RoleRepository;
import codingcity.repository.UserRepository;
import codingcity.service.UserService;
import codingcity.service.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getAmountOfMoney() == null){
            userDTO.setAmountOfMoney(0);
        }
        User user = userMapper.toEntity(userDTO);
        Role role = roleRepository.findByName("USER").orElseThrow(() -> new ResourceNotFoundException("ROLE_User", "ROLE_USER"));
        user.getRoles().add(role);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDTO updateUser(User user) {
        if (user.getAmountOfMoney() == null){
            user.setAmountOfMoney(0);
        }
        User userToUpdate = userRepository.getOne(user.getId());
        BeanUtils.copyProperties(user, userToUpdate, "email", "amountOfMoney");
        userToUpdate.setAmountOfMoney(user.getAmountOfMoney());
        return userMapper.toDTO(userRepository.save(userToUpdate));
    }

    @Override
    @Transactional
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("email",email));
        return userMapper.toDTO(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("email",email));
    }

    @Override
    public long count() {
            return userRepository.count();
    }

    @Override
    public UserDTO updateAmountOfMoney(User user, Integer amountOfMoney) {
        if (user.getAmountOfMoney() == null){
            user.setAmountOfMoney(0);
        }
        User userToUpdate = userRepository.getOne(user.getId());
        userToUpdate.setAmountOfMoney(user.getAmountOfMoney()+amountOfMoney);
        return userMapper.toDTO(userRepository.save(userToUpdate));
    }


}
