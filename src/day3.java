import java.io.BufferedReader;
import java.io.FileReader;

public class day3 {
    public static void main(String[] args) throws Exception {
            FileReader reader = new FileReader("./inputday3");
            BufferedReader breeder = new BufferedReader(reader); // keepo
            Object[] input = breeder.lines().toArray();
            long solv = 0;
            for(Object tempLine: input){
                String line = tempLine.toString();
                boolean achado = false;
                int i = 9;
                while (!achado) {
                    while(line.indexOf(Integer.toString(i)) == -1 ||line.indexOf(Integer.toString(i)) == line.length() -1){
                        i--;
                    }
                    int j = 9;
                    while (!achado && j > 0){
                        String strI = Integer.toString(i);
                        String strJ = Integer.toString(j);
                        int indexI = line.indexOf(strI);
                        int indexJ = line.lastIndexOf(strJ);
                        if(indexI < indexJ){
                            achado = true;
                            int sol = Integer.parseInt(strI + strJ);
                            solv += sol;
                        }
                        if(i < 1){
                            System.out.println("hello");
                        }
                        j--;
                    }
                    i--;
                }   
            }
            System.out.println(solv);
    }
}
    
