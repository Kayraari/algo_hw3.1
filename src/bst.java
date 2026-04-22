public class bst <Key extends Comparable<Key>, Value>  {


  //şimdilik bunları koydum üzerine değiştiririz
    public Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        public Node(Key key, Value val){
            this.key=key;
            this.val=val;
        }
    }
    private class Queue<Key>{
        private Node<Key> front;

    }
    //associate value with key
    public void put(Key key, Value val){
        root =put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x==null)
            return new Node(key, val);
        int cmp=key.compareTo(x.key);
        if(cmp<0)
            x.left = put(x.left, key, val);
        else if(cmp>0)
            x.right= put(x.right, key, val);
        else if(cmp==0)
            x.val=val;
        return x;
    }
    //return value corresponding to given key, or null if no key
    public Value get (Key key){
        Node x= root;
        while(x!= null){
            int cmp = key.compareTo(x.key);
            if( cmp <0)
                x=x.left;
            else if( cmp >0)
                x=x.right;
            else if (cmp==0)
                return x.val;
        }
        return null;
    }
    public void delete(Key key){

    }
    //inorder traversal. traverse left subtree, enqueue key, traverse right subtree
    public Iterable<Key> iterator(){
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    }
    private void inorder(Node x, Queue<Key> q){
        if(x==null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }
}

