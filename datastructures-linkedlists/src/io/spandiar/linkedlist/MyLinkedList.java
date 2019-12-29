package io.spandiar.linkedlist;

public class MyLinkedList {
	
	private static class Node {
		String route;
		Node next;
		
		public Node(String data) {
			this.route = data;
		}
	}
	
	private Node head;
	private int size;
	
	public void addToFront(String route) {
	
		Node newNode = new Node(route);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void addToTail(String route) {
		Node newNode = new Node(route);
		
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		size++;
	}
	
	public String getFirst() {
		return head.route;
	}
	
	public String getLast() {
		Node current = head;
		while(current.next !=null) {
			current = current.next;
		}
		return current.route;
	}
	
	public void printRoute() {
		
		Node current = head;
		while (current.next != null) {
			System.out.println("Route: " + current.route);
			current = current.next;
		} 
		System.out.println("Route: " + current.route);
	}
	
	public int size() {
		if(head==null) { size=0; return size; }
		return size;
	}
	
	public void clearList() {
		head=null;
	}
	
	public void removeEntry(String routeToRemove) {
		Node current = head;
		Node previous;
		if(current.route.equals(routeToRemove)) {
			head=current.next;	
			size--;
		}else {
			while(current.next != null) {
				previous = current;
				current = current.next;
				if(current.route.equals(routeToRemove)) {
					previous.next = current.next;
					size--;
				}
			}
		}
	}
	
	public void removeEntryAlternate(String routeToRemove) {	
		
		Node current = head;
		
		if(head==null) {
			return;
		}
		
		if (head.route.equals(routeToRemove)) {
			head=head.next;
			size--;
			return;
		}
		
		while(current.next != null) {
			current = current.next;
			if(current.next.route.equals(routeToRemove)) {
				current.next = current.next.next;
				size--;
				break;
			}
		}
		
	}
	
	public boolean contains(String searchRoute) {
		Node current = head;
		
		if(head==null) {
			return false;
			}
		
		if (head.route.contentEquals(searchRoute)) {
			return true;
		}
		
		while(current.next != null) {
			if (current.next.route.equals(searchRoute)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public void addBefore(String addBeforeRoute, String newRouteToAdd) {
		// check if the string is available
		Node nodeToAppend = new Node(newRouteToAdd);
		Node current = head;
		
		if(contains(addBeforeRoute)) {
			if(head.route.equals(addBeforeRoute)) {
				addToFront(newRouteToAdd);
				return;
			} else {
				while(current.next!= null) {
					if(current.next.route.equals(addBeforeRoute)) {
						nodeToAppend.next = current.next;
						current.next = nodeToAppend;
						size++;
						return;
					}
					current=current.next;
				}
			}
			
		}
		//printRoute();
	}
	
	public static void main(String args[]) {
		
		MyLinkedList officeRoute = new MyLinkedList();
		
		
		officeRoute.addToFront("Reach Taj Mahal");
		officeRoute.addToFront("Right in Duane");
		officeRoute.addToFront("Left in Lawrence");
		officeRoute.addToFront("Left in Sandia");
		
		officeRoute.addToFront("Right in Bridgewood");
		officeRoute.addToFront("Right in Wildwood");
		officeRoute.addToTail("Lets delete this");
		
		//officeRoute.printRoute();
		
		//officeRoute.addToTail("Park the car");
		
		
		//officeRoute.printRoute();
		
		officeRoute.addToFront("Start the car");
		officeRoute.printRoute();
		
		System.out.println("");
		System.out.println("After delete entry");
		System.out.println("");
		
		officeRoute.removeEntryAlternate("Lets delete this");
		officeRoute.printRoute();
	}
}
