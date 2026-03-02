package com.serralyse.website.service;

import com.serralyse.website.dto.UserRegisterRequest;
import com.serralyse.website.entity.User;
import com.serralyse.website.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(UserRegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("This email is used by another user");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        //sonra değişecek burası
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }
    public List<User> listAll(){
        return userRepository.findAll();
    }
}
