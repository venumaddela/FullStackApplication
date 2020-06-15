package venu.java.in.use.emp.reg.fullstack.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import venu.java.in.use.emp.reg.fullstack.app.entity.Course;

@Service
public class CourseHardCodeService {

	private static List<Course> courses = new ArrayList<>();
	private static long idCounter = 0;

	static {
		courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and Angular"));
		courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and React"));
		courses.add(new Course(++idCounter, "in28minutes", "Master Microservices with Spring Boot and Spring Cloud"));
		courses.add(new Course(++idCounter, "in28minutes",
				"Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"));
	}

	public List<Course> findAll() {
		return courses;
	}

	public Course deleteById(long id) {
		Course cources = findById(id);
		if (cources == null) {
			return null;
		}
		if (courses.remove(cources)) {
			return cources;
		}
		return null;

	}

	public Course findById(long id) {
		for (Course courses : courses) {
			if (courses.getId() == id) {
				return courses;
			}
		}
		return null;

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
}
