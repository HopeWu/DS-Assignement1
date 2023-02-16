package linkedList;

public class SingleLink {
	/**
	 * This is the structure of the doubly linked list
	 */
	private SingleTaskNode head;
	private SingleTaskNode tail;
	private int length;

	// this is the constructor
	public SingleLink(SingleTaskNode head) {
		this.head = head;
		this.tail = head;
		length=1;
	}
	
	// get the head of the linked list
	public SingleTaskNode getHead() {
		return head;
	}

	// get the tail of the linked list
	public SingleTaskNode getTail() {
		return tail;
	}
    
	// get the length of the linked list
    public int getLength() {
        return length;
    }
    

	
	// insert node from head
    public void insertFromHead(int importance) {
        SingleTaskNode node = new SingleTaskNode(importance, head);
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
    public void insertFromTail(int data) {
    	if (head == null) {
    		insertFromHead(data);
        } else {
            SingleTaskNode node = new SingleTaskNode(data, null);
            tail.setNext(node);
            tail = node;
        }
    	length++;
    }
    

    // delete node from head
    public SingleTaskNode deleteFromHead() {
        if(length==0) {
        	System.out.println("This linked list is null");
        	return null;
        }
        
        SingleTaskNode LastHead = head;
        SingleTaskNode node = head.getNext();
        head = node;
        return LastHead;
    }

    // delete node from tail
    public SingleTaskNode deleteFromTail() {
    	if(head==null){
            System.out.println("This linked list is null");
            return null;
        }
    	SingleTaskNode LastTail = tail;
    	SingleTaskNode node =head;
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
        
        SingleTaskNode node = head;
        while (node != null) {
            System.out.print("current point importance：");
            System.out.printf("%-5s",node.getImportance() + "\t");
            System.out.print("next point importance：：");
            System.out.printf("%-6s",node.getNext() == null ? "null\t" : node.getNext().getImportance()+"\t");
            System.out.println();
            node = node.getNext();
        }
        length --;
        System.out.println();
    }

	
}
