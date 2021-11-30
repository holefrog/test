package Unit3;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


class DegreeServiceTest {
	private static Degrees[]  myDgr = new Degrees[4];
	
	// iniData
	private static void iniData() {
		myDgr[0] = new Degrees();
		myDgr[0].setName("B.Tech");
		

		myDgr[1] = new Degrees();
		myDgr[1].setName("M.Tech");
		

		myDgr[2] = new Degrees();
		myDgr[2].setName("M.S");

		myDgr[3] = new Degrees();
		myDgr[3].setName("Ph.D");
	}


	// inputNum
	private static void inputNum() {
		// input
		Scanner in = new Scanner(System.in);

		for (int i=0;i<myDgr.length;i++) {
			try {
				System.out.println("Enter the number of " + myDgr[i].getName() );
				myDgr[i].setNumber(in.nextInt()) ;
			
				} catch(Exception e) {
			        System.out.printf("Wrong input: %s", e.getMessage());
			        
			        System.exit(1);
				}
		}

		//close
        in.close();
	}

	@Test
	private static void inputTest() throws Exception {
		String dataIn = "131\n225\n333\n1124\n";
		InputStream stdIn = System.in;
		
		
		// input

		try {
			System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
			inputNum();
	
		} catch (Exception e) {
	        System.out.printf("Wrong input: %s", e.getMessage());
				
		} finally {
			System.setIn(stdIn);

		}
	}
	
	
	// calcPerctage
	private static void calcPerctage (int intTotal) {
		for (int i=0;i<myDgr.length;i++) {
			myDgr[i].setPercent((float)myDgr[i].getNumber()*100/intTotal);
		
			System.out.printf("The " 
					+ myDgr[i].getName() 
					+ " percentage is %2.2f.\n", myDgr[i].getPercent());
		}
	}
	

	@Test
	void testMain() throws Exception {
		int intTotal, intRnd;
		
		//  mock
		ImpInterface mockInterface = Mockito.mock(ImpInterface.class);
        when(mockInterface.randomize()).thenReturn(-1);
        when(mockInterface.add(myDgr)).thenReturn(100);

        assertEquals(mockInterface.randomize(), -1);
        assertEquals(mockInterface.add(myDgr), 100);
		
		
		
		// iniData
		iniData();
		
		
		// inputNum
		// inputNum();
		inputTest();
		

		
		// Total
        intTotal = mockInterface.add(myDgr);
		System.out.printf("The total student population is %d.\n", intTotal);

		
		
		// percent
		calcPerctage(intTotal);
		
		
		
		// Random
		try{
			intRnd= mockInterface.randomize();
			System.out.println(String.format("%s will host this year's fair!\n", myDgr[intRnd].getName()));

		} catch(Exception e) {
	        System.out.printf("Wrong index: %s", e.getMessage());
	        
	        System.exit(1);
		}

	}
}
