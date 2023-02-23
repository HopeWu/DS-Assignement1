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
	
	
	// get the node with the specific node
	public SingleTaskNode<T> getNode(int index){
	    if(index>this.getLength()|| index<1) {
	        System.out.println("This index is out of range");
	        return null;
	    }
	    else if(index==1) {
	        return head;
	    }
	    else{
	        SingleTaskNode<T> node = head;
	        for(int i=1; i<index; i++) {
	        	node = node.getNext();
	        }
	        return node;
	    }
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
        if(data == null) {
        	System.out.println("The insert task is null");
        	length --;
        }
        else if(length==0) {
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
    	if(data == null) {
        	System.out.println("The insert task is null");
        }
    	else if (head == null) {
    		insertFromHead(data);
        } else {
            SingleTaskNode<T> node = new SingleTaskNode<T>(data, null);
            tail.setNext(node);
            tail = node;
            length++;
        }
    	
    }
    
	// delete the node with the specific index
    public T remove(int index){
    	 if (getLength() == 0){
    		System.out.println("This linked list is null");
         	return null;
         }
    	if(index>this.getLength()|| index<1) {
        	System.out.println("This index is out of range");
        	return null;
        }
        else if(index==1) {
        	return removeFromHead();
        }
        else{
        	SingleTaskNode<T> node = head;
        	for(int i=1; i<index-1; i++) {
        		node = node.getNext();
        	}
        	SingleTaskNode<T> removedNode = node.getNext();
        	SingleTaskNode<T> temp = node.getNext();
        	temp = node.getNext();
        	if(temp != tail) {
        		node.setNext(temp.getNext());
        		temp.setNext(null);
        		length--;
        		return removedNode.getData();
        	}
        	else {
        		return removeFromTail();
        	}
        }
    }

    
    // delete node from head
    public T removeFromHead() {
        if(length==0) {
        	System.out.println("This linked list is null");
        	return null;
        }
        
        SingleTaskNode<T> LastHead = head;
        SingleTaskNode<T> node = head.getNext();
        head = node;
        length --;
        return LastHead.getData();
    }

    // delete node from tail
    public T removeFromTail() {
    	if(head==null){
            System.out.println("This linked list is null");
            return null;
        }
    	SingleTaskNode<T> LastTail = tail;
    	SingleTaskNode<T> node =head;
    	int i =1;
    	
    	if(head!=tail) {
    		while(i!=(length-1)) {
        		node=node.getNext();
            	i++;
            }
    		node.setNext(null);
            tail = node;
    	}
    	else {
    		tail = node;
    		head = node;
    	}
        length --;
		return LastTail.getData();
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
        System.out.println();
    }

    public boolean isFull() {
    	return false;
    }
    
    // Clear the linked list
    public void clear(){
    	this.head = null;
		this.tail = null;
		length=0;
    }

}
