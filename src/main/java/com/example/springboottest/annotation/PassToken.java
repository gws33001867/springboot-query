package com.example.springboottest.annotation;

public @interface PassToken {
    boolean required() default true;
}
