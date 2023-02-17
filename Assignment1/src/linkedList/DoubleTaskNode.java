package linkedList;

public class DoubleTaskNode<T> {
	private T data;

	private DoubleTaskNode<T> next;
	private DoubleTaskNode<T> before;

	// get the importance of this node
	public T getData() {
		return data;
	}

	// set the importance of this node
	public void setData(T data) {
		this.data = data;
	}
	
	// constructor
	public DoubleTaskNode(T data, DoubleTaskNode<T> next,DoubleTaskNode<T> before) {
	    this.setData(data);
	    this.next = next;
	    this.before = before;
	}

	// get the next node of this node
	public DoubleTaskNode<T> getNext() {
	    return next;
	}
	
	// set the next node of this node
	public void setNext(DoubleTaskNode<T> next) {
	    this.next = next;
	}
	
	// get the former node of this node
	public DoubleTaskNode<T> getBefore() {
	    return before;
	}

	// set the former node of this node
	public void setBefore(DoubleTaskNode<T> before) {
	    this.before = before;
	}
}
