package com.theskyit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CsrfController {
	
	@GetMapping("/csrf-token")
	public Map<String, String> getCsrfToken(HttpServletRequest request) {
	    // Log all request attributes for debugging
	    request.getAttributeNames().asIterator()
	        .forEachRemaining(attr -> System.out.println(attr + ": " + request.getAttribute(attr)));

	    // Extract CSRF token from request
	    CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
	    if (csrfToken == null) {
	        System.out.println("CSRF Token is null!");
	    } else {
	        System.out.println("CSRF Token: " + csrfToken.getToken());
	    }

	    // Return CSRF token in response
	    Map<String, String> response = new HashMap<>();
	    response.put("token", csrfToken != null ? csrfToken.getToken() : "null");
	    return response;
	}
}
