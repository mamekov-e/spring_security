package com.example.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String getEmployeePage() {
        return "view-for-all-employee";
    }

    @GetMapping("/hr-info")
    public String getOnlyHRPage() {
        return "view-for-hr-only";
    }

    @GetMapping("/manager-info")
    public String getOnlyManagersPage() {
        return "view-for-managers-only";
    }
}
