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
                if(Integer.max(x, subtract) == subtract){
                    subtract -= x;
                    x = 0;
                    password++;
                }
                x -= subtract;
                password += Math.abs(x / 100);
                x = Math.floorMod(x, 100);

            } else if(command.substring(0,1).equals("R")){
                int add = Integer.parseInt(command.substring(1));
                x += add;
                password += Math.abs(x / 100);
                x = Math.floorMod(x, 100);
            }
        }
        System.out.println(password);
    }
}

