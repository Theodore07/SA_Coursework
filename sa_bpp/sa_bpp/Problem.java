package sa_bpp;
import java.util.ArrayList;
import java.util.List;

public class Problem {
    
    private String p_name;
    private int n;
    private int c;
    private List<Item> Items;

    public Problem(String name, int nOfItem, int capacity){
        this.p_name = name;
        this.n = nOfItem;
        this.c = capacity;
        this.Items = new ArrayList<>();
    }

    public void addPreset(int weight, int nOfItem){
        for(int i = 0; i < nOfItem; i++){
            Item item = new Item(weight);
            Items.add(item);
        }
    }

    public String getProblemName(){
        return p_name;
    }
    
    public int getNumberOfUniqueItem(){
        return n;
    }

    public int getCapacity(){
        return c;
    }

    public List<Item> getItems(){
        return Items;
    }

    public Integer getNumOfItems(){
        return Items.size();
    }


}
