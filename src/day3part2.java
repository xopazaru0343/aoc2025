import java.io.BufferedReader;
import java.io.FileReader;

public class day3part2 {
    public static void main(String[] args) throws Exception {
            long start = System.currentTimeMillis();
            FileReader reader = new FileReader("./inputday3");
            BufferedReader breeder = new BufferedReader(reader); // keepo
            Object[] input = breeder.lines().toArray();
            long solv = 0;
            for(Object tempLine: input){
                String line = tempLine.toString();
                int index = 0; 
                int i = 9;
                StringBuffer sb = new StringBuffer();
                while (sb.length() != 12) {
                    int indexV = line.indexOf(Integer.toString(i), index);
                    while(indexV == -1 || indexV > line.length() - Math.abs(12 - sb.length())){
                        i--;
                        indexV = line.indexOf(Integer.toString(i), index);
                    }
                    sb.append(i);
                    if(line.length() - 1 - indexV == 0){
                        sb.append(line.substring(indexV+1));
                    } else{
                        index = indexV + 1;
                        i = 9;
                    }
            }
            solv += Long.parseLong(sb.toString());
        }
        breeder.close();
        System.out.println(solv);
        System.out.print(System.currentTimeMillis() - start);
    }
}
