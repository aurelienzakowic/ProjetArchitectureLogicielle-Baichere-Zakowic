import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
	IOException {

		Scanner input = new Scanner(System.in);
		String str = "";
		System.out.print("------> Entrez le nom du package a etudier : ");
		str = input.nextLine();
		Methodes m = new Methodes();
		String[] classes = m.getClasses(str);
		int l = classes.length;

//		Package[] pa = Package.getPackages();
//
//		for (int i = 0; i < pa.length; i++) {
//			Package p = pa[i];
//			System.out.println("\"" + p.getName() + "\", ");
//		}

		for (int i = 0; i < l; i++) {
			Class<?> classe = Class.forName(classes[i]);
			String[] implement = m.getClassesImplementant(classe);
			String[] fields = m.getVariablesInstance(classe);
			String[] constructeurs = m.getConstructeurs(classe);
			String[] methodes = m.getMethods(classe);
			System.out.println(classe.getSimpleName());
			System.out.println(m.getNomPackage(classe));
			System.out.println();
			System.out.println("fields : ");
			m.write(fields);
			System.out.println();
			System.out.println("constructeurs : ");
			m.write(constructeurs);
			System.out.println("methodes : ");
			m.write(methodes);
			System.out.println();

		}

		// pour savoir si cest une interface, etc.
		// int modifiers = act.getModifiers();
		//
		// System.out.println(modifiers);
		//
		// switch (modifiers) {
		// case 1024:
		// System.out.println("abstract class");
		// break;
		//
		// case 1537:
		// System.out.println("interface");
		// break;
		//
		// default:
		// System.out.println("public class");
		// break;
		// }

	}

	

}
