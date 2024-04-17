package sa_bpp;
import java.util.List;
import java.util.ArrayList;

class Bin{

    private int c;
    private List<Integer> items;

    public Bin(int c){
        this.c = c;
        this.items = new ArrayList<>();
    }
    
    public boolean addItem(int size){
        if (getRemainder() >= size){
            items.add(size);
            return true;
        }
        return false;
    }

    int getRemainder(){
        int used = items.stream().mapToInt(Integer::intValue).sum();
        return this.c - used;
    }
}