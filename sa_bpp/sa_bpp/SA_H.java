package sa_bpp;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class SA_H {
    
    private Bin[] initial_bins;
    private double temperature;
    private double coolingR;
    private double Energy;
    private Problem prob;

    public SA_H(Problem problem, double temp, double coolingRate){
        this.prob = problem;
        this.temperature = temp;
        this.coolingR = coolingRate;
    }

    private List<Bin> generateRandomSolution(Problem pro){
        List<Bin> bins = new ArrayList<>();
        Random random = new Random();

        List<Integer> itemWeight = pro.getWeights();
        List<Integer> itemCount = pro.getCount();
        int capacity = pro.getCapacity();

        for(int i=0; i < itemWeight.size(); i++){
            Integer item = itemWeight.get(i);
            int item_counts = itemCount.get(i);
            for(int j = 0; j < item_counts; j++){
                boolean packed = false;
                for(Bin b : bins){
                   if(b.addItem(item)){
                        packed = true;
                        break;
                   }   
                } if (!packed){
                    Bin bin = new Bin(capacity);
                    bin.addItem(item);
                    bins.add(bin);
                }
            }
        }

        return bins;
    }

    private List<Bin> generateNewSolution(Problem p){
        
    }

    public applySA(Problem pro, double temp, double coolingR){
        Random r = new Random();
        List<Bin> init = generateRandomSolution(pro);

        double t = temp;
        double cr = coolingR;

        while(temp > 1.0){

        }
        
    }
    
}
