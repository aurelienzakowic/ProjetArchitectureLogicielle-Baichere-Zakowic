package graph;

public class BinaryTree {
	private int[] values;

	public BinaryTree(int nbNodes) {
		super();
		this.values = new int[nbNodes];
	}

	public int getValue(int index) {
		return this.values[index];
	}

	public void setValue(int index, int nodeValue) {
		this.values[index] = nodeValue;
	}
	
	public int getSize() {
		return this.values.length;
	}
	
	public int getLeftChild(int nodeIndex) {
		return (2*nodeIndex+1 < this.values.length ? this.values[2*nodeIndex+1] : -1);
	}
	
	public int getRighChild(int nodeIndex) {
		return (2*nodeIndex+2 < this.values.length ? this.values[2*nodeIndex+2] : -1);
	}
	
	public void setChildren(int nodeIndex, int leftChild, int rightChild) {
		if (2*nodeIndex+1 < this.values.length) {
			this.values[2*nodeIndex+1] = leftChild;
		}
		if (2*nodeIndex+2 < this.values.length) {
			this.values[2*nodeIndex+2] = rightChild;
		}
	}
	
	public void setLeftChild(int nodeIndex, int leftChild) {
		if (2*nodeIndex+1 < this.values.length) {
			this.values[2*nodeIndex+1] = leftChild;
		}
	}
	
	public void setRightChild(int nodeIndex, int rightChild) {
		if (2*nodeIndex+2 < this.values.length) {
			this.values[2*nodeIndex+2] = rightChild;
		}
	}
	
	public int getRoot() {
		return this.values[0];
	}
	
	public void setRoot(int root) {
		this.values[0] = root;
	}
	
	public int getRootOf(int nodeIndex) {
		return this.values[(int)((nodeIndex-1)/2)];
	}
	
	public void setRootOf(int nodeIndex, int root) {
		this.values[(int)((nodeIndex-1)/2)] = root;
	}
	
	public void swapNodes(int nodeIndex1, int nodeIndex2) {
		int memoryNode1 = this.getValue(nodeIndex1);
		this.setValue(nodeIndex1, this.getValue(nodeIndex2));
		this.setValue(nodeIndex2, memoryNode1);
	}
	
	public void printTree() {
		String test = "[ ";
		for (int i = 0; i < this.getSize(); i++) {
			test += this.getValue(i) + " ";
		}
		test += "]";
		System.out.println(test);
	}

}
