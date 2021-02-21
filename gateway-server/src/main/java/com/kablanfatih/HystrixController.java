package com.kablanfatih;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class HystrixController {

    @GetMapping("company")
    public String companyFallback(){
        return "Company Service is not available.";
    }

    @GetMapping("/content")
    public String contentFallback(){
        return "Content Service is not available.";
    }
}
