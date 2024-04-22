package sa_bpp;

import java.util.List;

public class runner {
    
    public static void main(String[] args){
        
        preset_manager manager = new preset_manager();
        Problem[] problemList =  manager.addPreset();

        for(Problem pro : problemList){
            manager.addProblem(pro);
        }

        // just input the name of the problem
        Problem used = manager.getProblemByName("TEST0049");

        // System.out.println(used.getWeights());
        
        SA_H solver = new SA_H(used, 100, 0.005);
        List<Bin> solution = solver.applySA();
        int n = solution.size();
        System.out.println("================== This is the solution ===================");
        System.out.println("Number of bins used:");
        System.out.println(n);
        for(Bin b : solution){
            b.printItems();
        }
    }
}
