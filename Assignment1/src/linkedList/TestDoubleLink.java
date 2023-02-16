package linkedList;

public class TestDoubleLink {
	public static void main(String[] args) {
		DoubleTaskNode head = new DoubleTaskNode(12, null, null);
		DoubleLink myDoubleList = new DoubleLink(head);
		myDoubleList.insertFromHead(10);
		myDoubleList.insertFromTail(99);
		myDoubleList.insertFromTail(1);
		myDoubleList.insertFromHead(2);
		System.out.println(myDoubleList.getLength());
        myDoubleList.detailPrint();
        
        myDoubleList.deleteFromHead();
        myDoubleList.deleteFromTail();
        System.out.println(myDoubleList.getLength());
        myDoubleList.detailPrint();
        

	}
}
