package ca.ntro.core.json;

import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphStructureNtro;

public abstract class   JsonObjectGraphNtro

       extends ObjectGraphNtro
       
       implements ObjectGraph {

	public JsonObjectGraphNtro(Object o) {
		super(o);
	}

	public JsonObjectGraphNtro(Object o, String graphName) {
		super(o, graphName);
	}

	@Override
	protected ObjectGraphStructureNtro newObjectGraphStructureInstance() {
		return new JsonObjectGraphStructure();
	}

}
