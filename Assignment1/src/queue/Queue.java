package queue;
import task.Task;

public abstract class Queue {
	
	public abstract void  enqueue(Task task);
	public abstract Task dequeue();
	public abstract Task peek();
	// empty this queue
	public abstract void empty();
	public abstract boolean isEmpty();
	public abstract boolean isFull();
	public abstract int size();
	
	public String toString() {
        return getClass().getName();
    }
} 
