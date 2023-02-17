package test;

import queue.Queue;
import task.Task;

public class Cpu {
	private Queue queue;
	
	// Must specify a queue to create a cpu.
	Cpu(Queue queue){
		this.queue = queue;
	}
	
	public void assign(Task[] tasks) {
		/*
		 *  Assign a bunch of tasks for the cpu to do.
		 *  
		 *  @tasks, an array of tasks
		 */
		
		if (this.queue.isFull()) return;
		
		for( int i = 0; i < tasks.length; ++i) {
			this.queue.enqueue(tasks[i]);
		}
	}
	
	public void assign(Task task) {
		/*
		 * Assign a single task for the cpu to do.
		 * 
		 * @tasks, one task
		 */
		
	}
	
	public void perform() {
		/*
		 * Execute all the tasks in the queue.
		 */
		this.execute();
	}
	
	public void perform(Task[] tasks) {
		/*
		 * Assign a bunch of tasks and execute all the tasks in the queue.
		 * 
		 * @tasks, an array of tasks to be executed
		 *
		 */
		this.assign(tasks);
		this.execute();
	}
	
	public void perform(Task task) {
		/*
		 * Assign a single task and execute all the tasks in the queue.
		 * 
		 * @tasks, an array of tasks to be executed
		 *
		 */
		this.assign(task);
		this.execute();
	}

	public void execute() {
		/*
		 * Execute all the tasks inside the queue and this queue becomes empty.
		 */
		Task task;
		while(!queue.isEmpty()) {
			task = queue.dequeue();
			task.perform();
		}
	}

	public void emptyTasks() {
		/*
		 * Empty the queue
		 */
		this.queue.empty();
	}
	
	
}
