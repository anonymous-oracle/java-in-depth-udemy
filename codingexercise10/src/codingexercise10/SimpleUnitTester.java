package codingexercise10;

import java.lang.reflect.Method;

public class SimpleUnitTester {

	public int execute(Class clazz) throws Exception {
		int failedCount = 0;
		Class duplicateClass = (Class) clazz.getDeclaredConstructor().newInstance(null);

		for (Method m : duplicateClass.getDeclaredMethods()) {
			if (m.getName().startsWith("test") & m.getReturnType() == boolean.class
					&& m.invoke(duplicateClass, (Object) null).equals(false)) {
				failedCount++;
			}
		}

		return failedCount;
	}

}