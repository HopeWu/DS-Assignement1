package test;

import java.util.ArrayList;

import queue.Queue;
import task.Task;


/**
 * Compare two queues, efficiency wise.
 * Compare the average workload performed, given the same amount of time, given
 * the same tasks already in the queue, importance considered.
 * 
 * @author haopengwu
 */
public class EfficiencyTest {

	private Queue queue1;
	private Queue queue2;
	// Create test data
	private Dataset dataset;
	private int datasize;
	private int batchSize;

	EfficiencyTest() {
		this.dataset = new Dataset();
	}

	public void setQueue1(Queue queue1) {
		this.queue1 = queue1;
	}

	public void setQueue2(Queue queue2) {
		this.queue2 = queue2;
	}

	public void setDatasize(int datasize) {
		this.datasize = datasize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	// Configure the dataset with the same probabilities of importance-1 tasks and
	// importance-10 tasks
	public void setDatasetProbability(int digit, double probability) {
		this.dataset.setProbability(digit, probability);
	}

	public void run() {
		_run();
	}

	private int[] _run() {
		/*
		 * construct the two cpus.
		 */

		// Compose the queues with correspondent cpu
		Cpu stdCpu = new Cpu(this.queue1);
		Cpu priCpu = new Cpu(this.queue2);

		// Generate the tasks to assgin to both cpus
		Task[] tasks = dataset.getData(datasize);

		// Load the same work to both cpus
		stdCpu.assign(tasks);
		priCpu.assign(tasks);

		/**
		 * Take the first @TIMES tasks as samples to calculate the the average workload
		 * done within 1 millisecond
		 */
		long start = 0;
		long end = 0;
		// To save working time in milliseconds
		ArrayList<Long> elapsedTime = new ArrayList<Long>();

		Task[] stdTasks, priTasks;
		int stdWork, priWork;

		// Let them run and save the elapsed time.
		start = System.currentTimeMillis();
		stdTasks = stdCpu.performTimesOf(batchSize);
		end = System.currentTimeMillis();
		stdWork = workloadOf(stdTasks);
		elapsedTime.add(end - start);
		System.out.printf("workload of %s Cpu: %d\n", queue1, stdWork);
		System.out.printf("time for %s: %d\n", queue1, elapsedTime.get(0));

		start = System.currentTimeMillis();
		priTasks = priCpu.performTimesOf(batchSize);
		end = System.currentTimeMillis();
		priWork = workloadOf(priTasks);
		elapsedTime.add(end - start);
		System.out.printf("workload of %s Cpu: %d\n", queue2, priWork);
		System.out.printf("time for %s: %d\n", queue2, elapsedTime.get(1));

		// Calculate the efficiencies
		int efficiency1 = (int) (stdWork / elapsedTime.get(0));
		int efficiency2 = (int) (priWork / elapsedTime.get(1));
		
		System.out.println();

		System.out.println("All tasks:");
		System.out.println(Dataset.checkDistruibutionOf(tasks));
		System.out.printf("%s tasks's distribution: ", queue1);
		System.out.println(Dataset.checkDistruibutionOf(stdTasks));
		System.out.printf("%s tasks's distribution: ", queue2);
		System.out.println(Dataset.checkDistruibutionOf(priTasks));

		System.out.println();
		System.out.printf("Efficiency for %s is: %d\n", queue1, efficiency1);
		System.out.printf("Efficiency for %s is: %d\n", queue2, efficiency2);

		return new int[] { efficiency1, efficiency2 };
	}

	int workloadOf(Task[] tasks) {
		int sum = 0;
		for (int i = 0; i < tasks.length; ++i) {
			sum += tasks[i].getImportance();
		}
		return sum;
	}

}
