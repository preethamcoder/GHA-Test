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
    int elems = 0;
    public void addFirst(int val){
        Node tmp = new Node(val);
        tmp.next = head;
        head = tmp;
        elems += 1;
    }
    public void addLast(int val){
        Node tmp = new Node(val);
        if(head == null){
            head = tmp;
            elems += 1;
            return;
        }
        Node nd = head;
        while(nd.next != null){
            nd = nd.next;
        }
        nd.next = tmp;
        elems += 1;
    }
    public void addAtN(int v, int pos){
        if(pos > elems || pos < 0){
            System.out.println("Invalid index");
            return;
        }else if(pos == 0){
            addFirst(v);
            return;
        }else if(pos == elems){
            addLast(v);
            return;
        }else{
            Node nd = head;
            int cter = 0;
            Node adder = new Node(v);
            while(cter < pos){
                nd = nd.next;
                cter += 1;
            }
            adder.next = nd.next;
            nd.next = adder;
        }

    }
    public static void main(String[] args) {
        LinkedList lst = new LinkedList();
        lst.addLast(-20);
        lst.addFirst(20);
        lst.addAtN(-100, 1);
        // lst.addLast(2);
        // lst.addLast(100);
        // lst.addFirst(80);

        Node tmp = lst.head;
        while(tmp != null){
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
        // System.out.println(lst.head.value);
    }
}
