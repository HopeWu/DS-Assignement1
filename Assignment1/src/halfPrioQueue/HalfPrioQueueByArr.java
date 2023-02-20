package halfPrioQueue;

import queue.Queue;
import task.Task;

public class HalfPrioQueueByArr implements Queue {

	private Task[] queue;    
    private int size;
    private final int THRESHOLD = 5;
    
	public HalfPrioQueueByArr(int length) {
		queue = new Task[length];
		size = 0;
	}

	@Override
	public void enqueue(Task task) {
		if(isFull()) throw new RuntimeException("This queue is full.");		
		queue[size++] = task;
	}

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

	@Override
	public Task peek() {
		if(isEmpty()) throw new RuntimeException("The queue is empty.");	
		return queue[getIndexOfMaxPriorityElement()];
	}

	@Override
	public boolean isEmpty() {		
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void empty() {
		size = 0;
        queue = new Task[queue.length];
	}

	@Override
	public boolean isFull() {
		return size == queue.length;
	}
	
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