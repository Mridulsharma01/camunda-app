package com.camunda.services;

import org.springframework.stereotype.Component;

@Component
public class FetchUserDepartment {
    public String getUserDepartment() {
        System.out.println("coming from FetchUserDepartment's getUserDepartment method");
        return "Computer Science";
    }
}
