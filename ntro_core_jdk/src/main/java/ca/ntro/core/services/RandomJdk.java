package ca.ntro.core.services;


public class    RandomJdk 

	   extends  RandomNtro

       implements Random {
	
	private java.util.Random random = new java.util.Random(System.currentTimeMillis());

	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}

	@Override
	public int nextInt() {
		return random.nextInt();
	}

	@Override
	public int nextInt(int bound) {
		return random.nextInt(bound);
	}

	@Override
	public double nextDouble() {
		return random.nextDouble();
	}

	@Override
	public double nextDouble(double bound) {
		return random.nextDouble() * bound;
	}


}
