package bitcamp.java110.cms.util;

public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int length;

    public LinkedList() {
        first=last=new Node<>();
    }

    public void add(T obj) {
        last.value=obj;
        Node<T> node=new Node<>();
        node.prev=last;
        last.next=node;
        last=node;
        length++;
    }

    public T get(int index) {
        if(index <0 || index >=length) {
            return null;
        }
        Node<T> cursor = first;

        for(int count=0;count<index;count++) {
            cursor=cursor.next;
        }
        return cursor.value;
    }

    public T remove(int index) {
        if(index <0 || index >=length) 
            return null;
        length--;
        
        Node<T> cursor=first;
        for(int count=0;count<index;count++) {
            cursor=cursor.next;
        }
        if(cursor==first) {
            first=first.next;
            first.prev=null;
            return cursor.value;
        }
        cursor.prev.next=cursor.next;
        cursor.next.prev=cursor.prev;
        return cursor.value;
    }

    public void insert(int index, T obj) {
        if(index <0 || index >=length) 
            return;
        length++;
        Node<T> node=new Node<>();
        node.value=obj;
        Node<T> cursor=first;
        for(int count=0;count<index;count++) {
            cursor=cursor.next;
        }
        // previous node can connect a newnode if previous node exists
        if(cursor!=first) {
        cursor.prev.next=node; //previous node points new node
        node.prev=cursor.prev; //new node points previous node
        cursor.prev=node; //present node point new node
        node.next=cursor; //next of new node points present node
        }
    }

    public int size() {
        return this.length;
    }

    class Node<T2>{ //make datatype
        T2 value;
        Node<T2> next;
        Node<T2> prev;

        public Node() {}

        public Node(T2 value, Node<T2> prev) {
            this.value=value;
            this.prev=prev;
        }
    }


}
