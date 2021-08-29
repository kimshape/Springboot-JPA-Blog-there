package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
    //localhost:8000/temp/home/
    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHome()");
        //파일리턴 기본경로 : src/main/resources/static
        //리턴명 : /home.html

        return "/home.html";

    }

    //localhost:8000/temp/home/
    @GetMapping("/temp/jsp")
    public String tempJsp() {
        System.out.println("tempJsp()");
        // prefix : /WEB-INF/views/
        // suffix : .jsp
        // 풀네임  : /WEB-INF/views/"return".jsp
        return "test";

    }
}
