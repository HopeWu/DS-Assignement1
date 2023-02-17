package linkedList;

public class TestDoubleLink {
	public static void main(String[] args) {
		DoubleLink<Integer> myDoubleList = new DoubleLink<Integer>(5);
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
