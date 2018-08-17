package soen6441;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import soen6441.Course.Program;

public class ExamQuestion3 {

	// Subtask a)
	private static CompletableFuture<Integer> addCredits (List<Course> courses) {
		return CompletableFuture.supplyAsync( () -> courses.stream().mapToInt(c -> c.getCredits()).sum());
	} 
 		 
 	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 3!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		// Subtask a) -- see method addCredits above
		final CompletableFuture<Integer> futureSum = addCredits(courses);
		 
		// Subtask b)
		futureSum.thenAccept(x -> System.out.println(x));
		
		
		// Subtask c) 
		final CompletableFuture<Boolean> futureStatus = addCredits(courses)
				 										.thenCompose(sum -> CompletableFuture.supplyAsync( () -> sum >= 50 ? true: false));
		 
		 
		futureStatus.thenAccept(x -> System.out.println(x));
		
		
		System.out.println("Goodbye, SOEN6411 Exam Question 3!");
		
		// Added this block just to hold the main thread for some more time
		// So that all the results from other threads (task(a), task(b), task(c)) will be printed.
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
}
