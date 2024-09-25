package duc.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        static int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getLength(){
        return length;
    }

    public int getHead(){
        return head.value;
    }

    public int getTail(){
        return tail.value;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = head;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public Node removeLast(){
        if (length == 0){
            return null;
        }

        Node temp = head;
        Node pre = head;

        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = head;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length ==0) return null;

        Node temp = head;
        head = head.next;
        if (length >1){
            temp.next = null;
        }
        length --;
        if (length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        Node temp = head;
        if (index >= 0 && index < length ){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
      if (index>=0 && index<=length){
          if (index == 0){
              prepend(value);
              return true;
          }else if (index == length){
              append(value);
              return true;
          }else {
              Node newNode = new Node(value);
              Node temp = get(index-1);
              newNode.next = temp.next;
              temp.next = newNode;
              length ++;
              return true;
          }

      }
      return false;
    }

    public Node remove(int index){
        if (index >=0 && index < length){
            if (index == 0){
                return removeFirst();
            }else if (index == length-1){
                return removeLast();
            } else {
                Node pre = get(index-1);
                Node temp = pre.next;

                pre.next = temp.next;
                temp.next = null;
                length--;
                return temp;
            }
        }
        return null;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        for(int i=0; i<length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
        }
        return slow;
    }






}
