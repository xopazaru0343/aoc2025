import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class day2part2 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("./inputday2");
        BufferedReader breeder = new BufferedReader(reader); // keepo
        String[] input = breeder.readLine().split(",");

        HashSet<Long> set = new HashSet<Long>();
        long finaldestination = 0;

        for(long i = 0; i<100000; i++){
            String a = Long.toString(i);
            String atemp = a;
            while(atemp.concat(a).length() <= 10){
            atemp = atemp.concat(a);
            set.add(Long.parseLong(atemp));
            }
        }

        ArrayList<Long> list = new ArrayList<Long>(set);
        Collections.sort(list);

        for(String range: input){
            String[] bounds = range.split("-");
            long bound1 = Long.parseLong(bounds[0]);
            long bound2 = Long.parseLong(bounds[1]);
            int a = BinarySearchLeft(list, bound1);
            System.out.println(range);
            while(a < list.size() && list.get(a) >= bound1 && list.get(a) <= bound2){
                System.out.println(list.get(a));
                finaldestination += list.get(a);
                a++;
            }
        }
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
