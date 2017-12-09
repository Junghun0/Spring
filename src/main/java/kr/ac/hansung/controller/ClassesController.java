package kr.ac.hansung.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Classes;
import kr.ac.hansung.service.ClassesService;

@Controller
public class ClassesController {
	
	private ClassesService classesService;

	@RequestMapping("/classes")
	public String showOffers(Model model) {

		List<Classes> classes = classesService.getCurrentInCourse();
		model.addAttribute("classes", classes);

		return "classes";
	}

	@RequestMapping("/createcourse")
	public String createOffer(Model model) {

		return "createcourse";
	}

	@Autowired
	public void setOffersService(ClassesService offersService) {
		this.classesService = offersService;
	}

	@RequestMapping("/docreate")
	public String doCreate(Model model, Classes classes) {

		classesService.insert(classes);
		return "home";
	}

	@RequestMapping("/semester_grades")
	public String semesterGrades(Model model) {

		int minYear = classesService.getMinYear();
		int maxYear = classesService.getMaxYear();
		List<Integer> years = new ArrayList<Integer>();
		List<Integer> grades = new ArrayList<Integer>();

		for (int z = minYear; z <= maxYear; z++) {
			years.add(z);
		}
		int number = -1;
		for (int i = minYear; i <= maxYear; i++) {
			for (int j = 1; j <= 2; j++) {
				int totalGrades = 0;
				List<Classes> temp = classesService.getCurrentInCourse(i, Integer.toString(j));
				number++;
				for (Classes temps : temp)
					totalGrades += temps.getCredit();
				grades.add(totalGrades);
			}
		}
		model.addAttribute("grades", grades);
		model.addAttribute("number", number);
		model.addAttribute("years", years);
		return "semestergrades";
	}

	@RequestMapping("/classeslist")
	public String courseList(Model model, int year, String semester) {
		List<Classes> classes = classesService.getCurrentInCourse(year, semester);
		model.addAttribute("classes", classes);
		return "classes";
	}

	@RequestMapping("/value_grades")
	public String valueGrades(Model model) {

		int allSumValue = classesService.getSumVlues();
		model.addAttribute("allSumValue", allSumValue);

		int num = classesService.getSumVlues("전지");
		model.addAttribute("GG", num);
		num = classesService.getSumVlues("교필");
		model.addAttribute("GP", num);
		num = classesService.getSumVlues("전기");
		model.addAttribute("Gungi", num);
		num = classesService.getSumVlues("전선");
		model.addAttribute("GS", num);
		num = classesService.getSumVlues("일선");
		model.addAttribute("IL", num);

		num = classesService.getSumVlues("핵교B");
		int num2 = classesService.getSumVlues("핵교A");
		model.addAttribute("HG", num + num2);

		return "valuegrades";
	}

	@RequestMapping("/lookupcourse")
	public String lookupCourse(Model model) {
		List<Classes> classes = classesService.getCurrentInVirtualCourse();
		model.addAttribute("classes", classes);
		return "classes";
	}


}
