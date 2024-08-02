public class Counter{
    private int count;
    public Counter(){
    }
    public Counter(int initial){
        count = initial;
    }
    public int getCount(){
        return count;
    }
    public void increment(){
        count += 1;
    }
    public void increment(int delta){
        count += delta;
    }
    public void reset(){
        count = 0;
    }
}