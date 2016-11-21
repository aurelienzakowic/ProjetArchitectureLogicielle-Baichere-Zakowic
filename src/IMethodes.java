import java.io.IOException;

public interface IMethodes {

	/**
	 * Methode permettant de recuperer le nom des methodes, leurs arguments et
	 * le type de retour de la classe c stockees dans une liste de String
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des methodes et les
	 *         spécifications
	 */
	public String[] getMethods(Class<?> c);

	/**
	 * Methode permettant de recuperer le nom d'un package a partir d'une classe
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Un String du nom du package contenant la classe etudiee
	 */
	public String getNomPackage(Class<?> c);

	/**
	 * Methode permettant de recuperer le nom des constructeurs et leurs
	 * arguments de la classe c stockees dans une liste de String
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des constructeurs et les
	 *         specifications
	 */
	public String[] getConstructeurs(Class<?> c);

	/**
	 * Methode permettant de recuperer le nom des variables d'instance ainsi que
	 * leur type de la classe c stockees dans une liste de String
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des variables d'instance et
	 *         leur type
	 */
	public String[] getVariablesInstance(Class<?> c);

	/**
	 * Methode permettant d'obtenir le nom de la classe mère
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Un String contenant le nom de la classe mere
	 */
	public String getClasseMere(Class<?> c);

	/**
	 * Methode permettant de recuperer le nom des classes implementant une
	 * certaine interface
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des classes implementant la
	 *         classe étudiée
	 */
	public String[] getClassesImplementant(Class<?> c);

	/**
	 * Methode permettant de récuperer les noms des classes d'un package
	 * 
	 * @param str
	 *            nom du package
	 * @return Une liste De String contenant le nom des classes contenue dans un
	 *         package
	 * @throws IOException
	 *             lance une exception si le package n'éxiste pas
	 */
	public String[] getClasses(String str) throws IOException;

	/**
	 * Methode permettant de printer une liste de String
	 * 
	 * @param str
	 *            La liste de String à printer
	 */
	public void write(String[] str);

}
