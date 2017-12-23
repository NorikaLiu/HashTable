/*
 * This class sets up the has table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	// constructor
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod division %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		// your code here
	
		if (key==null) {
			return 0;
		}	
		else 
		{int sum = 0;
			for (int i=0; i < key.length(); i++) {
			char place = key.charAt(i);
			sum = sum + place;
		}
		return Math.abs(sum) % 8;
	}
	
}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		Node a = new Node (key);
		if (map[hash(key)] != null) {
			Node temp = new Node(map[hash(key)].record);
			map[hash(key)].record = key;
			map[hash(key)].next = temp;
		} else {
			map[hash(key)] = a;
		}
		// your code here
	}
	
	/*
	 * This method returns true if the search key is contained in the
	 * hash table, and false otherwise.
	 */
	public boolean search(String key) {
		// your code here
	int apple = hash (key);
	Node point = map [apple];
	int i = 0;
	while (point != null && i == 0) {
		if (point.record == map[apple].record)
			i++;
			else{
				point = point.next;
			}
		}
		if( i > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * This method should print out the hash table row by row.
	 * Each line should print out a separate row of the table.
	 * Print the index followed a colon and then the records in that
	 * bucket with spaces between them.
	 * 
	 * For example:
	 * 1: Nicholas Mary Kim Jack
	 */
	public void printTable() {
		Node pointer = map[0];
		for (int i = 0; i < map.length; i++) {
			while (pointer != null) {
				System.out.println(i + ": " + pointer.record);
				pointer = pointer.next;
			}
			pointer = map[i];
			
		}
		// your code here
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		// your code here
	int num =  hash(key);
	Node p= map[num];
	int a = 0;
	while (p != null && a == 0) {
		if (p.next.record.equals(key)) {
			p.next = null;
			a ++;
		} else {
			p = p.next;
		}
	
	}
	
	}
	
}
