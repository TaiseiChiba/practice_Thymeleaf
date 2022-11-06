package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    /**
     * ユーザー情報を全検索します.
     * @return 検索結果
     */
    public List<User> searchAll() {
        return userRepository.findAll();
    }
}
