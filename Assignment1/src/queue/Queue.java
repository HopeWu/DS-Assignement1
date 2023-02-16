package queue;
import task.Task;

public interface Queue {
	
	public void enqueue(Task task);
	public Task dequeue();
	public Task peek();
	// empty this queue
	public void empty();
	public boolean isEmpty();
	public int size();
} 
