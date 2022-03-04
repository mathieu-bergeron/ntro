package ca.ntro.core.json;


import java.util.Map;

import ca.ntro.core.graphs.common.NodeId;
import ca.ntro.core.reflection.object_graph.LocalHeap;
import ca.ntro.core.reflection.object_graph.LocalHeapNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectNode;

public class LocalJsonHeap  
       
       extends LocalHeapNtro {
	
	
	public LocalJsonHeap(ObjectGraphNtro graph) {
		super(graph);
	}


	@Override
	protected ObjectNode createNode(ObjectGraphNtro graph, 
			                        LocalHeap localHeap, 
			                        Object object, 
			                        NodeId nodeId, 
			                        boolean isStartNode) {

		return new JsonObjectNodeNtro(graph, localHeap, object, nodeId, isStartNode);
	}


	@Override
	public ObjectNode findNodeInHeap(Object object) {
		ObjectNode referencedNode = null;
		
		if(object instanceof Map) {
			Map map = (Map) object;

			String referencedNodeId = (String) map.get(JsonObject.REFERENCE_KEY);
			
			if(referencedNodeId != null) {

				referencedNode = getGraph().findNode(referencedNodeId);
			}
		}

		if(referencedNode == null) {
			
			return super.findNodeInHeap(object);
			
		}else {
			
			return referencedNode;

		}
	}


}
