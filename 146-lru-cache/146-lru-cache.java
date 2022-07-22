class LRUCache {
    static class Node{
        Node next;
        Node prev;
        int key;
        int value;
    }
    
    Node head;
    Node tail;
    int size;
    int cap;
    HashMap<Integer,Node> map=new HashMap<>();
    
    void remove(Node node){
        if(size==1){
            head=tail=null;
        }
        else if(node==head){
            head=head.next;
            head.prev=null;
        }
        else if(node==tail){
            Node nm1=node.prev;
            nm1.next=null;
            tail=nm1;
        }
        else{
            Node nm1=node.prev;
            Node np1=node.next;
            nm1.next=np1;
            np1.prev=nm1;
        }
        size--;
    }
    void addFront(int key,int value){
        Node node=new Node();
        node.value=value;
        node.key=key;
        if(size==0){
            head=tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        size++;
    }

    public LRUCache(int capacity) {
        this.cap=capacity;
        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            addFront(key,node.value);
            map.put(key,head);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            
            remove(node);
            addFront(key,node.value);
            map.put(key,head);
        }
        else{
            if(size==cap){
                map.remove(tail.key);
                remove(tail);
                addFront(key,value);
                map.put(key,head);
            }
            else{
                addFront(key,value);
                map.put(key,head);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */