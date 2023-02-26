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
}
