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
                while(subtract>=100){
                    x = Math.floorMod(x-100, 100);
                    password++;
                    subtract-=100;
                }
                if(x == 0){
                    System.out.println("a");
                }
                if(Math.floorMod(x-subtract, 100) > x || Math.floorMod(x-subtract, 100) == 0){
                    password++;
                }
                x = Math.floorMod(x-subtract, 100);
            } else if(command.substring(0,1).equals("R")){
                int add = Integer.parseInt(command.substring(1));
                while(add>=100){
                    x = Math.floorMod(x+100, 100);
                    password++;
                    add-=100;
                }
                if(x == 0){
                    System.out.println("a");
                }
                if(Math.floorMod(x+add, 100) < x || Math.floorMod(x+add, 100) == 0){
                    password++;
                }
        }
    }
        System.out.println(password);
}
}

