package sa_bpp;
import java.util.List;
import java.util.ArrayList;

class Bin{

    private int c;
    private List<Item> items;

    public Bin(int c){
        this.c = c;
        this.items = new ArrayList<>();
    }
    
    public boolean addItem(int size){
        if (getRemainder() >= size){
            Item i = new Item(size);
            items.add(i);
            return true;
        }
        return false;
    }

    int getRemainder(){
        int used = items.stream().mapToInt(item -> item.getSize()).sum();
        return this.c - used;
    }

    int getUsed(){
        return items.stream().mapToInt(item -> item.getSize()).sum();
    }
    int getNumOfItem(){
        return items.size();
    }

    List<Item> getItem(){
        return items; 
    }
}