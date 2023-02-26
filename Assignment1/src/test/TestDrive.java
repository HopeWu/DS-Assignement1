package test;

import halfPrioQueue.HalfPrioQueueByArr;
import halfPrioQueue.HalfPrioQueueByLinkedList;
import priorityQueue.PriorityQueueByArr;
import priorityQueue.PriorityQueueBySinglyLinkedList;
import priorityQueue.PriorityQueueByLinkedListOptim;
import queue.Queue;
import standardQueue.StandardQueueByArr;
import standardQueue.StandardQueueByLinkedList;
import standardQueue.StandardQueueByLinkedListOptim;
import task.Task;

public class TestDrive {
	static public void main(String[] string) {
		testStd();
		testPrio();
//		testHalfPrio();
	}

	/**
	 * Test the performance of StandardQueueByArr vs StandardQueueByLinkedList.
	 * Run each experiment 5 times and work out an average time for each data size. 
	 */
	private static void testStd() {
		
		// Create test data
		Dataset dataset = new Dataset();

		// Create a data set with the same probabilities of tasks with importance ranging from 1 to 10		
		for (int i = 1; i <= 10; i++) {
			dataset.setProbability(i, 0.1);
		}
	
		final int ITERATIONS = 5;
		System.out.println("****************Standard Queue****************");
		System.out.println("Data Size,Array-Based,LinkedList-Based");
		for (int N = 100000; N <= 1000000; N += 100000) {
			
			// Create the two standard queues to be used in CPUs first.
			Queue standardQueueByArr = new StandardQueueByArr(N);
//			Queue standardQueueByLinkedList = new StandardQueueByLinkedList();
			Queue standardQueueByLinkedListOptim = new StandardQueueByLinkedListOptim();
			
			// Integrate the queues with correspondent CPUs
			Cpu stdArrCpu = new Cpu(standardQueueByArr);
//			Cpu stdLinkCpu = new Cpu(standardQueueByLinkedList);
			Cpu stdLinkCpu = new Cpu(standardQueueByLinkedListOptim);
			
			// Generate the tasks
			Task[] tasks = dataset.getData(N);
			
			long elapsedTimeSum1 = 0;
			for (int it = 0; it < ITERATIONS; it++) {
				long start = System.currentTimeMillis();
				stdArrCpu.perform(tasks);
				long end = System.currentTimeMillis();
				elapsedTimeSum1 += end - start;
			}		
			long elapsedTime1 = elapsedTimeSum1 / ITERATIONS;
			
			long elapsedTimeSum2 = 0;
			for (int it = 0; it < ITERATIONS; it++) {
				long start = System.currentTimeMillis();
				stdLinkCpu.perform(tasks);
				long end = System.currentTimeMillis();
				elapsedTimeSum2 += end - start;
			}		
			long elapsedTime2 = elapsedTimeSum2 / ITERATIONS;
			System.out.println(N + "," + elapsedTime1 + "," + elapsedTime2);
		}
	}
	
	/**
	 * Test the performance of PriorityQueueByArr vs PriorityQueueBySinglyLinkedList.
	 * Run each experiment 5 times and work out an average time for each data size. 
	 */
	private static void testPrio() {
		
		// Create test data
		Dataset dataset = new Dataset();

		// Create a data set with the same probabilities of tasks with importance ranging from 1 to 10		
		for (int i = 1; i <= 10; i++) {
			dataset.setProbability(i, 0.1);
		}
	
		final int ITERATIONS = 5;
		System.out.println("****************Priority Queue****************");
		System.out.println("Data Size,Array-Based,LinkedList-Based");
		for (int N = 5000; N <= 50000; N += 5000) {
			
			// Create the two standard queues to be used in CPUs first.
			Queue priorityQueueByArr = new PriorityQueueByArr(N);
//			Queue priorityQueueBySinglyLinkedList = new PriorityQueueBySinglyLinkedList();
			Queue priorityQueueByLinkedList = new PriorityQueueByLinkedListOptim();
			
			// Integrate the queues with correspondent CPUs
			Cpu prioArrCpu = new Cpu(priorityQueueByArr);
//			Cpu prioSinglyLinkCpu = new Cpu(priorityQueueBySinglyLinkedList);
			Cpu prioLinkCpu = new Cpu(priorityQueueByLinkedList);
			
			// Generate the tasks
			Task[] tasks = dataset.getData(N);
			
			long elapsedTimeSum1 = 0;
			for (int it = 0; it < ITERATIONS; it++) {
				long start = System.currentTimeMillis();
				prioArrCpu.perform(tasks);
				long end = System.currentTimeMillis();
				elapsedTimeSum1 += end - start;
			}		
			long elapsedTime1 = elapsedTimeSum1 / ITERATIONS;
			
			long elapsedTimeSum2 = 0;
			for (int it = 0; it < ITERATIONS; it++) {
				long start = System.currentTimeMillis();
				prioLinkCpu.perform(tasks);
				long end = System.currentTimeMillis();
				elapsedTimeSum2 += end - start;
			}		
			long elapsedTime2 = elapsedTimeSum2 / ITERATIONS;			
			System.out.println(N + "," + elapsedTime1 + "," + elapsedTime2);
		}
	}
	
	/**
	 * Test the performance of HalfPrioQueueByArr vs HalfPrioQueueByLinkedList.
	 * Run each experiment 5 times and work out an average time for each data size. 
	 */
	private static void testHalfPrio() {
		
		// Create test data
		Dataset dataset = new Dataset();

		// Create a data set with the same probabilities of tasks with importance ranging from 1 to 10		
		for (int i = 1; i <= 10; i++) {
			dataset.setProbability(i, 0.1);
		}
	
		final int ITERATIONS = 5;
		System.out.println("****************Half Priority Queue****************");
		System.out.println("Data Size,Array-Based,LinkedList-Based");
		for (int N = 5000; N <= 50000; N += 5000) {
			
			// Create the two standard queues to be used in CPUs first.
			Queue halfPrioQueueByArr = new HalfPrioQueueByArr(N);
			Queue halfPrioQueueByLinkedList = new HalfPrioQueueByLinkedList();
			
			// Integrate the queues with correspondent CPUs
			Cpu halfPrioArrCpu = new Cpu(halfPrioQueueByArr);
			Cpu halfPrioLinkCpu = new Cpu(halfPrioQueueByLinkedList);
			
			// Generate the tasks
			Task[] tasks = dataset.getData(N);
			
			long elapsedTimeSum1 = 0;
			for (int it = 0; it < ITERATIONS; it++) {
				long start = System.currentTimeMillis();
				halfPrioArrCpu.perform(tasks);
				long end = System.currentTimeMillis();
				elapsedTimeSum1 += end - start;
			}		
			long elapsedTime1 = elapsedTimeSum1 / ITERATIONS;
			
			long elapsedTimeSum2 = 0;
			for (int it = 0; it < ITERATIONS; it++) {
				long start = System.currentTimeMillis();
				halfPrioLinkCpu.perform(tasks);
				long end = System.currentTimeMillis();
				elapsedTimeSum2 += end - start;
			}		
			long elapsedTime2 = elapsedTimeSum2 / ITERATIONS;			
			System.out.println(N + "," + elapsedTime1 + "," + elapsedTime2);
		}
	}
}
