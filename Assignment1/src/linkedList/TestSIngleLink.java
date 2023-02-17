package linkedList;

public class TestSIngleLink {
	public static void main(String[] args) {
        SingleLink<Integer> mySingleLinkedList = new SingleLink<Integer>();
        mySingleLinkedList.getHead();
        mySingleLinkedList.getTail();
        
        mySingleLinkedList.getLength();
        mySingleLinkedList.insertFromHead(10);
        mySingleLinkedList.insertFromTail(99);
        mySingleLinkedList.insertFromTail(1);
        mySingleLinkedList.insertFromHead(2);
        mySingleLinkedList.insertFromHead(8);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.detailPrint();
        
        mySingleLinkedList.removeFromHead();
        mySingleLinkedList.removeFromTail();
        mySingleLinkedList.remove(2);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.detailPrint();
   

	}
}
