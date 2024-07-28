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
    public static void main(String[] args) {
        LinkedList lst = new LinkedList();
        lst.addFirst(20);
        System.out.println(lst.head.value);
    }
}
