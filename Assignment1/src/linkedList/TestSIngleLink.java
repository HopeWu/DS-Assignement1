package linkedList;

public class TestSIngleLink {
	public static void main(String[] args) {
        SingleLink<Integer> mySingleLinkedList = new SingleLink<Integer>();
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.getHead();
        mySingleLinkedList.getTail();
        System.out.println(mySingleLinkedList.getLength());
        
        mySingleLinkedList.insertFromTail(10);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.insertFromTail(99);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.insertFromTail(1);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.insertFromTail(2);
        mySingleLinkedList.insertFromTail(8);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.detailPrint();
        
        mySingleLinkedList.removeFromHead();
        mySingleLinkedList.removeFromTail();
        mySingleLinkedList.remove(2);
        System.out.println(mySingleLinkedList.getLength());
        mySingleLinkedList.detailPrint();
   
        System.out.println(mySingleLinkedList.getNode(1).getData());

	}
}
