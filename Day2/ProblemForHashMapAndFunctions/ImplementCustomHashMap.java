package Day2.ProblemForHashMapAndFunctions;
import java.util.*;

public class ImplementCustomHashMap {
    private static final int SIZE = 1000; // Number of buckets
    private LinkedList<Node>[] map;

    // Node class to store key-value pairs
    static class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor: Initialize buckets
    public ImplementCustomHashMap () {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to get bucket index
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {
        int index = hash(key);
        for (Node node : map[index]) {
            if (node.key == key) {
                node.value = value; // Update value if key exists
                return;
            }
        }
        map[index].add(new Node(key, value)); // Insert new node
    }

    // Retrieve value associated with a key
    public int get(int key) {
        int index = hash(key);
        for (Node node : map[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1; // Key not found
    }

    // Remove a key-value pair
    public void remove(int key) {
        int index = hash(key);
        map[index].removeIf(node -> node.key == key);
    }

    public static void main(String[] args) {
        ImplementCustomHashMap hashMap = new ImplementCustomHashMap();

        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(102, 30); // Causes collision with key 2 (102 % 1000 = 2)

        System.out.println("Value for key 1: " + hashMap.get(1)); // 10
        System.out.println("Value for key 2: " + hashMap.get(2)); // 20
        System.out.println("Value for key 102: " + hashMap.get(102)); // 30

        hashMap.remove(2);
        System.out.println("Value for key 2 after removal: " + hashMap.get(2));
    }
}




