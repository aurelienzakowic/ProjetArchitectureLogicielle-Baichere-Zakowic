package graph;

public interface IDirectedGraph extends IGraph {
	
	/**
	 * @return the number of arcs in the graph.
	 */
	public int getNbArcs();
	
	/**
	 * @param from
	 * @param to
	 * @return true if arc between from and to figures in the graph ; false otherwise.
	 */
	public boolean isArc(int from, int to);
	
	/**
	 * Remove the arc between from and to if it exists.
	 * @param from
	 * @param to
	 */
	public void removeArc(int from, int to);
	
	/**
	 * Add the arc between from and to if not already present (require from different from to).
	 * @param from
	 * @param to
	 */
	public void addArc(int from, int to);
	
	/**
	 * @param x
	 * @return a new array representing successors of node x.
	 */
	public int[] getSuccessors(int x);
	
	/**
	 * @param x
	 * @return a new array representing predecessors of node x.
	 */
	public int[] getPredecessors(int x);
	
	/**
	 * @return the inverse graph.
	 */
	public IDirectedGraph computeInverse();

}
