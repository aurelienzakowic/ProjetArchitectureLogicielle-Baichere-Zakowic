package graph;

public interface IGraph {
	
	/**
	 * @return the number of nodes in the graph (referred to as the order of the graph).
	 */
	public int getNbNodes();
	
	/**
	 * @return the adjacency matrix representation of the graph.
	 */
	public int[][] toAdjacencyMatrix();
	
}
