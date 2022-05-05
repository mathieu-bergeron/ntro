package ca.ntro.core.services;

import java.util.List;

public interface Random {
	
	boolean nextBoolean();
	
	int nextInt();
	int nextInt(int bound);

	double nextDouble();
	double nextDouble(double bound);
	
	<V> V choice(List<V> list);
	<V> V choice(V[] array);


}
