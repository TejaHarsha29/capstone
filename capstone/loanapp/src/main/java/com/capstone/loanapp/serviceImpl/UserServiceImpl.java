package com.capstone.loanapp.serviceImpl;

import com.capstone.loanapp.dto.UserDto;
import com.capstone.loanapp.model.Users;
import com.capstone.loanapp.repository.UserRepository;
import com.capstone.loanapp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users user = userDtoToEntity(userDto);
        userRepository.save(user);
        return userToUserDto(user);
    }


    private Users userDtoToEntity(UserDto userDto){
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setLocation(userDto.getLocation());
        users.setPassword(userDto.getPassword());
        users.setLoan_amount(userDto.getLoan_amount());
        users.setLoan_amount_used(userDto.getLoan_amount_used());
        return users;
    }

    private UserDto userToUserDto(Users users){
        UserDto userDto=new UserDto();
        userDto.setId(users.getId());
        userDto.setName(users.getName());
        userDto.setEmail(users.getEmail());
        userDto.setLocation(users.getLocation());
        userDto.setPassword(users.getPassword());
        userDto.setLoan_amount(users.getLoan_amount());
        userDto.setLoan_amount_used(users.getLoan_amount_used());
        return userDto;

    }
}
