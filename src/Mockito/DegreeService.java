package Mockito;

import java.util.Scanner;

public class DegreeService {
	private static ImpInterface myInterface = new ImpInterface();
	
			
	public static void inputNum() {
		Scanner in = new Scanner(System.in);

		int intBT = 0;
		int intMT = 0;
		int intMS = 0;
		int intPhD = 0;
		int intTotal = 0;

		try {
	
			System.out.println("Enter the number of B.Tech:");
			intBT = in.nextInt();
			intTotal = myInterface.add(intTotal, intBT);
			
			
			System.out.println("Enter the number of M.Tech:");
			intMT = in.nextInt();
			intTotal = myInterface.add(intTotal, intMT);
			
			
			System.out.println("Enter the number of M.S:");
			intMS = in.nextInt();
			intTotal = myInterface.add(intTotal, intMS);
			
	
			System.out.println("Enter the number of Ph.D:");
			intPhD = in.nextInt();
			intTotal = myInterface.add(intTotal, intPhD);
			
		} catch(Exception e) {
	        System.out.println("Wrong input!");
	        
	        System.exit(1);
		}

        System.out.printf("The total student population is %d\n", intTotal);

        System.out.printf("The B.Tech. percentage is %2.2f\n", (float)intBT*100/intTotal);
        System.out.printf("The M.Tech. percentage is %2.2f\n", (float)intMT*100/intTotal);
        System.out.printf("The M.S percentage is %2.2f\n", (float)intMS*100/intTotal);
        System.out.printf("The Ph.D percentage is %2.2f\n", (float)intPhD*100/intTotal);
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