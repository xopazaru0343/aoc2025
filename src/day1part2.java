import java.io.BufferedReader;
import java.io.FileReader;
public class day1part2 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("./inputday1part2");
        BufferedReader breeder = new BufferedReader(reader); // keepo
        Object[] input = breeder.lines().toArray();
        int x = 50;
        int password = 0;
        for(Object command1: input){
            String command = command1.toString();
            if(command.substring(0,1).equals("L")){
                int subtract = Integer.parseInt(command.substring(1)); 
                for(int i = 0; i<subtract; i++){
                    x = Math.floorMod(x-1, 100);
                    if(x==0){
                        password++;
                    }
                }

            } else if(command.substring(0,1).equals("R")){
                int add = Integer.parseInt(command.substring(1));
                    for(int i = 0; i<add; i++){
                    x = Math.floorMod(x+1, 100);
                    if(x==0){
                        password++;
                    }
                }
            }
    }   
        breeder.close();
        System.out.println(password);
}
}

