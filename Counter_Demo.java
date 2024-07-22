public class Counter_Demo{
    public static void main(String[] args){
        Counter c = new Counter();
        c.increment();
        c.increment(10);
        int tmp = c.getCount();
        System.out.println(tmp);
        c.reset();
        tmp = c.getCount();
        System.out.println(tmp);
        Counter d = new Counter(10);
        d.increment(10);
        int temp = d.getCount();
        System.out.println(temp);
        d.reset();
        temp = d.reset();
        System.out.println(temp);
    }
}