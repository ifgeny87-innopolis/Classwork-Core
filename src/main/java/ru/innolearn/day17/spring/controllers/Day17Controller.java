package ru.innolearn.day17.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innolearn.day17.spring.model.Student;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created in project Inno-Classroom-Work in 27.12.2016
 */
@Controller
@RequestMapping("/day17")
public class Day17Controller
{
	/**
	 * Метод отработает для корня
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String rootAction(Model model)
	{
		// В модель запишу атбирут
		model.addAttribute("message", "Root method");
		return "hello";
	}

	@RequestMapping("/test")
	public String testAction(Model model)
	{
		// В модель запишу атбирут
		model.addAttribute("message", "Test method called");
		return "hello";
	}

	/**
	 * В этом методе я передаю имя вьюхи и свою модель
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/my/{name}", method = RequestMethod.GET)
	public ModelAndView helloByName(@PathVariable String name, Model model)
	{
		// В модель запишу атбирут
		model.addAttribute("message", "Your name is " + name);

		// Но я хочу передать еще данные
		// Я могу и в model записать этот объект, но для примера сделаю так:
		Map<String, Object> models = new HashMap<>();
		models.put("name", name);
		models.put("saya", "Vzzzhuh!");
		// сообщу сервлету:
		// - какую страницу вызвать
		// - как будет называться моя модель
		// - что модель будет содержать
		return new ModelAndView("hello", "model", models);
	}

	/**
	 * TODO доразобраться надо с примером
	 *
	 * @param body
	 * @param writer
	 * @throws IOException
	 */
	@RequestMapping("/body")
	public void handle(@RequestBody String body, Writer writer) throws IOException
	{
		writer.write(body);
		writer.flush();
	}

	/**
	 * Нативный вывод тела
	 * Вообще не рекомендуется так делать
	 *
	 * @return
	 */
	@RequestMapping("/string")
	@ResponseBody
	public String jsonAction()
	{
		return "{\"name\":\"Ivan\",\"age\":25}";
	}

	/**
	 * Пример JSON вывода
	 * @return
	 */
	@RequestMapping("/json")
	public @ResponseBody
	Object objectAction()
	{
		return new Object[]{
				1, false, "try", 4.2, 5.,
				new String[] { "First", "\u0920\u1356", "Line\nLine"},
				new int[] {1,2,3,4,-2},
				new String("strong"),
				new Student("Kaly", 12)
		};
	}
}