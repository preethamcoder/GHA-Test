public class LinkedList{
    static class Node{
        int value;
        Node next;
    
        public Node(int val){
            this.value = val;
            next = null;
        }
    }
    Node head = null;
    public void addFirst(int val){
        Node tmp = new Node(val);
        tmp.next = head;
        head = tmp;
    }
    public void addLast(int val){
        Node tmp = new Node(val);
        if(head == null){
            head = tmp;
            return;
        }
        Node nd = head;
        while(nd.next != null){
            nd = nd.next;
        }
        nd.next = tmp;
    }
    public static void main(String[] args) {
        LinkedList lst = new LinkedList();
        lst.addLast(-20);
        lst.addFirst(20);
        lst.addLast(2);
        lst.addLast(100);
        lst.addFirst(80);

        Node tmp = lst.head;
        while(tmp != null){
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
        // System.out.println(lst.head.value);
    }
}
