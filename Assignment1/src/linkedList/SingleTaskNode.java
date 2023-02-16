package linkedList;

public class SingleTaskNode{

	private int importance;

	private SingleTaskNode next;

	// get the importance of this node
	public int getImportance() {
		return importance;
	}

	// set the importance of this node
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	// constructor
	public SingleTaskNode(int importance, SingleTaskNode next) {
	    this.setImportance(importance);
	    this.next = next;
	}

	// get the next node of this node
	public SingleTaskNode getNext() {
	    return next;
	}

	// set the next node of this node
	public void setNext(SingleTaskNode next) {
	    this.next = next;
	}

}
