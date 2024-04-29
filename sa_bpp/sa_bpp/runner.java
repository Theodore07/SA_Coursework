package sa_bpp;

import java.util.List;

public class runner {
    
    public static void main(String[] args){
        
        preset_manager manager = new preset_manager();
        Problem[] problemList =  manager.addPreset();

        for(Problem pro : problemList){
            manager.addProblem(pro);
        }

        // just input the name of the problem : TEST0049, TEST0014, TEST0082, TEST0044, TEST0030
        Problem used = manager.getProblemByName("TEST0030");
        
        SA_H solver = new SA_H(used, 100, 0.1);
        List<Bin> solution = solver.applySA();
        System.out.println("================== This is the solution ===================");
        System.out.println("Number of bins used:" + solution.size());
        Integer totalWastedSpace = 0;
        for(Bin b : solution){
            b.printItems();
            totalWastedSpace += b.getRemainder();
        }
        System.out.println("Total amount of unused space:" + totalWastedSpace);
    }
}
