package com.bbd.springboot.fullstack.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CoursesHardcodedService {

	private static List<Course> courses = new ArrayList<>();
	private static long idCounter = 0;

	static {
		courses.add(new Course(++idCounter, "Java", "Tutorial for Java 8"));
		courses.add(new Course(++idCounter, "React", "Tutorial for React"));
		courses.add(new Course(++idCounter, "HTML", "Tutorial for HTML5 & CSS"));
		courses.add(new Course(++idCounter, "Kubernetes", "Tutorial for kubernets"));
		courses.add(new Course(++idCounter, "Linux", "Tutorial for Linux/Ubuntu"));
		courses.add(new Course(++idCounter, "Data Science", "Tutorial for Data Science"));
	}

	public List<Course> findAll() {
		return courses;
	}

	public Course save(Course course) {
		if (course.getId() == -1 || course.getId() == 0) {
			course.setId(++idCounter);
			courses.add(course);
		} else {
			deleteById(course.getId());
			courses.add(course);
		}
		return course;
	}

	public Course deleteById(long id) {
		Course course = findById(id);

		if (course == null)
			return null;

		if (courses.remove(course)) {
			return course;
		}

		return null;
	}

	public Course findById(long id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}

		return null;
	}
}
