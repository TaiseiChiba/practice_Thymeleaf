package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 登録画面からのリクエストデータを格納します。
 */
@Data
public class UserRequest implements Serializable {
    
    /**
     * 名前
     */
    @NotEmpty(message="名前を入力してください")
    @Size(max = 100, message="名前は100文字以内で入力してください")
    private String name;
    
    /**
     * 住所
     */
    @Size(max = 255, message="住所は256文字以内で入力してください")
    private String address;
    
    /**
     * 電話番号
     * \d：全ての数字(0~9)
     */
    @Pattern(regexp="0\\d{1,4}-\\d{4}-\\d{4}", message="電話番号の形式で入力してください")
    private String phone;
}
