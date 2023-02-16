package linkedList;

public class DoubleLink {
	/**
	 * This is the structure of the doubly linked list
	 */
	private DoubleTaskNode head;
	private DoubleTaskNode tail;
	private int length;

	// this is the constructor
	public DoubleLink(DoubleTaskNode head) {
		this.head = head;
		this.tail = head;
		length=1;
	}
	
	// get the head of the linked list
	public DoubleTaskNode getHead() {
		return head;
	}

	// get the tail of the linked list
	public DoubleTaskNode getTail() {
		return tail;
	}
    
	// get the length of the linked list
    public int getLength() {
        return length;
    }
    

	
	// insert node from head
    public void insertFromHead(int importance) {
    	DoubleTaskNode node = new DoubleTaskNode(importance, head, null);
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
    public void insertFromTail(int data) {
    	if (head == null) {
    		insertFromHead(data);
        } else {
        	DoubleTaskNode node = new DoubleTaskNode(data, null, tail.getBefore());
            tail.setNext(node);
            node.setBefore(tail);
            tail = node;
        }
    	length++;
    }
    

    // delete node from head
    public DoubleTaskNode deleteFromHead() {
        if(length==0) {
        	System.out.println("This linked list is null");
        	return null;
        }
        DoubleTaskNode LastHead = head;
        DoubleTaskNode node = head.getNext();
        node.setBefore(null);
        head = node;
        length --;
        return LastHead;
    }

    // delete node from tail
    public DoubleTaskNode deleteFromTail() {
    	if(length==0){
    		System.out.println("This linked list is null");
        	return null;
        }
    	DoubleTaskNode LastTail = tail;
        DoubleTaskNode node = tail.getBefore();
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
        
        DoubleTaskNode node = head;
        while (node != null) {
            System.out.print("former point importance：");
            System.out.printf("%-5s",node.getBefore() == null ? "null\t" : node.getBefore().getImportance()+"\t");
            System.out.print("current point importance：");
            System.out.printf("%-6s",node.getImportance() + "\t");
            System.out.print("next point importance：");
            System.out.printf("%-5s",node.getNext() == null ? "null\t" : node.getNext().getImportance()+"\t");
            System.out.println();
            node = node.getNext();
        }
        System.out.println();
    }


}
