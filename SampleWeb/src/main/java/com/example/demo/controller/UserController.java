package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("user/list")
    public String displayList(Model model) {
        List<User> userList = userService.searchAll();
        model.addAttribute(userList);
        return "user/list";
    }

    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("user/add")
    public String displayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "user/add";
    }
    
    /**
     * ユーザーを新規登録します。
     * @param userRequest 登録画面からのリクエストデータ
     * @param result 
     * @param model
     * @return
     */
    @PostMapping("user/create")
    public String create(@Validated @ModelAttribute UserRequest userRequest,
            BindingResult result,
            Model model) {
        // 入力エラーがある場合
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for(ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            model.addAttribute("userRequest", userRequest);
            return "user/add";
        }
        // 新規ユーザーの登録
        userService.create(userRequest);
        return "redirect:/user/list";
    }

    /**
     * ユーザー情報詳細画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("user/{id}")
    public String displayView(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("userData", user);
        return "user/view";
    }
}
