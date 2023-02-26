package test;

import java.util.ArrayList; 
import java.util.Hashtable;

import halfPrioQueue.HalfPrioQueueByArr;
import halfPrioQueue.HalfPrioQueueByLinkedList;
import priorityQueue.PriorityQueueByArr;
import priorityQueue.PriorityQueueBySinglyLinkedList;

import priorityQueue.PriorityQueueByLinkedListOptim;
import priorityQueue.PriorityQueueByDoublyLinkedList;

import queue.Queue;
import standardQueue.StandardQueueByArr;
import standardQueue.StandardQueueByLinkedList;
import standardQueue.StandardQueueByLinkedListOptim;
import task.Task;

public class TestDrive {
	static public void main(String[] string) {
//		experimentOne();
		testPerformance();
	}
	
	static void experimentOne() {
		
		EfficiencyTest efficiencyTest = new EfficiencyTest();
		
		efficiencyTest.setQueue1(new StandardQueueByLinkedList());
		efficiencyTest.setQueue2(new HalfPrioQueueByLinkedList());
		final int S = 200;
		efficiencyTest.setDatasize(S*1000);
		efficiencyTest.setBatchSize(S*100);
		efficiencyTest.setDatasetProbability(100, 0.1);
		efficiencyTest.setDatasetProbability(1, 0.9);
		efficiencyTest.run();
	}
	
	static void testPerformance() {
		PerformanceTest performanceTest = new PerformanceTest();
		performanceTest.run();
	}
	
	static void experimentTwo_LinkedList(int batch_size, double rate) {
		EfficiencyTest efficiencyTest2 = new EfficiencyTest();
		
		efficiencyTest2.setQueue1(new HalfPrioQueueByLinkedList());
		efficiencyTest2.setQueue2(new PriorityQueueBySinglyLinkedList());
		efficiencyTest2.setDatasize(5000);
		efficiencyTest2.setBatchSize(batch_size);
		if(rate == 0.1) {
			efficiencyTest2.setDatasetProbability(100, rate);
			efficiencyTest2.setDatasetProbability(1, 1.0);
		}
		else if(rate==0.9){
			efficiencyTest2.setDatasetProbability(100, 1.0);
			efficiencyTest2.setDatasetProbability(1, 1-rate);
		}
		else {
			efficiencyTest2.setDatasetProbability(100, rate);
			efficiencyTest2.setDatasetProbability(1, 1-rate);
		}
		efficiencyTest2.run();
	}
	
	
	static void experimentTwo_Array(int batch_size, double rate) {
		EfficiencyTest efficiencyTest2 = new EfficiencyTest();
		
		efficiencyTest2.setQueue1(new HalfPrioQueueByArr(5000));
		efficiencyTest2.setQueue2(new PriorityQueueByArr(5000));
		efficiencyTest2.setDatasize(5000);
		efficiencyTest2.setBatchSize(batch_size);
		if(rate == 0.1) {
			efficiencyTest2.setDatasetProbability(100, rate);
			efficiencyTest2.setDatasetProbability(1, 1.0);
		}
		else if(rate==0.9){
			efficiencyTest2.setDatasetProbability(100, 1.0);
			efficiencyTest2.setDatasetProbability(1, 1-rate);
		}
		else {
			efficiencyTest2.setDatasetProbability(100, rate);
			efficiencyTest2.setDatasetProbability(1, 1-rate);
		}
		efficiencyTest2.run();
	}

	static void experimentTwo_OptimizedLinkedList(int batch_size, double rate) {
		EfficiencyTest efficiencyTest2 = new EfficiencyTest();
		
		efficiencyTest2.setQueue1(new HalfPrioQueueByLinkedList());
		efficiencyTest2.setQueue2(new PriorityQueueByLinkedListOptim());
		efficiencyTest2.setDatasize(5000);
		efficiencyTest2.setBatchSize(batch_size);
		if(rate == 0.1) {
			efficiencyTest2.setDatasetProbability(100, rate);
			efficiencyTest2.setDatasetProbability(1, 1.0);
		}
		else if(rate==0.9){
			efficiencyTest2.setDatasetProbability(100, 1.0);
			efficiencyTest2.setDatasetProbability(1, 1-rate);
		}
		else {
			efficiencyTest2.setDatasetProbability(100, rate);
			efficiencyTest2.setDatasetProbability(1, 1-rate);
		}
		efficiencyTest2.run();
	}
}
