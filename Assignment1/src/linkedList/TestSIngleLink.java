package linkedList;

public class TestSIngleLink {
	public static void main(String[] args) {
        SingleLink<Integer> mySingleLinkedList = new SingleLink<Integer>(12);
        mySingleLinkedList.insertFromHead(10);
        mySingleLinkedList.insertFromTail(99);
        mySingleLinkedList.insertFromTail(1);
        mySingleLinkedList.insertFromHead(2);
        mySingleLinkedList.detailPrint();
        mySingleLinkedList.deleteFromHead();
        mySingleLinkedList.deleteFromTail();
        mySingleLinkedList.detailPrint();

	}
}
