import java.util.ArrayList;
import java.util.Arrays;

public class GreedyTSP {

    public static void main(String[] args) {
        double[][] adjacency = {
            {0, 2, 6, 4, 3, 3},
            {2, 0, 3, 4, 5, 2},
            {6, 3, 0, 4, 7, 5},
            {4, 4, 4, 0, 2, 3},
            {3, 5, 7, 2, 0, 1},
            {3, 2, 5, 3, 1, 0}
        };

        int depot = 5;

        int n = adjacency.length;
        int[] solusi = new int[n + 1];
        solusi[0] = depot;
        solusi[n] = depot;
        ArrayList<Integer> visited = new ArrayList<Integer>();
        visited.add(depot);// masukkan titik awal 

        int k = 1;
        while (k < solusi.length - 1) {
            ArrayList<Integer> kandidat = new ArrayList<>();
            int origin = solusi[k - 1];
            int destination = origin;
            double min = Double.MAX_VALUE;
            for (int i = 0; i < adjacency.length; i++) {
                if (adjacency[origin][i] > 0 && adjacency[origin][i] < min && !visited.contains(i)) {
                    destination = i;
                    min = adjacency[origin][i];
                    
                }
                
            }
            solusi[k]= destination;
            visited.add(destination);
            k++;
        }
        
       double totalJarak = 0;
        for (int i = 1; i < solusi.length; i++) {
            int v0 = solusi[i-1];
            int v1 = solusi[i];
            double jarak = adjacency[v0][v1];
             totalJarak += jarak;
        }
        
        for (int i = 0; i < solusi.length; i++) {
            
        }
        System.out.println(Arrays.toString(solusi));
        System.out.println(totalJarak);

    }
}
