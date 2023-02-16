package standardQueue;

import queue.Queue;
import task.Task;

public class StandardQueueByArr implements Queue {

	private int size;
	Task[] queue;
	
	StandardQueueByArr(){
		
	}
	
	StandardQueueByArr(int size){
		this.size = size;
	}
	
	@Override
	public void enqueue(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
