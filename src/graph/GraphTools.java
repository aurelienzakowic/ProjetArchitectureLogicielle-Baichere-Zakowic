package graph;
import java.util.ArrayList;

import java.util.Vector;


public class GraphTools {
	public static int STEP;
	
	static class Pair {
		private int x;
		private int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
						
	}
	
	/**
	 * @param n order of the graph.
	 * @param s true if undirected graph ; false otherwise. 
	 * @return
	 */
	public static ArrayList<Pair> generatePairsArray(int n, boolean s) {
		ArrayList<Pair> array = new ArrayList<Pair>();
		if (s) {
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					if (i != j) {
						array.add(new Pair(i, j));
					}
				}
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						array.add(new Pair(i, j));
					}
				}
			}
		}
		return array;
	}
	
	/**
	 * @param n order of the graph.
	 * @param m number of arcs or edges.
	 * @param s true if undirected graph ; false otherwise.
	 * @return the adjacency matrix representation of the random graph computed.
	 */
	public static int[][] generateGraphData(int n, int m, boolean s) {
		int[][] matrix = new int[n][n];
		ArrayList<Pair> array = GraphTools.generatePairsArray(n, s);
		for (int i = 0; i < m; i++) {
			int random = (int)(Math.random()*array.size());
			if (s) {
				matrix[array.get(random).getX()][array.get(random).getY()] = 1;
				// G�n�ration d'une matrice de co�t de poids maximal 44 :
				// matrix[array.get(random).getX()][array.get(random).getY()] = (int)(Math.random()*45);
				matrix[array.get(random).getY()][array.get(random).getX()] = matrix[array.get(random).getX()][array.get(random).getY()];
			}
			else {
				matrix[array.get(random).getX()][array.get(random).getY()] = 1;
				// G�n�ration d'une matrice de co�t de poids maximal 44 :
				// matrix[array.get(random).getX()][array.get(random).getY()] = (int)(Math.random()*45);
			}
			array.remove(random);
		}
		return matrix;
	}
	
	/**
	 * @param graphData an adjacency matrix.
	 * @return the symmetric adjacency matrix representation of the random graph computed from graphData.
	 */
	public static int[][] generateUndirectedGraphData(int[][] graphData) {
		int[][] matrix = graphData;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0) {
					matrix [j][i] = matrix[i][j];
				}
			}
		}
		return matrix;
	}
	
	public static String returnMatrix(int[][] matrix) {
		String print = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				print+=matrix[i][j]+" ";

			}
			print+="\n";
		}
		return print;
	}
	
	public static String returnMatrixFromVector(Vector<int[]> matrix) {
		String print = "";
		for (int i = 0; i < matrix.get(0).length; i++) {
			for (int j = 1; j < matrix.size(); j++) {
				print+=matrix.get(j)[i]+" ";

			}
			print+="\n";
		}
		return print;
	}
	
	public static void main(String[] args) {
		System.out.println("- Test de la classe GRAPHTOOLS - \n");
		int[][] undirectedGraph = GraphTools.generateGraphData(15, 20, true);
		System.out.println("Cr�ation d'un graphe non orient� de 15 sommets et 20 ar�tes :");
		System.out.println(GraphTools.returnMatrix(undirectedGraph));		
		int[][] directedGraph = GraphTools.generateGraphData(15, 20, false);
		System.out.println("Cr�ation d'un graphe orient� de 15 sommets et 20 arcs :");
		System.out.println(GraphTools.returnMatrix(directedGraph));
		System.out.println("Transformation d'un graphe orient� de 15 sommets et 20 arcs en graphe non orient� :");
		System.out.println(GraphTools.returnMatrix(GraphTools.generateUndirectedGraphData(directedGraph)));
	}

}
