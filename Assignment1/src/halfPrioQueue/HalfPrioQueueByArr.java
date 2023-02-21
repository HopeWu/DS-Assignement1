package halfPrioQueue;

import queue.Queue;
import task.Task;

/**
 * Half Priority Queue is functionally similar to a Priority 
 * Queue, except that it dequeues and peeks the element with 
 * highest priority for the last 'n' elements of the queue, 
 * where n is "ideally" half the size of the queue. This 
 * implementation uses Arrays.
 * 
 * @author Prateek Dash
 *
 */
public class HalfPrioQueueByArr implements Queue {

	private Task[] queue;    
    private int size;
    private final int THRESHOLD = 5;
    
	public HalfPrioQueueByArr(int length) {
		queue = new Task[length];
		size = 0;
	}
	
	/**
	 * Adds an element to the rear of the queue.
	 * @param task: the element that is to be added to the queue
	 */
	@Override
	public void enqueue(Task task) {
		if(isFull()) throw new RuntimeException("This queue is full.");		
		queue[size++] = task;
	}

	/**
	 * Removes an element with the highest priority within the specified
	 * THRESHOLD value.
	 */
	@Override
	public Task dequeue() {
		if(isEmpty()) throw new RuntimeException("The queue is empty.");
		
		Task task = null;
		int index = getIndexOfMaxPriorityElement();	
		task = queue[index];
			
		for(int i = index; i < size - 1; i++) {
			queue[i] = queue[i + 1];				
		}
		
		queue[size - 1] = null;
		--size;
		return task;
	}

	/**
	 * Gets the element with the highest priority within the specified
	 * THRESHOLD value.
	 */
	@Override
	public Task peek() {
		if(isEmpty()) throw new RuntimeException("The queue is empty.");	
		return queue[getIndexOfMaxPriorityElement()];
	}

	/**
	 * Checks whether the queue is empty.
	 */
	@Override
	public boolean isEmpty() {		
		return size == 0;
	}

	/**
	 * Gets the number of the elements in the queue.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Clears the queue.
	 */
	@Override
	public void empty() {
		size = 0;
        queue = new Task[queue.length];
	}

	/**
	 * Checks whether the queue is full.
	 */
	@Override
	public boolean isFull() {
		return size == queue.length;
	}
	
	/**
	 * Retrieves the index of task with highest importance value within 
	 * the last 'n' elements. The 'n' value is set by THRESHOLD constant.
	 * E.g. If THRESHOLD value is 5 and the size of queue is 10, then  
	 * it would iterate through the elements 5 to 10 and returns the 
	 * index of task with max importance value.
	 */
	private int getIndexOfMaxPriorityElement() {		
		int index =  size - 1;
		int lastIndex = size < THRESHOLD ? 0 : size - THRESHOLD;
		
		  for(int i = index - 1; i >= lastIndex; i--) {
			  if(queue[index].getImportance() < queue[i].getImportance()) {
				index = i;
			  }	
		  }
				
		return index;
	}
}