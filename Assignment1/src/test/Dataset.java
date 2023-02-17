package test;

import java.util.Hashtable;
import java.util.Random;

import task.Task;

public class Dataset {

	// to save the distribution of data
	private Hashtable<Integer, Float> distribution;

	public void setDistribution(Hashtable<Integer, Float> distribution) {
		/*
		 * Set the distribution of the data, which is then generated, by setting
		 * probabilities to each possible digit.
		 */
		this.distribution = distribution;
	}

	public Task[] getData(int size) {
		/*
		 * Generate the testing data according to the distribution.
		 * 
		 * @size, how many tasks to generate
		 */

		Random rand = new Random();
		// Setting the upper bound to generate the
		// random numbers in specific range
		int upperbound = 100;
		// Generating random values from 0 - 99
		// using nextInt()
		int int_random = rand.nextInt(upperbound);
		Task[] tasks = new Task[size];
		for (int i = 0; i < tasks.length; ++i) {
			tasks[i] = new Task();
		}
		return null;
	}

}
