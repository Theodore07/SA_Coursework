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
                        packed = true;
                        break;
                   }   
                } if (!packed){
                    Bin bin = new Bin(capacity);
                    bin.addItem(item);
                    bins.add(bin);
                }
            
        }
        
        return bins;
    }

    private List<Bin> generateNewSolution(List<Bin> current_solution, Problem p, Random r){
        
       
        // make a new copy of current solution
        List<Bin> candidateSol = new ArrayList<>(current_solution);

        // select a random bin, and check if the new solutin is empty or not
        Integer randBinId = 0;
        if(candidateSol.size() ==  current_solution.size()){
            randBinId = r.nextInt(candidateSol.size());
        }else{
            System.out.println("the new solution is empty");
            return candidateSol;
        }
        Bin randBin = candidateSol.get(randBinId);

        // get the items inside of it
        List<Item> items = randBin.getItem();
        Integer randItemId = r.nextInt(items.size());

        // get the new random item
        Item randItem = items.get(randItemId);

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

        long startT = System.currentTimeMillis();
        double t = this.temperature;
        double cr = this.coolingR;
        int iterate = 0;

        while(t > 0){
            System.out.println("Iteration" + " " + iterate + " " + " number of bins: " + init.size() + " " + "current temperature:" + t);
            List<Bin> candidateSol = generateNewSolution(init, this.prob, r);
            // calculate cost of current and candidate solution
            int currentSolCost = calculateEnergy(init);
            int candidateSolCost = calculateEnergy(candidateSol);
            int delta = candidateSolCost - currentSolCost;
            if (delta < 0 || Math.exp(-delta / t) > r.nextDouble(0,1)) {
                init = candidateSol;
            }
            
            
            iterate += 1;
            t *= cr; // Cool down the temperature
        }

        long endT = System.currentTimeMillis();
        long runTime = endT - startT;
        System.out.println("Execution Time: " + runTime);
        
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
    

