import static org.junit.Assert.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPytha {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		NumericStreams Test = new NumericStreams();
		Test.main();
		Stream<int[]> TestVar = Test.pythagoreanTriples;
		Stream<int[]> Mylist = TestVar.limit(1); 
		Mylist.forEach(t -> {
			assertEquals("3, 4, 5", t[0] + ", " + t[1] + ", " + t[2]);
			}); 
		
		boolean One =  Test.isPerfectSquare(1);
		boolean Two =  Test.isPerfectSquare(2);
		boolean Four =  Test.isPerfectSquare(4);
		assertEquals(true, One);
		assertEquals(false, Two);
		assertEquals(true, Four);
	}

}
