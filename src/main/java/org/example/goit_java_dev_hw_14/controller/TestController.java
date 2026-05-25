package org.example.goit_java_dev_hw_14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
@RequestMapping("/test")
public class TestController {
    private static Random random = new Random();
    @GetMapping
    public ModelAndView test() {
        ModelAndView result = new ModelAndView("test");
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        long sum = a + b;
        result.addObject("a", a);
        result.addObject("b", b);
        result.addObject("sum", sum);

        return result;
    }
}
