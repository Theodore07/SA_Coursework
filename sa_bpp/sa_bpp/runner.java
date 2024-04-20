package sa_bpp;


public class runner {
    
    public static void main(String[] args){
        
        preset_manager manager = new preset_manager();
        Problem[] problemList =  manager.addPreset();

        System.out.println(problemList[0].getNumberOfItem());
        
        
    }
}
