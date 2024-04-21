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

    private List<Bin> generateNewSolution(List<Bin> current_solution, Problem p, Random r){
        
        List<Bin> candidateSol = new ArrayList<>();
        
        // make a new copy of current solution
        for(Bin bin : current_solution){
            Bin new_bin = new Bin(p.getCapacity());
            for(Item item : bin.getItem()){
                new_bin.addItem(item.getSize());
            }
        }

        Item items = 
        int item_id = r.nextInt(0);


        return candidateSol;
    }

    public applySA(Problem pro, double temp, double coolingR){
        Random r = new Random();
        List<Bin> init = generateRandomSolution(pro);

        double t = temp;
        double cr = coolingR;

        while(temp > 1.0){
            List<Bin> candidateSol = generateNewSolution(init, pro, r);
            // calculate cost of current and candidate solution
        }
        
    }
    
}
