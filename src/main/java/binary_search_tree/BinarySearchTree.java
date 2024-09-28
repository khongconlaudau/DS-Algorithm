package binary_search_tree;

public class BinarySearchTree {
    private Node root;

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }else{
            Node temp = root;
            while(true){
                if(temp.value == newNode.value) return false;

                if(temp.value < newNode.value){
                    if(temp.right == null){
                        temp.right = newNode;
                        return true;
                    }
                    temp = root.right;
                }else {
                    if(temp.left == null){
                        temp.left = newNode;
                        return true;
                    }
                    temp = root.left;
                }
            }
        }
    }

    public boolean contains(int searchValue){
        if(root == null) return false;

        Node temp = root;
        while(temp != null){
            if(temp.value == searchValue){
                return true;
            }else if(temp.value < searchValue){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        return false;
    }
}
