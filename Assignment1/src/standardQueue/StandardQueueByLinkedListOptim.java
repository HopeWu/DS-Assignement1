package standardQueue;

import linkedList.SingleLink;
import queue.Queue;
import task.Task;

/**
 * This is an optimized version of standard queue implemented by singly linked list
 * @author Yan
 *
 */
public class StandardQueueByLinkedListOptim extends Queue {
	private SingleLink<Task> singleLink;
	
	public StandardQueueByLinkedListOptim(){
		this.singleLink = new SingleLink<Task>();
	}
	
	/**
	 * Adds an element to the rear of the queue.
	 * @param task: the element that is to be added to the queue
	 */
	@Override
	public void enqueue(Task task) {
		singleLink.insertFromTail(task);
	}

	/**
	 * Removes the element from the head of the queue.
	 */
	@Override
	public Task dequeue() {
		if (isEmpty()) {
            throw new RuntimeException("This queue is empty.");
        }
		return singleLink.removeFromHead();
	}
	
	/**
	 * Gets the element at the head of the queue.
	 */
	@Override
	public Task peek() {
		return singleLink.getHead().getData();
	}
	
	/**
	 * Clears the queue.
	 */
	@Override
	public void empty() {
		singleLink.clear();
	}

	/**
	 * Checks whether the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return singleLink.getLength()==0;
	}

	/**
	 * Checks whether the queue is full.
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	/**
	 * Gets the number of the elements in the queue.
	 */
	@Override
	public int size() {
		return singleLink.getLength();
	}
}
