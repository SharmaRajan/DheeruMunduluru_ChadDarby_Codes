package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {

		/*List<String> list = new ArrayList<>();
		list.add("Rajan");
		list.add("Atul");
		list.add("Piyush");

		Arrays.asList(list).forEach(val-> System.out.println(val));*/

		return "home";
	}

	// add request mapping for /leaders

	@GetMapping("/leaders")
	public String showLeaders() {

		return "leaders";
	}

	// add request mapping for /systems

	@GetMapping("/systems")
	public String showSystems() {

		return "systems";
	}

}










