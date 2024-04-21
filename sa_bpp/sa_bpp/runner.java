package sa_bpp;


public class runner {
    
    public static void main(String[] args){
        
        preset_manager manager = new preset_manager();
        Problem[] problemList =  manager.addPreset();

        for(Problem pro : problemList){
            manager.addProblem(pro);
        }

        Problem used = manager.getProblemByName("TEST0049");

        System.out.println(used.getWeights());
        
        
    }
}
