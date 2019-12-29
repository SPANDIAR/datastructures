package io.spandiar.linkedlist.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.spandiar.linkedlist.MyLinkedList;

class MyLinkedListTest {
	
	MyLinkedList route;
	
	@BeforeEach
	void initialize() {
		route = new MyLinkedList();
	}

	@Test
	void testAddToFront() {
		route.addToFront("Arques 6");
		route.addToFront("Right in Arques Ave");
		route.addToFront("Left in Lawrence Expressway");
		Assertions.assertEquals("Left in Lawrence Expressway", route.getFirst());
		Assertions.assertEquals(3,  route.size());
	}
	
	@Test
	void testAddToEnd() {
		Assertions.assertEquals(0,  route.size());
		route.addToFront("Arques 6");
		route.addToFront("Right in Arques Ave");
		route.addToFront("Left in Lawrence Expressway");
		route.addToTail("Park the car");
		Assertions.assertEquals("Park the car", route.getLast());
		Assertions.assertEquals(4,  route.size());
	}
	
	@Test
	void testClearList() {
		route.addToFront("Arques 6");
		route.addToFront("Right in Arques Ave");
		route.addToFront("Left in Lawrence Expressway");
		Assertions.assertEquals(3, route.size());
		route.clearList();
		Assertions.assertEquals(0, route.size());
	}
	
	@Test
	void testRemoveEntry() {
		route.addToFront("Arques 6");
		route.addToFront("Right in Arques Ave");
		route.addToFront("Left in Lawrence Expressway");
		route.addToFront("Delete this route");
		Assertions.assertEquals("Delete this route", route.getFirst());
		route.removeEntry("Delete this route");
		Assertions.assertEquals("Left in Lawrence Expressway", route.getFirst());
	}
	
	@Test
	void testContainsRoute() {
		route.addToFront("Arques 6");
		route.addToFront("Right in Arques Ave");
		route.addToFront("Left in Lawrence Expressway");
		Assertions.assertEquals(true, route.contains("Arques 6"));
		Assertions.assertEquals(false, route.contains("Las Vegas"));		
	}
	
	@Test
	void testAddBefore() {
		route.addToFront("Arsenal");
		route.addToFront("Barcelona");
		route.addToFront("Chelsea");
		route.addToFront("Everton");
		route.addToFront("Fulham");
		route.addToFront("Juventus");
		route.addToFront("Manchester United");
		route.addToFront("QPR");
		route.addToFront("Rotterdam");
		Assertions.assertEquals(9, route.size());
		route.addBefore("Chelsea", "Dinamo Zagreb");
		Assertions.assertEquals(10, route.size());
		route.addBefore("Juventus", "Manchester City"); 
		route.addBefore("Fulham","Inter Milan"); 
		Assertions.assertEquals(12, route.size());
	}
}
