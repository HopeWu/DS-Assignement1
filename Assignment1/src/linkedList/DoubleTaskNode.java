package linkedList;

public class DoubleTaskNode {
	private int importance;

	private DoubleTaskNode next;
	private DoubleTaskNode before;

	// get the importance of this node
	public int getImportance() {
		return importance;
	}

	// set the importance of this node
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	// constructor
	public DoubleTaskNode(int importance, DoubleTaskNode next,DoubleTaskNode before) {
	    this.setImportance(importance);
	    this.next = next;
	    this.before = before;
	}

	// get the next node of this node
	public DoubleTaskNode getNext() {
	    return next;
	}
	
	// set the next node of this node
	public void setNext(DoubleTaskNode next) {
	    this.next = next;
	}
	
	// get the former node of this node
	public DoubleTaskNode getBefore() {
	    return before;
	}

	// set the former node of this node
	public void setBefore(DoubleTaskNode before) {
	    this.before = before;
	}
}
