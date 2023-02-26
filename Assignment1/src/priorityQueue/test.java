package priorityQueue;

import task.Task;

public class test {
	public static void main(String[] args) {
		PriorityQueueBySinglyLinkedList test = new PriorityQueueBySinglyLinkedList();
		test.enqueue(new Task(2));
		test.enqueue(new Task(10));
		test.enqueue(new Task(7));
		test.enqueue(new Task(8));
		
		System.out.println(test.isEmpty());
		
		System.out.println(test.size());

		System.out.println(test.dequeue().getImportance());
		
		System.out.println(test.size());
		
		System.out.println(test.peek().getImportance());
		
		test.empty();
		System.out.println(test.size());
	}
}
