package ca.ntro.core.json;

import java.util.Map;

public interface JsonObject extends Map<String,Object> {
	
	public static final String TYPE_KEY = "_C";
	public static final String REFERENCE_KEY = "_R";
	
	
	String toJsonString();
	String toJsonString(boolean prettyPrint);
	
	
	// JSWEET
	// must explicitely redeclare Map interface
	Object put(String key, Object value);

	// JSWEET
	// must explicitely redeclare Map interface
	Object get(Object key);
	

}
