package priorityQueue;
import linkedList.SingleLink;
import linkedList.SingleTaskNode;
import queue.Queue;
import task.Task;

/**
 * This is an optimized version of priority queue implemented by singly linked list
 * @author Yan
 *
 */
public class PriorityQueueByLinkedListOptim extends Queue {
	private SingleLink<Task> queue = new SingleLink<Task>();
	
	/**
	 * Adds an element to the rear of the queue.
	 * @param task: the element that is to be added to the queue
	 */
	@Override
	public void enqueue(Task task) {
		queue.insertFromTail(task);
	}
	
	/**
	 * Removes the element with the highest priority.
	 */
	@Override
	public Task dequeue() {
		if (isEmpty()) {
            throw new RuntimeException("This queue is empty.");
        }
		SingleTaskNode<Task> head = queue.getHead();
		SingleTaskNode<Task> dummy = new SingleTaskNode<Task>(new Task(0), head);		
		SingleTaskNode<Task> prev = dummy;
		SingleTaskNode<Task> curr = null;
		SingleTaskNode<Task> maxNode = null;
		SingleTaskNode<Task> maxPrev = null;
		int maxValue = Integer.MIN_VALUE;
		while ((curr = prev.getNext()) != null) {
			if (curr.getData().getImportance() > maxValue) {
				maxValue = curr.getData().getImportance();
				maxNode = curr;
				maxPrev = prev;			
			}
			prev = curr;
		}
		maxPrev.setNext(maxNode.getNext());
		queue.setHead(dummy.getNext());
		queue.setLength(queue.getLength() - 1);
        return maxNode.getData();
	}
	
	/**
	 * Gets the element with the highest priority.
	 */
	@Override
	public Task peek() {
        if (isEmpty()) {
            throw new RuntimeException("This queue is empty");
        }
		SingleTaskNode<Task> head = queue.getHead();
		SingleTaskNode<Task> dummy = new SingleTaskNode<Task>(new Task(0), head);		
		SingleTaskNode<Task> prev = dummy;
		SingleTaskNode<Task> curr = null;
		SingleTaskNode<Task> maxNode = null;
		int maxValue = Integer.MIN_VALUE;
		while ((curr = prev.getNext()) != null) {
			if (curr.getData().getImportance() > maxValue) {
				maxValue = curr.getData().getImportance();
				maxNode = curr;		
			}
			prev = curr;
		}
		return maxNode.getData();
    }

	/**
	 * Checks whether the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return queue.getLength()==0;
	}

	/**
	 * Gets the number of the elements in the queue.
	 */
	@Override
	public int size() {
		return queue.getLength();
	}

	/**
	 * Clears the queue.
	 */
	@Override
	public void empty() {
        queue.clear();
	}

	/**
	 * Checks whether the queue is full.
	 */
	@Override
	public boolean isFull() {
		return queue.isFull();
	}
}
