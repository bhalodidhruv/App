package soen6441;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import soen6441.Course.Program;
 
public class ExamQuestion4Tests {
	
	@Test
	public void TestReturnValidResultForValidCourse(){
		//Data
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4));
		
		//Action
		int expected_credits = 4;
		int credits_app = ExamQuestion4.getCredits(courses, Program.SOEN, "6441");
		int credits_hfd = ExamQuestion4.getCredits(courses, Program.SOEN, "6441");
		 
		//Assert 
		assertEquals(expected_credits, credits_app);
		assertEquals(expected_credits, credits_hfd);
	}
	
	@Test
	public void TestWithNullCourseList(){
		List<Course> courses = null;
		
		int credits_app = ExamQuestion4.getCredits(courses, Program.SOEN, "6441");
		 
		int expected_credits = 0;
		assertEquals(expected_credits, credits_app);
	}
	
	@Test
	public void TestWithInvalidCourseNumber(){
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4));
		
		int credits_app = ExamQuestion4.getCredits(courses, Program.SOEN, "123456");
		int expected_credits = 0;
		
		assertEquals(expected_credits, credits_app);
	}
	
	@Test
	public void TestWithInvalidProgram(){
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4));
		
		int credits_app = ExamQuestion4.getCredits(courses, Program.COMP, "123456");
		int expected_credits = 0;
		
		assertEquals(expected_credits, credits_app);
	}
	
	
	@Test
	public void TestWithDuplicateCourseShouldReturnFirstMatch(){
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 8),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4));
		
		int credits_app = ExamQuestion4.getCredits(courses, Program.SOEN, "6441");
		
		assertEquals(4, credits_app);
	}
	
	
}
