package Unit3;

import java.util.Random;

public class ImpInterface implements AbsInterface{

	@Override
	public int add(Degrees[] input) {
		int intTotal = 0;
		
		for(Degrees d: input){
			intTotal = intTotal + d.getNumber();
		}
		
		return intTotal;
	}

	
	@Override
	public int randomize() {
		Random rand = new Random();

		return rand.nextInt(4);
	}

}
