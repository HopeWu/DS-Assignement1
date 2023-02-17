package linkedList;

public class SingleTaskNode<T>{

	private T data;

	private SingleTaskNode<T> next;

	// get the importance of this node
	public T getData() {
		return data;
	}

	// set the importance of this node
	public void setData(T data) {
		this.data = data;
	}
	
	// constructor
	public SingleTaskNode(T data, SingleTaskNode<T> next) {
	    this.setData(data);
	    this.next = next;
	}

	// get the next node of this node
	public SingleTaskNode<T> getNext() {
	    return next;
	}

	// set the next node of this node
	public void setNext(SingleTaskNode<T> next) {
	    this.next = next;
	}

}
