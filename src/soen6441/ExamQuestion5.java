package soen6441;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import soen6441.Course.Program;

public class ExamQuestion5 {
	
	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 5!");
		
		List<Course> coursesJoe = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		List<Student> students = Arrays.asList(
				new Student("Jane", 199999999L, Optional.empty()),
				new Student("Joe", 200000000L, Optional.of(coursesJoe))
				);
		  
		// a) 
		System.out.println("5(a):");
		students.stream().forEach(student -> student.getCourses().ifPresent(courses -> 
														{	
															System.out.print(student.getId() + " : ");
															System.out.println(courses);
														}));
		
		// b) 
		System.out.println();
		System.out.println("5(b):");
		students.stream().forEach(s -> 
								{ 
									System.out.print("Student ID:" + s.getId());
									System.out.println("  Number of Courses: " + s.getCourses().map(courses -> courses.size()).orElse(0)); 
								});
		
		System.out.println();
		System.out.println("Goodbye, SOEN6411 Exam Question 5!");
	}
}
