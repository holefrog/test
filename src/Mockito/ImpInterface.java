package Mockito;

import java.util.Random;

public class ImpInterface implements AbsInterface{

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int randomize() {
		Random rand = new Random();

		return rand.nextInt(4) + 1;
	}

}
