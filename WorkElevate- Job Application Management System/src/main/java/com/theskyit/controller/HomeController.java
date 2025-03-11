package com.theskyit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//    @GetMapping("/")
//    public String home() {
//        logger.info("Home page accessed");
//        return "index.html"; // index.html will be served from src/main/resources/static
//    }
}
