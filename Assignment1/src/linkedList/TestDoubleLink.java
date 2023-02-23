package linkedList;

public class TestDoubleLink {
	public static void main(String[] args) {
		DoubleLink<Integer> myDoubleList = new DoubleLink<Integer>();
		
		myDoubleList.getHead();
	        
		myDoubleList.getTail();
	        
		myDoubleList.insertFromHead(null);
		myDoubleList.insertFromTail(null);
		myDoubleList.insertFromTail(1);
		myDoubleList.insertFromHead(2);
		System.out.println(myDoubleList.getLength());
        myDoubleList.detailPrint();
        
        myDoubleList.removeFromHead();
        myDoubleList.detailPrint();
        myDoubleList.removeFromTail();
        myDoubleList.remove(1);
        System.out.println(myDoubleList.getLength());
        myDoubleList.detailPrint();
        

	}
}
