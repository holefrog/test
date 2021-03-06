package Unit3;

import java.util.Scanner;

public class DegreeService {
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
	
	
	// calcPerctage
	private static void calcPerctage (int intTotal) {
		for (int i=0;i<myDgr.length;i++) {
			myDgr[i].setPercent((float)myDgr[i].getNumber()*100/intTotal);
		
			System.out.printf("The " 
					+ myDgr[i].getName() 
					+ " percentage is %2.2f.\n", myDgr[i].getPercent());
		}
	}
	

	

	// main
	public static void main(String[] args) {
		ImpInterface myInterface = new ImpInterface();
		int intTotal, intRnd;
		
		
		// iniData
		iniData();
		
		
		// inputNum
		inputNum();
		

		
		// Total
        intTotal = myInterface.add(myDgr);
		System.out.printf("The total student population is %d.\n", intTotal);

		
		
		// percent
		calcPerctage(intTotal);
		
		
		
		// Random
		try{
			intRnd= myInterface.randomize();
			System.out.println(String.format("%s will host this year's fair!\n", myDgr[intRnd].getName()));

		} catch(Exception e) {
	        System.out.printf("Wrong index: %s", e.getMessage());
	        
	        System.exit(1);
		}
	}
}