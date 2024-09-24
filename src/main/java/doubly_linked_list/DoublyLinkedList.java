package doubly_linked_list;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0) return null;

        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if( index>=0 && index < length){
            Node temp = head;
            if (index < length/2){
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            }else {
                temp = tail;
                for(int i=0; i<(length-index-1); i++){
                    temp = temp.prev;
                }
            }
            return temp;
        } return null;
    }

    public boolean insert(int index, int value){
 	    if(index >=0 && index<=length){
 	        if(index ==0 ){
 	            prepend(value);
 	            return true;
 	        }else if (index == length){
 	            append(value);
 	            return true;
 	        }else {
 	            Node temp = get(index-1);
 	            Node newNode = new Node(value);
 	            newNode.next = temp.next;
 	            newNode.prev = temp;
 	            temp.next.prev = newNode;
 	            temp.next = newNode;
 	            length++;
 	            return true;
 	        }
 	    }
 	    return false;
 	}
    public int getHead() {
        return head.value;
    }
    public Node remove(int index){
        if (index>=0 && index<length){
            if(index==0) return removeFirst();
            else if (index==length-1) return removeLast();
            else{
                Node temp  = get(index);
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.next = null;
                temp.prev = null;
                length--;
                return temp;
            }
        }
        return null;
    }

    public boolean set(int index, int value) {
        if (index >= 0 && index < length) {
            Node temp = get(index);
            temp.value = value;
            return true;
        }else
            return false;
    }

    public int getTail() {
        return tail.value;
    }

    public int getLength() {
        return length;
    }
}
