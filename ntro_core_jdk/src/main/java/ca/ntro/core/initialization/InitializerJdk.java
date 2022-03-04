package ca.ntro.core.initialization;

import ca.ntro.core.identifyers.ClassId;
import ca.ntro.core.identifyers.ObjectId;
import ca.ntro.core.services.AsserterJdk;
import ca.ntro.core.services.CollectionsJdk;
import ca.ntro.core.services.ExceptionThrowerDefault;
import ca.ntro.core.services.GraphWriterJdk;
import ca.ntro.core.services.JsonServiceJdk;
import ca.ntro.core.services.RandomJdk;
import ca.ntro.core.services.ReflectionServiceJdk;
import ca.ntro.core.services.StackAnalyzerJdk;
import ca.ntro.core.services.StorageService;
import ca.ntro.core.services.StorageServiceJdk;
import ca.ntro.core.services.TimeJdk;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.values.ObjectMap;
import ca.ntro.core.wrappers.result.Result;

public class InitializerJdk 
       extends InitializerNtro {

	public void executeBlocking() {
		
		// FIXME!!!
		Ntro.registerExceptionThrower(new ExceptionThrowerDefault());
		Ntro.registerStackAnalyzer(new StackAnalyzerJdk());
		Ntro.registerReflectionService(new ReflectionServiceJdk());
		Ntro.registerGraphWriter(GraphWriterJdk.class);
		Ntro.registerCollections(new CollectionsJdk());
		Ntro.registerTime(new TimeJdk());
		Ntro.registerAsserter(new AsserterJdk());
		Ntro.registerRandom(new RandomJdk());
		Ntro.registerJsonService(new JsonServiceJdk());
		Ntro.registerStorageService(provideStorageService());
		
		
	}
	
	protected StorageService provideStorageService() {
		return new StorageServiceJdk();
	}


	@Override
	protected Task provideInitializationTask(ObjectId objectId) {

		Task task = null;
		
		return task;
	}

	@Override
	protected Task provideInitializationTask(ClassId<? extends Object> classId) {

		return null;
	}







}
