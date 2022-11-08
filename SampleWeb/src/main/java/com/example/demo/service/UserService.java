package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
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
    
    /**
     * idからユーザーを取得します。
     * @param id ユーザーID
     * @return IDに紐づくユーザー
     */
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    
    /**
     * ユーザーを登録します。
     * @param userRequest　登録画面からのリクエストデータ
     */
    @Transactional
    public void create(UserRequest userRequest) {
        User user = new User();
        Date now = new Date();
        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setCreateDate(now);
        user.setUpdateDate(now);
        
        userRepository.save(user);
    }
}
