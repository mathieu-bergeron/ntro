package ca.ntro.core.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.List;


import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.ObjectBuilderNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;

public class ObjectBuilderJdk extends ObjectBuilderNtro {

	public ObjectBuilderJdk(ObjectGraphNtro graph) {
		super(graph);
	}

	@Override
	protected void setAttribute(Object object, String attributeName, Object attributeValue) {
		String setterName = ReflectionUtils.setterNameFromAttributeName(attributeName);
		
		invokeSetter(object, setterName, attributeValue);
	}

	public static void invokeSetter(Object object, String setterName, Object attributeValue) {

		try {

			Method method = Ntro.reflection().getMethodByName(object.getClass(), setterName);
			
			if(method == null) {
				Ntro.throwException("[FATAL] setter not found: " + setterName(object, setterName));
			}
			
			attributeValue = convertListToArrayIfNecessary(method, attributeValue);

			method.invoke(object, attributeValue);

		} catch (IllegalArgumentException e) {
			
			Ntro.throwException("[FATAL] cannot invoke setter " + setterName(object, setterName) + " with parameter of type " + attributeValue.getClass());

		} catch (SecurityException | IllegalAccessException | InvocationTargetException e) {

			Ntro.throwException(e);
		}
	}
	
	private static Object convertListToArrayIfNecessary(Method method, Object attributeValue) {
		Object result = attributeValue;
		
		Class<?> paramType = null;

		if(method.getParameterTypes().length > 0) {
			
			paramType = method.getParameterTypes()[0];

		}else {
			
			Ntro.throwException("[FATAL] setter must have a least one input parameter " + method.getName());

		}

		if(paramType != null
				&& paramType.isArray()
				&& attributeValue != null
				&& attributeValue instanceof List) {
			
			result = convertListToArray(paramType, (List<?>) attributeValue);

		}
		
		return result;
	}

	private static Object convertListToArray(Class<?> arrayType, List<?> list) {

		Class<?>  componentType = arrayType.getComponentType();
		
		Object array = Array.newInstance(componentType, list.size());
		
		for(int i = 0; i < list.size(); i++) {
			Object value = list.get(i);

			if(componentType.isArray()
					&& value != null
					&& value instanceof List) {
				
				value = convertListToArray(componentType, (List<?>) value);
			}

			Array.set(array, i, value);
		}

		return array;
	}

	private static String setterName(Object object, String setterName) {
		return Ntro.reflection().simpleName(object.getClass()) + "." + setterName;
	}


}
