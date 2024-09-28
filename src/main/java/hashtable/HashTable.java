package hashtable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7; // default size is 7
    private Node[] dataMap;

    class Node{
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.dataMap = new Node[size];
    }

    private int hash(String key){
        int hash = 0;
        for(char c : key.toCharArray()){
            hash = (hash + c * 23) / dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        }else{
            Node temp = dataMap[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];

        while(temp != null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public ArrayList<String> keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(Node each : dataMap){
            Node temp =  each;
            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
