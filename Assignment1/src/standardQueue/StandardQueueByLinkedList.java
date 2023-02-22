package standardQueue;

import linkedList.SingleLink;
import queue.Queue;
import task.Task;

public class StandardQueueByLinkedList implements Queue {

	private SingleLink<Task> singleLink;
	
	public StandardQueueByLinkedList(){
		this.singleLink = new SingleLink<Task>();
	}
	
	@Override
	public void enqueue(Task task) {
		// TODO Auto-generated method stub
		singleLink.insertFromHead(task);
	}

	@Override
	public Task dequeue() {
		if (isEmpty()) {
            throw new RuntimeException("This queue is empty.");
        }
        
		return singleLink.removeFromTail();
	}

	@Override
	public Task peek() {
		// TODO Auto-generated method stub
		return singleLink.getTail().getData();
	}

	@Override
	public void empty() {
		// TODO Auto-generated method stub
		singleLink.clear();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return singleLink.getLength()==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return singleLink.getLength();
	}

}
