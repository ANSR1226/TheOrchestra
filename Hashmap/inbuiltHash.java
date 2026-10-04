import java.util.HashMap;
import java.util.Map;

class inbuiltHash{
    public static void main(String[] args){

        HashMap<String,Integer> map = new HashMap<>();

        map.put("Apple", 5);
        map.put("Mango", 10);


        System.out.println(""+map);
        System.out.print(""+map.get("Apple")+"\n");
        map.remove("Apple"); //to delete element

        //for display


        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.print(entry.getKey() + " -> " +entry.getValue());
        }
    }
}