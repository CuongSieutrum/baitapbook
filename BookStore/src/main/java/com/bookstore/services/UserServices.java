package com.bookstore.services;

import com.bookstore.entity.User;
import com.bookstore.repository.IRoleRepository;
import com.bookstore.repository. IUserRepository;
import org.springframework.beans.factory.annotation. Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public void save(User user) {
        userRepository.save(user) ;
        Long userId = userRepository.getUserIdUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdName("USER");
        if(roleId != 0 && userId != 0)
        {
            userRepository.addRoleToUser(userId,roleId);
        }
    }
}