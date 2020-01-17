package com.example.springboottest.po;

import javax.validation.constraints.NotBlank;

public class User {
    private String id;

    @NotBlank(message = "密码不能为空")
    private String password;
}
