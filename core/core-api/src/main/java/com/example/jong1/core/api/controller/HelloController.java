package com.example.jong1.core.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jong1.core.api.common.annotation.TimeCheck;


@RestController
public class HelloController {
	@GetMapping("/hello")
	@TimeCheck
	public String hello() {
		return "hello";
	}
}
