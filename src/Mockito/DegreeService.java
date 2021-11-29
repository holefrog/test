package Mockito;

import java.util.Scanner;

public class DegreeService {
	private static ImpInterface myInterface = new ImpInterface();
	private static Degrees[]  myDgr = new Degrees[4];
	
			
	public static void inputNum() {
		Scanner in = new Scanner(System.in);

		// ini array
		for(int i=0; i<myDgr.length;i++){
			myDgr[i] = new Degrees();
		}
		
		
		int intTotal = 0;

		try {
	
			System.out.println("Enter the number of B.Tech:");
			myDgr[0].setNumber(in.nextInt()) ;
			
			
			System.out.println("Enter the number of M.Tech:");
			myDgr[1].setNumber(in.nextInt()) ;
			
			
			System.out.println("Enter the number of M.S:");
			myDgr[2].setNumber(in.nextInt()) ;
	

			System.out.println("Enter the number of Ph.D:");
			myDgr[3].setNumber(in.nextInt()) ;
			
		} catch(Exception e) {
	        System.out.printf("Wrong input: %s", e.getMessage());
	        
	        System.exit(1);
		}


		for(Degrees d: myDgr){
			intTotal = myInterface.add(intTotal, d.getNumber());
		}
		

		System.out.printf("The total student population is %d.\n", intTotal);

        System.out.printf("The B.Tech. percentage is %2.2f.\n", (float)myDgr[0].getNumber()*100/intTotal);
        System.out.printf("The M.Tech. percentage is %2.2f.\n", (float)myDgr[1].getNumber()*100/intTotal);
        System.out.printf("The M.S percentage is %2.2f.\n", (float)myDgr[2].getNumber()*100/intTotal);
        System.out.printf("The Ph.D percentage is %2.2f.\n", (float)myDgr[3].getNumber()*100/intTotal);
        
        
        //close
        in.close();
	}
	
	public static void rndNum() {
		String cateName;
		
		switch (myInterface.randomize()) {
			case 1:
				cateName = "B.Tech";
				break;
				
			case 2:
				cateName = "M.Tech";
				break;
				
			case 3:
				cateName = "M.S";
				break;
				
			case 4:
				cateName = "Ph.D";
				break;
				
			default:
				cateName = "N/A";
				break;
				
		}

		System.out.println(String.format("%s will host this year's fair!\n", cateName));
	}
}
