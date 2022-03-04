package ca.ntro.app.services;

import ca.ntro.app.models.Model;

public interface ModelStore {
	
	void watch(Class<?> modelClass);
	
	<M extends Model> M load(Class<?> modelClass);

	void save(Object model);
	
	void writeGraphs();

}
