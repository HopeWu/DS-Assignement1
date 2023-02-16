package linkedList;

public class TestSIngleLink {
	public static void main(String[] args) {
        SingleTaskNode head = new SingleTaskNode(12, null);
        SingleLink mySingleLinkedList = new SingleLink(head);
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
