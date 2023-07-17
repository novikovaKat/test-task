public class Pair{
    private final int index;
    private int count;
    public Pair(int index, int count){
        this.index = index;
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount(){
        count++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "index=" + index +
                ", count=" + count +
                '}';
    }
}