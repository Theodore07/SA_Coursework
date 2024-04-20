package sa_bpp;
import java.util.ArrayList;
import java.util.List;

public class Problem {
    
    private String p_name;
    private int n;
    private int c;
    private List<Integer> ItemW;
    private List<Integer> ItemC;

    public Problem(String name, int nOfItem, int capacity){
        this.p_name = name;
        this.n = nOfItem;
        this.c = capacity;
        this.ItemW = new ArrayList<>();
        this.ItemC = new ArrayList<>();
    }

    public void addPreset(int weight, int nOfItem){
        ItemW.add(weight);
        ItemC.add(nOfItem);
    }

    public String getProblemName(){
        return p_name;
    }
    
    public int getNumberOfItem(){
        return n;
    }

    public int getCapacity(){
        return c;
    }

    public List<Integer> getWeights(){
        return ItemW;
    }

    public List<Integer> getCount(){
        return ItemC;
    }


}
