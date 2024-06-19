package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error") // Đặt đường dẫn cơ sở cho tất cả các phương thức trong controller này
public class ErrorController {

    @GetMapping("/403")
    public String accessDenied() {
        return "error/403"; // Trả về tên logic của trang lỗi để giải quyết
    }
}
