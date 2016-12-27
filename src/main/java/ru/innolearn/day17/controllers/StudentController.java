package ru.innolearn.day17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in project Inno-Classroom-Work in 27.12.2016
 */
@Controller
public class StudentController
{
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Kitty");
		return "hello";
	}
}
