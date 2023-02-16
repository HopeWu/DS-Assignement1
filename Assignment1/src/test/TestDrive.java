package test;

import java.util.Hashtable;

import halfPrioQueue.HalfPrioQueueByArr;
import queue.Queue;
import standardQueue.StandardQueueByArr;
import task.Task;

public class TestDrive {
	static public void main(String[] string) {
		// for generating testing data
		Dataset dataset = new Dataset();
		
		// configure the distribution for the data
		Hashtable<Integer, Float> distribution = new Hashtable();
		distribution.put(1, (float) 0.5);
		distribution.put(10, (float) 0.5);
		
		// set the distribution of the data set
		dataset.setDistribution(distribution);
		
		Task[] tasks = dataset.getData(10000);
		
		Queue queue1 = new StandardQueueByArr(tasks.length);
		Queue queue2 = new HalfPrioQueueByArr(tasks.length);
		
		
		Cpu cpu1 = new Cpu(queue1);
		Cpu cpu2 = new Cpu(queue2);
		
		long start = System.currentTimeMillis();
		cpu1.perform(tasks);
		long end = System.currentTimeMillis();
		System.out.println("Elapsed Time in milli seconds: "+ (end-start));
		
		start = System.currentTimeMillis();
		cpu2.perform(tasks);
		end = System.currentTimeMillis();
		System.out.println("Elapsed Time in milli seconds: "+ (end-start));
	}
}
