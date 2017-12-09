package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ClassDAO;
import kr.ac.hansung.model.Classes;

@Service
public class ClassesService {
	private ClassDAO classdao;

	@Autowired
	public void setOfferDao(ClassDAO classdao) {
		this.classdao = classdao;
	}

	public void insert(Classes classes) {
		classdao.insert(classes);
	}

	public List<Classes> getCurrentInCourse() {
		return classdao.getOffersInCourse();
	}

	public List<Classes> getCurrentInVirtualCourse() {
		return classdao.getOffersInVirtualCourse();
	}

	public List<Classes> getCurrentInCourse(int year, String semester) {
		return classdao.getOffersInCourse(year, semester);
	}

	public int getMinYear() {
		return classdao.getMinYear();
	}

	public int getMaxYear() {
		return classdao.getMaxYear();
	}

	public int getSumVlues(String section) {
		return classdao.sumValues(section);
	}

	public int getSumVlues() {
		return classdao.sumValues();
	}

}
