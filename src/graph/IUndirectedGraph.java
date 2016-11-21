package graph;

public interface IUndirectedGraph extends IGraph {

	/**
	 * @return the number of edges in the graph.
	 */
	public int getNbEdges();
	
	/**
	 * @param x
	 * @param y
	 * @return true if there is an edge between x and y ; false otherwise.
	 */
	public boolean isEdge(int x, int y);
	
	/**
	 * Remove edge between x and y if it exists.
	 * @param x
	 * @param y
	 */
	public void removeEdge(int x, int y);
	
	/**
	 * Add edge between x and y if not already present (require x different from y).
	 * @param x
	 * @param y
	 */
	public void addEdge(int x, int y);
	
	/**
	 * @param x
	 * @return a new array representing neighbors of node x.
	 */
	public int[] getNeighbors(int x);
	
}
