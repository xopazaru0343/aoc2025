
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class day2 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("./inputday2");
        BufferedReader breeder = new BufferedReader(reader); // keepo
        String[] input = breeder.readLine().split(",");

        ArrayList<Long> set = new ArrayList<Long>();
        long finaldestination = 0;

        for(long i = 0; i<100000; i++){
            String a = Long.toString(i);
            set.add(Long.parseLong(a.concat(a)));
        }

        for(String range: input){
            String[] bounds = range.split("-");
            long bound1 = Long.parseLong(bounds[0]);
            long bound2 = Long.parseLong(bounds[1]);
            int a = BinarySearchLeft(set, bound1);
            System.out.println(range);
            while(a < set.size() && set.get(a) >= bound1 && set.get(a) <= bound2){
                finaldestination += set.get(a);
                a++;
            }
        }
        breeder.close();
        System.out.println(finaldestination);
}
    public static int BinarySearchLeft(ArrayList<Long> array, long key) {
        int lo = 0;
        int hi = array.size();
        while (lo < hi)
        {
            int mid = (lo+hi) / 2;
            if (array.get(mid) < key)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
