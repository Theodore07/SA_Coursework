package sa_bpp;
import java.util.ArrayList;
import java.util.List;


public class preset_manager {
    private List<Problem> problems;

    public preset_manager() {
        this.problems = new ArrayList<>();
    }

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public Problem getProblemByName(String name) {
        for (Problem problem : problems) {
                if (problem.getProblemName().equals(name)) {
                    return problem;
                }
            }
        return null;    
    }

    public Problem[] addPreset(){

        Problem TEST0049 = new Problem("TEST0049", 43, 10000);
        Problem TEST0014 = new Problem("TEST0014", 47, 10000);
        Problem TEST0082 = new Problem("TEST0082", 48, 10000);
        Problem TEST0044 = new Problem("TEST0044", 56, 10000);
        Problem TEST0030 = new Problem("TEST0030", 55, 10000);

        // Item weights and counts for 'TEST0049'
        int[] itemWeights_TEST0049 = {2472, 2371, 2027, 2026, 1962, 1939, 1864, 1840, 1743, 1681, 1639, 1554, 1542, 1298, 1280, 1260, 1246, 1230, 1158, 1146, 1111, 869, 826, 784, 781, 738, 668, 648, 641, 588, 502, 499, 465, 392, 390, 293, 231, 199, 118, 98, 88, 67, 32};
        int[] itemCounts_TEST0049 = {1, 2, 1, 1, 1, 3, 3, 1, 1, 2, 1, 1, 1, 1, 3, 1, 5, 1, 1, 4, 6, 4, 11, 7, 2, 1, 10, 5, 4, 2, 3, 3, 6, 5, 3, 3, 3, 3, 9, 5, 5, 2, 4};

        // Item weights and counts for 'TEST0014'
        int[] itemWeights_TEST0014 = {4990, 4919, 4640, 4300, 4283, 4225, 4108, 4097, 4071, 3971, 3898, 3875, 3853, 3833, 3747, 3701, 3660, 3388, 3019, 2927, 2832, 2823, 2696, 2408, 1585, 1546, 1222, 1194, 1096, 1049, 958, 876, 865, 835, 676, 636, 613, 583, 527, 515, 506, 484, 478, 425, 294, 186, 64};
        int[] itemCounts_TEST0014 = {2, 3, 2, 3, 2, 3, 4, 2, 4, 2, 1, 5, 1, 1, 2, 2, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 3, 1, 3, 1, 1, 1, 1, 2, 2, 1, 3, 3, 2, 3, 1, 5, 1, 1, 1, 5, 3, 1};

        // Item weights and counts for 'TEST0082'
        int[] itemWeights_TEST0082 = {7332, 6970, 6881, 6879, 6674, 6285, 6009, 5883, 5769, 5573, 5424, 5348, 5180, 5059, 4835, 4673, 4655, 4616, 4275, 4234, 4174, 4127, 4079, 3725, 3036, 2964, 2783, 2583, 2550, 2328, 2304, 2244, 2236, 2014, 1680, 1542, 1390, 1249, 1190, 969, 964, 794, 626, 350, 340, 163, 65, 57};
        int[] itemCounts_TEST0082 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 3, 4, 5, 2, 1, 4, 1, 1, 2, 1, 2, 1, 1, 5, 2, 3, 2, 1, 2, 1, 2, 3, 4};

        // Item weights and counts for 'TEST0044'
        int[] itemWeights_TEST0044 = {2491, 2443, 2410, 2341, 2325, 2251, 2247, 2204, 2197, 1944, 1901, 1893, 1877, 1768, 1721, 1710, 1651, 1551, 1399, 1254, 1235, 1185, 1100, 1064, 1042, 1015, 1005, 901, 882, 869, 860, 854, 818, 813, 712, 682, 504, 483, 433, 419, 417, 411, 394, 384, 366, 354, 321, 311, 307, 267, 186, 185, 156, 151, 133, 41};
        int[] itemCounts_TEST0044 = {1, 1, 1, 2, 1, 1, 1, 2, 3, 1, 2, 3, 2, 2, 2, 1, 3, 1, 2, 6, 2, 2, 1, 1, 6, 2, 1, 1, 1, 5, 3, 4, 6, 5, 1, 10, 4, 2, 2, 9, 1, 4, 4, 6, 9, 6, 5, 1, 1, 4, 2, 2, 6, 1, 2, 4};

       // Item weights and counts for 'TEST0030'
        int[] itemWeights_TEST0030 = {4922, 4854, 4844, 4729, 4723, 4575, 4522, 4508, 4452, 4426, 4282, 4113, 4095, 4062, 4050, 3940, 3813, 3777, 3755, 3746, 3738, 3457, 3389, 3325, 3319, 3255, 3239, 3173, 3020, 2875, 2700, 2316, 2286, 2183, 2162, 1740, 1566, 1530, 1468, 1439, 1366, 1365, 1287, 1256, 1226, 1178, 984, 753, 742, 666, 484, 228, 212, 203, 33};
        int[] itemCounts_TEST0030 = {1, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 3, 2, 2, 1, 2, 2, 2, 4, 1, 1, 1, 4, 1, 2, 2, 3, 1, 1, 1, 3, 3, 3, 5, 2, 1, 2, 1, 1, 2, 3, 1, 1, 2, 3, 2, 3, 4, 3, 1, 2};

        Problem[] presets = {TEST0049, TEST0014, TEST0082, TEST0044, TEST0030};

        for(int id = 0; id < presets.length; id++){
            Problem current = presets[id];
            for(int i = 0; i < current.getNumberOfItem(); i++){
                if(id == 0){
                    current.addPreset(itemWeights_TEST0049[i], itemCounts_TEST0049[i]);
                }else if(id == 1){
                    current.addPreset(itemWeights_TEST0014[i], itemCounts_TEST0014[i]);
                }else if(id == 2){
                    current.addPreset(itemWeights_TEST0082[i], itemCounts_TEST0082[i]);
                }else if(id == 3){
                    current.addPreset(itemWeights_TEST0044[i], itemCounts_TEST0044[i]);
                }else if(id == 4){
                    current.addPreset(itemWeights_TEST0030[i], itemCounts_TEST0030[i]);
                }
            }
        }

        return presets;

    }
}

