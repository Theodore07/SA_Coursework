package sa_bpp;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class SA_H {
    
    private double temperature;
    private double coolingR;
    private Problem prob;

    public SA_H(Problem problem, double temp, double coolingRate){
        this.prob = problem;
        this.temperature = temp;
        this.coolingR = coolingRate;
    }

    private List<Bin> generateRandomSolution(){
        List<Bin> bins = new ArrayList<>();

        List<Item> items = prob.getItems();
        Integer capacity = prob.getCapacity();

        for(int i=0; i < items.size(); i++){
            Integer item = items.get(i).getSize();
            boolean packed = false;
                for(Bin b : bins){
                   if(b.addItem(item)){
                        System.out.println("item added!");
                        packed = true;
                        break;
                   }   
                } if (!packed){
                    Bin bin = new Bin(capacity);
                    bin.addItem(item);
                    bins.add(bin);
                }
            
        }
        for(Bin b : bins){
           b.printItems();
        }
        return bins;
    }

    private List<Bin> generateNewSolution(List<Bin> current_solution, Problem p, Random r){
        
       
        // make a new copy of current solution
        List<Bin> candidateSol = new ArrayList<>();
        candidateSol.addAll(current_solution);

        // for(Bin bin : current_solution){
        //     Bin new_bin = new Bin(p.getCapacity());
            
        //     for(Item item : bin.getItem()){
        //         new_bin.addItem(item.getSize());
        //     }
        // }

        // get a new random bin index and the bin
        
        Integer randBinId = 0;
        if(candidateSol.size() > 0){
            randBinId = r.nextInt(candidateSol.size());
        }else{
            System.out.println("the new solution is empty");
            return candidateSol;
        }
        
        Bin randBin = candidateSol.get(randBinId);
        // get the items inside of it
        List<Item> items = randBin.getItem();
        // select a random index from the specific bin
        Integer randItemId = r.nextInt(items.size());
        // get the new random item
        Item randItem = items.get(randBinId);

        for(Bin bin : candidateSol){
            if(bin != randBin && bin.addItem(randItem.getSize())){
                randBin.removeItem(randItemId);
                break;
            }
        }

        if (randBin.getRemainder() >= randBin.getCapacity()){
            Bin newBin = new Bin(randBin.getCapacity());
            newBin.addItem(randItem.getSize());
            candidateSol.add(newBin);
            randBin.removeItem(randItemId);
        }

        return candidateSol;
    }

    public List<Bin> applySA(){
        Random r = new Random();
        List<Bin> init = generateRandomSolution();

        double t = this.temperature;
        double cr = this.coolingR;

        while(t > 1.0){
            List<Bin> candidateSol = generateNewSolution(init, this.prob, r);
            // calculate cost of current and candidate solution
            int currentSolCost = calculateEnergy(init);
            int candidateSolCost = calculateEnergy(candidateSol);
            int delta = candidateSolCost - currentSolCost;
            if (delta < 0 || Math.exp(-delta / t) > r.nextDouble()) {
                init = candidateSol;
            }

            t *= cr; // Cool down the temperature
        }

            return init;
    }

    private int calculateEnergy(List<Bin> solution){
        int total = 0;
        for(Bin bin : solution){
            total += bin.getUsed() - bin.getRemainder();
        }

        return total;
    }
    

        
 }
    

