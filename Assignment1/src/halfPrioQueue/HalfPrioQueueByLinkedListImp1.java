package halfPrioQueue;

import java.util.Random;

import linkedList.SingleLink;
import queue.Queue;
import task.Task;

/**
 * 
 * Only change getIndexOfMaxPriorityElement. Make it look from the beginning instead of the rear.
 * 
 * Half Priority Queue is functionally similar to a Priority 
 * Queue, except that it dequeues and peeks the element with 
 * highest priority for the last 'n' elements of the queue, 
 * where n is "ideally" half the size of the queue. This 
 * implementation uses Linked List.
 * 
 * @author Haopeng Wu, Prateek Dash
 *
 */

public class HalfPrioQueueByLinkedListImp1 extends Queue {

	private SingleLink<Task> queue = new SingleLink<>();

    private int threshold = 5;
    private boolean randomSamplingFlag = false;

    public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	
	public void setRandomSamplingFlag(boolean randomSamplingFlag) {
		this.randomSamplingFlag = randomSamplingFlag;
	}
    
    /**
	 * Adds an element to the rear of the queue.
	 * @param task: the element that is to be added to the queue
	 */
	@Override
	public void enqueue(Task task) {
		queue.insertFromTail(task);
	}
	
	/**
	 * Removes an element with the highest priority within the specified
	 * threshold value.
	 */
	@Override
	public Task dequeue() {
		if(isEmpty()) throw new RuntimeException("The queue is empty.");
		
		int index = randomSamplingFlag ? getIndexFromRandomSample() : getIndexOfMaxPriorityElement();
		Task task = queue.getNode(index).getData();
		queue.remove(index);
		return task;
	}

	/**
	 * Gets the element with the highest priority within the specified
	 * threshold value.
	 */
	@Override
	public Task peek() {
		if(isEmpty()) throw new RuntimeException("The queue is empty.");
		return queue.getNode(getIndexOfMaxPriorityElement()).getData();
	}

	/**
	 * Checks whether the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
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
		return false;
	}
	
	/**
	 * Retrieves the index of task with highest importance value within 
	 * the first 'n' elements. The 'n' value is set by threshold variable.
	 * E.g. If threshold value is 5 and the size of queue is 10, then  
	 * it would iterate through the elements 5 to 10 and returns the 
	 * index of task with max importance value.
	 */
	private int getIndexOfMaxPriorityElement() {
		int index = 1;
		int i;
		// if threshold is larger than size, then set it to size.
		threshold = this.size() > this.threshold ? this.threshold : this.size();
		for(i = 1; i < threshold + 1; ++i) {
			if(queue.getNode(i).getData().getImportance() > queue.getNode(index).getData().getImportance())
				index = i;
		}
		
		return index;
	}
	
	private int getIndexFromRandomSample() {		
		return new Random().nextInt();
	}
}
