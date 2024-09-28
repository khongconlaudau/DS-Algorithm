package queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Queue(int value){
        first = new Node(value);
        last = first;
        length = 1;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = first;
        }else{
            first.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0) return null;

        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
