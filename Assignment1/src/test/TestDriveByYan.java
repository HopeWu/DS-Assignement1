package test;

import java.util.ArrayList;
import java.util.Hashtable;

import halfPrioQueue.HalfPrioQueueByArr;
import queue.Queue;
import standardQueue.StandardQueueByArr;
import task.Task;

public class TestDriveByYan {
	static public void main(String[] string) {
		// for generating testing data
		Dataset dataset = new Dataset();
		
		// configure the distribution for the data
		dataset.setProbability(1, 0.1);
		dataset.setProbability(10, 0.7);
		dataset.setProbability(5, 0.2);
		
		// set the distribution of the data set
		
		Task[] tasks = dataset.getData(100000);
		
		/*
		 * Create queues for cpus to work on. Don't work on it directly.
		 */
		Queue queue1 = new StandardQueueByArr(tasks.length);
		Queue queue2 = new HalfPrioQueueByArr(tasks.length);
		
		/*
		 * Compose cpus with different queues
		 */
		Cpu cpu1 = new Cpu(queue1);
		Cpu cpu2 = new Cpu(queue2);
		
		/*
		 * Test the overall time, including the enqueues and the dequeues.
		 * Simplify the workload as the number of tasks, i.e. treat each task as equal importance.
		 */
		long start = 0;
		long end = 0;
		
		// Elapsed Time in milli-seconds
		ArrayList<Long> elapsedTime = new ArrayList<Long>();
		
		// empty the cpu before assign any tasks in it
		cpu1.emptyTasks();
		start = System.currentTimeMillis();
		cpu1.perform(tasks);
		end = System.currentTimeMillis();
		elapsedTime.add(end-start);
		System.out.println("Elapsed Time in milli seconds: "+ (end-start));
		
		// empty the cpu before assign any tasks in it
		cpu2.emptyTasks();
		start = System.currentTimeMillis();
		cpu2.perform(tasks);
		end = System.currentTimeMillis();
		elapsedTime.add(end-start);
		System.out.println("Elapsed Time in milli seconds: "+ (end-start));
		
		/* 
		 * Test enqueue time and dequeue time separately. 
		 * Equal importance.
		 */
		
		/*
		 * Enqueues
		 */
		// empty the cpu before assign any tasks in it
		cpu1.emptyTasks();
		start = System.currentTimeMillis();
		cpu1.assign(tasks);
		end = System.currentTimeMillis();
		elapsedTime.add(end-start);
		
		// empty the cpu before assign any tasks in it
		cpu2.emptyTasks();
		start = System.currentTimeMillis();
		cpu2.assign(tasks);
		end = System.currentTimeMillis();
		elapsedTime.add(end-start);
		
		/*
		 * Dequeues
		 */
		start = System.currentTimeMillis();
		cpu1.execute();
		end = System.currentTimeMillis();
		elapsedTime.add(end-start);
		
		start = System.currentTimeMillis();
		cpu2.execute();
		end = System.currentTimeMillis();
		elapsedTime.add(end-start);
	}
}
