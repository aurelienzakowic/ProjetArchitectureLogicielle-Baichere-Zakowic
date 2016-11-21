import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class Methodes implements IMethodes {

	
	@Override
	public String[] getMethods(Class<?> c) {
		Method[] m = c.getDeclaredMethods();
		int l = m.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}
		for (int i = 0; i < l; i++) {
			str[i] = str[i] + m[i].getName();

			str[i] = str[i] + "( ";

			Class<?>[] t = m[i].getParameterTypes();
			for (int j = 0; j < t.length; j++) {
				str[i] = str[i] + t[j].getSimpleName() + " ";
			}

			str[i] = str[i] + ") : ";

			str[i] = str[i] + m[i].getReturnType().getSimpleName();

		}

		return str;
	}

	@Override
	public String getNomPackage(Class<?> c) {
		return c.getPackage().getName();
	}

	@Override
	public String[] getConstructeurs(Class<?> c) {
		Constructor[] constructors = c.getDeclaredConstructors();
		int l = constructors.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}

		for (int i = 0; i < constructors.length; i++) {
			str[i] = str[i]
					+ constructors[i].getName().substring(
							c.getPackage().getName().length() + 1,
							constructors[i].getName().length());

			str[i] = str[i] + "( ";

			for (int j = 0; j < constructors[i].getParameterTypes().length; j++) {
				str[i] = str[i]
						+ constructors[i].getParameterTypes()[j]
								.getSimpleName() + " ";
			}

			str[i] = str[i] + ")";
		}
		return str;
	}

	@Override
	public String[] getVariablesInstance(Class<?> c) {
		Field[] fields = c.getDeclaredFields();
		int l = fields.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}

		for (int i = 0; i < l; i++) {
			str[i] = str[i] + fields[i].getName() + " : "
					+ fields[i].getType().getSimpleName();
		}
		return str;
	}

	@Override
	public String getClasseMere(Class<?> c) {
		String str = "";
		try {
			str = c.getSuperclass()
					.getName()
					.substring(
							c.getSuperclass().getPackage().getName().length() + 1);
		} catch (Exception e) {
			System.out.println("probleme");
		}
		return str;
	}

	@Override
	public String[] getClassesImplementant(Class<?> c) {

		Class<?>[] interfaces = c.getInterfaces();
		int l = interfaces.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}

		for (int i = 0; i < l; i++) {
			str[i] = str[i]
					+ interfaces[i].getName().substring(
							interfaces[i].getPackage().getName().length() + 1);
		}
		return str;
	}

	@Override
	public String[] getClasses(String str) throws IOException {
		ClassPath p = ClassPath.from(ClassLoader.getSystemClassLoader());
		ImmutableSet<ClassInfo> classes = p.getTopLevelClasses(str);

		int l = classes.size();
		String[] str1 = new String[l];
		for (int i = 0; i < l; i++) {
			str1[i] = str + ".";
		}
		int i = 0;
		for (ClassInfo classInfo : classes) {
			Class<?> clazz = classInfo.load();
			str1[i] = str1[i] + clazz.getSimpleName();
			i++;

		}
		return str1;
	}

	@Override
	public void write(String[] str) {
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

	}

}
