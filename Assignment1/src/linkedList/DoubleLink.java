package linkedList;

public class DoubleLink<T> {
	/**
	 * This is the structure of the doubly linked list
	 */
	private DoubleTaskNode<T> head;
	private DoubleTaskNode<T> tail;
	private int length;

	// this is the constructor
	public DoubleLink() {
		this.head = null;
		this.tail = null;
		length=0;
	}
	
	// get the head of the linked list
	public DoubleTaskNode<T> getHead() {
		if(tail==null) {
			System.out.println("This linked list is null");
			System.out.println("");
			return null;
		}
		return head;
	}

	// get the tail of the linked list
	public DoubleTaskNode<T> getTail() {
		if(tail==null) {
			System.out.println("This linked list is null");
			System.out.println("");
			return null;
		}
		return tail;
	}
    
	// get the length of the linked list
    public int getLength() {
        return length;
    }
    

	
	// insert node from head
    public void insertFromHead(T data) {
    	DoubleTaskNode<T> node = new DoubleTaskNode<T>(data, head, null);
    	if(length==0) {
        	head = node;
        	tail = node;
        }
        else {
        	node.setNext(head);
            head = node;
            head.getNext().setBefore(node);
        }
        length ++;
    }
    
 
    // insert node from tail
    public void insertFromTail(T data) {
    	if (head == null) {
    		insertFromHead(data);
        } else {
        	DoubleTaskNode<T> node = new DoubleTaskNode<T>(data, null, tail.getBefore());
            tail.setNext(node);
            node.setBefore(tail);
            tail = node;
        }
    	length++;
    }
    

    // delete node from head
    public DoubleTaskNode<T> removeFromHead() {
        if(length==0) {
        	System.out.println("This linked list is null");
        	return null;
        }
        DoubleTaskNode<T> LastHead = head;
        DoubleTaskNode<T> node = head.getNext();
        node.setBefore(null);
        head = node;
        length --;
        return LastHead;
    }

    // delete node from tail
    public DoubleTaskNode<T> removeFromTail() {
    	if(length==0){
    		System.out.println("This linked list is null");
        	return null;
        }
    	DoubleTaskNode<T> LastTail = tail;
        DoubleTaskNode<T> node = tail.getBefore();
        node.setNext(null);
        tail = node;
        length --;
		return LastTail;
    }

 // print the details of each node in the linked list
    public void detailPrint(){
        if (length == 0) {
        	System.out.println("This linked list is null");
        }
        
        DoubleTaskNode<T> node = head;
        while (node != null) {
            System.out.print("former point：");
            System.out.printf("%-5s",node.getBefore() == null ? "null\t" : node.getBefore().getData()+"   \t");
            System.out.print("current point：");
            System.out.printf("%-6s",node.getData() + "\t");
            System.out.print("next point：");
            System.out.printf("%-5s",node.getNext() == null ? "null \t" : node.getNext().getData()+"\t");
            System.out.println();
            node = node.getNext();
        }
        System.out.println();
    }


}
