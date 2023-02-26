package standardQueue;

import queue.Queue;
import task.Task;

/**
 * This is a FIFO (first in, first out) queue implemented by array.
 * @author Yan
 */
public class StandardQueueByArr implements Queue {

	private Task[] queue;
	private int front;  // index of the front of the queue
	private int rear;  // index of the rear of the queue
	
	/**
	 * Constructs an empty array with the specified capacity which has to be set when initializing
	 * @param capacity
	 */
	public StandardQueueByArr(int capacity){
		queue = new Task[capacity];
		front = -1;
		rear = -1;
	}
	
	/**
	 * Adds an element to the rear of the queue.
	 * @param task the element that is to be added to the queue
	 */
	@Override
	public void enqueue(Task task) {
		if (isFull()) {
			throw new RuntimeException("Cannot enqueue because the queue is full.");
		} else {
			if (front == -1) {
				// the queue is empty, set front to 0
				front = 0;
			}
			rear++;
			queue[rear] = task;
		}
	}

	/**
	 * Removes the element from the head of the queue.
	 */
	@Override
	public Task dequeue() {
		Task task;
		if (isEmpty()) {
			throw new RuntimeException("Cannot dequeue because the queue is empty.");
		} else {
			task = queue[front];
			if (front == rear) {
				// the last element in the queue
				front = -1;
				rear = -1;
			} else {
				front++;
			}
		}
		return task;
	}
	
	/**
	 * Gets the element at the head of the queue.
	 */
	@Override
	public Task peek() {
		if (isEmpty()) {
			throw new RuntimeException("This queue is empty.");
		} else {
			return queue[front];
		}
	}
	
	/**
	 * Checks whether the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return front == -1;
	}

	/**
	 * Gets the number of the elements in the queue.
	 */
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return rear - front + 1;
		}
	}

	/**
	 * Clears the queue.
	 */
	@Override
	public void empty() {
		front = -1;
		rear = -1;		
	}
	
	/**
	 * Checks whether the queue is full.
	 */
	@Override
	public boolean isFull() {
		return rear == queue.length - 1;
	}
}
