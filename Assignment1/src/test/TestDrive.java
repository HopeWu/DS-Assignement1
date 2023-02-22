package test;

import java.util.ArrayList;
import java.util.Hashtable;

import halfPrioQueue.HalfPrioQueueByArr;
import halfPrioQueue.HalfPrioQueueByLinkedList;
import priorityQueue.PriorityQueueBySinglyLinkedList;
import queue.Queue;
import standardQueue.StandardQueueByArr;
import standardQueue.StandardQueueByLinkedList;
import task.Task;

public class TestDrive {
	static public void main(String[] string) {

		stdVsPriEffLink();
	}

	/**
	 * StandardQueueByLinkedList vs PriorityQueueBySinglyLinedList, efficiency wise.
	 * Compare the average workload performed, given the same amount of time, given
	 * the same tasks already in the queue, importance considered.
	 * 
	 * @author haopengwu
	 */
	private static int[] stdVsPriEffLink() {
		/*
		 * construct the two cpus.
		 */

		// Create the two queues used in cpus first.
		Queue standardQueueByLinkedList = new StandardQueueByLinkedList();
		Queue priorityQueueBySinglyLinedList = new HalfPrioQueueByLinkedList();

		// Compose the queues with correspondent cpu
		Cpu stdCpu = new Cpu(standardQueueByLinkedList);
		Cpu priCpu = new Cpu(priorityQueueBySinglyLinedList);

		// Create test data
		Dataset dataset = new Dataset();

		// Configure the dataset with the same probabilities of importance-1 tasks and
		// importance-10 tasks
		dataset.setProbability(1, 0.1);
		dataset.setProbability(10, 0.9);

		// Generate the tasks
		final int DATASIZE = 10000;
		Task[] tasks = dataset.getData(DATASIZE);

		// Load the same work to both cpus
		stdCpu.assign(tasks);
		priCpu.assign(tasks);

		/*
		 * Take the first @TIMES tasks as samples to calculate the the average workload
		 * done within 1 millisecond
		 */
		long start = 0;
		long end = 0;
		// To save working time in milliseconds
		ArrayList<Long> elapsedTime = new ArrayList<Long>();

		// Sample size of tasks
		final int TIMES = 100;

		Task[] stdTasks, priTasks;
		int stdWork, priWork;

		// Let them run and save the elapsed time.
		start = System.currentTimeMillis();
		stdTasks = stdCpu.performTimesOf(TIMES);
		end = System.currentTimeMillis();
		stdWork = workloadOf(stdTasks);
		elapsedTime.add(end - start);

		start = System.currentTimeMillis();
		priTasks = priCpu.performTimesOf(TIMES);
		end = System.currentTimeMillis();
		priWork = workloadOf(priTasks);
		elapsedTime.add(end - start);

		// Calculate the efficiencies
		int efficiencyStd = (int) (stdWork / elapsedTime.get(0));
		int efficiencyPri = (int) (priWork / elapsedTime.get(1));

		System.out.printf("Efficiency for StandardQueueByLinkedList is: %d\n", efficiencyStd);
		System.out.printf("Efficiency for PriorityQueueBySinglyLinedList is: %d\n", efficiencyPri);

		return new int[] { efficiencyStd, efficiencyPri };
	}

	static int workloadOf(Task[] tasks) {
		int sum = 0;
		for (int i = 0; i < tasks.length; ++i) {
			sum += tasks[i].getImportance();
		}
		return sum;
	}

}
