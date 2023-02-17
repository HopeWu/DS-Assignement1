package linkedList;

public class SingleLink<T> {
	/**
	 * This is the structure of the doubly linked list
	 */
	private SingleTaskNode<T> head;
	private SingleTaskNode<T> tail;
	private int length;

	// this is the constructor
	public SingleLink() {
		this.head = null;
		this.tail = null;
		length=0;
	}
	
	// get the head of the linked list
	public SingleTaskNode<T> getHead() {
		if(head==null) {
			System.out.println("This linked list is null");
			System.out.println("");
			return null;
		}
		return head;
	}

	// get the tail of the linked list
	public SingleTaskNode<T> getTail() {
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
        SingleTaskNode<T> node = new SingleTaskNode<T>(data, head);
        if(length==0) {
        	head = node;
        	tail = node;
        }
        else {
        	node.setNext(head);;
            head=node;
        }
        length ++;
    }
    
 
    // insert node from tail
    public void insertFromTail(T data) {
    	if (head == null) {
    		insertFromHead(data);
        } else {
            SingleTaskNode<T> node = new SingleTaskNode<T>(data, null);
            tail.setNext(node);
            tail = node;
        }
    	length++;
    }
    

    // delete node from head
    public SingleTaskNode<T> removeFromHead() {
        if(length==0) {
        	System.out.println("This linked list is null");
        	return null;
        }
        
        SingleTaskNode<T> LastHead = head;
        SingleTaskNode<T> node = head.getNext();
        head = node;
        return LastHead;
    }

    // delete node from tail
    public SingleTaskNode<T> removeFromTail() {
    	if(head==null){
            System.out.println("This linked list is null");
            return null;
        }
    	SingleTaskNode<T> LastTail = tail;
    	SingleTaskNode<T> node =head;
    	int i =1;
    	while(i!=(length-1)) {
    		node=node.getNext();
        	i++;
        }
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
        
        SingleTaskNode<T> node = head;
        while (node != null) {
            System.out.print("current point：");
            System.out.printf("%-5s",node.getData() + "\t");
            System.out.print("next point：");
            System.out.printf("%-6s",node.getNext() == null ? "null\t" : node.getNext().getData()+"\t");
            System.out.println();
            node = node.getNext();
        }
        length --;
        System.out.println();
    }

	
}
