package com.ecommerce.service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return usersRepository.findUserByEmailAndPassword(email, password);
    }
}
