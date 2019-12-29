package io.spandiar.hashmaps;

public class MyHashMap {
	
	private static int length = 16;
	private int size;
	private HashNode[] dataNode;
	
	private static class HashNode {
		String key;
		String value;
		HashNode next;
		
		public HashNode(String club, String city) {
			this.key = club;
			this.value = city;
		}
	}

	public MyHashMap() {
		dataNode = new HashNode[length];
	}

	public void putData(String key, String value) {
		
		int index = getIndex(key);
		
		if(dataNode[index] == null) {
			dataNode[index] = new HashNode(key, value);
			size++;
			return;
		} else
		{
			// there is already an element in the index. add it to the linked list
			HashNode nodeAtIndex = dataNode[index];
			HashNode dataToAdd = new HashNode(key,value);
			
			while(nodeAtIndex.next!=null) {
				nodeAtIndex=nodeAtIndex.next;
			}
			nodeAtIndex.next=dataToAdd;
		}
	}
	
	
	public String getData(String key) {
		int index = getIndex(key);
		HashNode nodeAtIndex = dataNode[index];
		
		if(nodeAtIndex!=null) {
			while(!nodeAtIndex.key.equals(key) && nodeAtIndex.next!=null) {
				nodeAtIndex=nodeAtIndex.next;
			}
			if(nodeAtIndex.key.equals(key)) {
				return nodeAtIndex.value;	
			}
		}
		return null;
	}
	
	
	public int getIndex(String dataKey) {
		return ((dataKey.hashCode() & 0xffffff) % length);
	}


	public static void main(String[] args) {
		
		MyHashMap myHashMap = new MyHashMap();
		
		myHashMap.putData("Arsenal", "London");
		myHashMap.putData("PSG", "Paris");
		myHashMap.putData("Real Madrid", "Madrid");
		myHashMap.putData("Chelsea", "London");
		myHashMap.putData("Monaco", "Monaco");
		myHashMap.putData("Juventus", "Turin");
		myHashMap.putData("Lyon", "Lyon");
		myHashMap.putData("Everton", "Liverpool");
		myHashMap.putData("Barcelona", "Barcelona, Spain");
		myHashMap.putData("Valencia", "Valencia, Spain");
		myHashMap.putData("Bayern Munich", "Munich, Germany");
		myHashMap.putData("Benfica", "Benfica");
		myHashMap.putData("Galatasaray", "Turkey");
		
		System.out.println("Added values to the map");
		
		System.out.println("PSG is in: " + myHashMap.getData("PSG"));
		System.out.println("Arsenal is in: " + myHashMap.getData("Arsenal"));
		System.out.println("Benfica is in: " + myHashMap.getData("Benfica"));
		System.out.println("Bayern Munich is in: " + myHashMap.getData("Bayern Munich"));
		System.out.println("Tottenham is in: " + myHashMap.getData("Tottenham"));
	}
}
