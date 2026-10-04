import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class LC1_twosum{
    public static void main(String args[]){
        int[] arr;
        int target;
        Scanner sc = new Scanner(System.in);

        System.out.print("size: ");
        int size = sc.nextInt();
        arr = new int[size];

        Map<Integer,Integer> mp = new HashMap<>();

        for (int i=0; i<size; i++){
            System.out.printf("Element %d: ",i);
            arr[i] = sc.nextInt();
        }

        System.out.print("target: ");
        target = sc.nextInt();

        for (int i=0; i<size-1; i++){
            mp.put(arr[i], i);
        }

        for (int i = 0; i<size; i++){
            int complement = target - arr[i];
            if(mp.containsKey(complement) == true && mp.get(complement) != i){
                System.out.print("Indices: "+i+" "+mp.get(complement));
                return;
            }
        }
        System.out.print("Doesn't Exist");      
    }
}