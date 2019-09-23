package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("render")
public class RenderController {

    @Autowired
    RenderService renderService;

    @GetMapping(value = "/render")
    public Response render(@RequestParam String url) {
        return renderService.render(url);
    }
}



