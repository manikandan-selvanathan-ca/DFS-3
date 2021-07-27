
import java.util.*;

public class ConfusingNumber2 {

    int result;
    
    public int confusingNumberII(int n) {
        if(n == 0 ) return 0;
        
        result = 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        helper(map, 0,n);
        return result;
    }
    
    private void helper(HashMap<Integer,Integer> map, long current, int max) {
        //base
        if(current > max) {
            return;
        }
        if(isConfusingNumber(map, current)) {
                result++;
        }
        
        //logic
        for(int key: map.keySet()) {
            long value = current*10 +  key;
            if(value !=0) {
                helper(map, value, max);    
            }
        }
        
    }
    
    private boolean isConfusingNumber(HashMap<Integer,Integer> map, long n) {
        
        long original = n;
        long result = 0;
        while(n > 0) {
            int last = (int)n%10;
            result =  map.get(last) + (result * 10);
            n = n / 10;
        }
        
        return result != original;
        
    }


    public static void main(String[] args) {
        
    }
}