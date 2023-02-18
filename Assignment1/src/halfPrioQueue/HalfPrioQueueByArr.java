package halfPrioQueue;

import queue.Queue;
import task.Task;

/**
 * This is a partial priority queue implemented by array.
 */
public class HalfPrioQueueByArr implements Queue{

    private Task[] queue;    
    private int size;
    private int N; // the number of elements to be sorted when dequeuing

	/**
	 * Constructs an empty array with the specified capacity which has to be set when initializing
	 * @param capacity
	 * @param N
	 */
    public HalfPrioQueueByArr(int capacity, int N) {
        this.queue = new Task[capacity];
        this.size = 0;
        this.N = N;
    }

	/**
	 * Adds an element to the rear of the queue.
	 * @param task The element that is to be added to the queue
	 */
    @Override
    public void enqueue(Task task) {
        if (isFull()) {
            throw new RuntimeException("This queue is full.");
        }
        queue[size] = task;
        size++;
    }

	/**
	 * Removes an element with the highest priority form the first N ones.
	 */
    @Override
    public Task dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("This queue is empty.");
        }
        // Find the index of the element with the highest priority.
        int index = 0;
        for (int i = 1; i < Math.min(size, N); i++) {
            if (queue[i].getImportance() > queue[index].getImportance()) {
                index = i;
            }
        }
        Task task = queue[index];
        // Move all the elements forward which follow the removed element.
        for (int i = index; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[size - 1] = null;
        size--;
        return task;
    }

	/**
	 * Gets the element with the highest priority.
	 */
    @Override
    public Task peek() {
        if (isEmpty()) {
            throw new RuntimeException("This queue is empty");
        }
        int index = 0;
        for (int i = 1; i < Math.min(size, N); i++) {
            if (queue[i].getImportance() > queue[index].getImportance()) {
                index = i;
            }
        }
        return queue[index];
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
        this.size = 0;
        this.queue = new Task[queue.length];
    }
    
	/**
	 * Checks whether the queue is full.
	 */
    @Override
    public boolean isFull() {
        return size == queue.length;
    }

}
