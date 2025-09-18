package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepo;

  public UserService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public User saveUser(User user) {
    return userRepo.save(user);
  }

  public Optional<User> getUser(Long id) {
    return userRepo.findById(id);
  }
}
