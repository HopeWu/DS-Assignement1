package test;

import queue.Queue;
import task.Task;

public class Cpu {
	private Queue queue;
	
	// Must specify a queue to create a cpu.
	Cpu(Queue queue){
		this.queue = queue;
	}
	
	/**
	 * Assign or load this cpu with a bunch of tasks.
	 * @tasks
	 */
	public void assign(Task[] tasks) {
		
		if (this.queue.isFull()) throw new RuntimeException("This cpu is already full.");
		
		for( int i = 0; i < tasks.length; ++i) {
			this.queue.enqueue(tasks[i]);
		}
	}
	
	/**
	 * Assign or load this cpu with one single task.
	 * @task
	 * @author haopengwu
	 */
	public void assign(Task task) {

		if (this.queue.isFull()) throw new RuntimeException("This cpu is already full.");
		
		this.queue.enqueue(task);
	}
	/**
	 * Execute all the tasks currently loaded with this cpu.
	 */
	public void perform() {

		this.execute();
	}
	/**
	 * Perform a bunch of tasks, before which clear the cpu.
	 * 
	 * @tasks, an array of tasks to be executed
	 *
	 */
	public void perform(Task[] tasks) {
		
		this.emptyTasks();
		this.assign(tasks);
		this.execute();
	}
	
	/**
	 * Assign a single task and execute all the tasks in the queue.
	 * 
	 * @task, an array of tasks to be executed
	 * @deprecated useless and confusing method, to be deleted
	 */
	private void perform(Task task) {
		
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
