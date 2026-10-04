import java.util.Scanner;
import java.util.Hashtable;

class customMap{


    public static class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    static int capacity;
    static Node[] buckets;

    customMap(){
        this.capacity = 10;
        this.buckets = new Node[capacity];
    }

    public static int HashFunction(String k){
        int rawIndex = k.hashCode();
        int processed_index = Math.abs(rawIndex) % capacity;
        return processed_index;
    }

    public void put(String K, int V){
        int index = HashFunction(K);
        
        Node head = buckets[index];

        if(head == null){
            buckets[index] = new Node(K,V);
            return;
        }

        Node current = head;

        while(current.next != null){
            if(current.key.equals(K)){
                current.value = V;
                return;
            }
            current = current.next;
        }

        current.next = new Node(K, V);
    }


    public void display(){
        Node head;

        for (int i = 0; i<capacity; i++){
            head = buckets[i];
            Node current = head;

            if (head == null){
                System.out.printf("BUCKET %d: NULL\n", i);
            }else{
                while(current.next!=null){
                    System.out.printf("| BUCKET %d: KEY - %s, VALUE =  %d |--> ", i,head.key, head.value);
                    current = current.next;
                }
                System.out.printf("| BUCKET %d: KEY - %s, VALUE =  %d |\n ", i,head.key, head.value);
            }
        }
    }


    public static void main(String[] args){
        String key;
        int value, option;
        
        Scanner sc = new Scanner(System.in);
        customMap map = new customMap();


        while(true){
            System.out.print("1. Put\n2. Delete\n3. Display\n4. Exit\n");
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option){
                case 1:
                    System.out.print("Enter key: ");
                    key = sc.nextLine();
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    sc.nextLine();

                    map.put(key,value);
                    break;
                
                case 3:
                    map.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.print("Enter a valid option.");
            }
        }
    }    
}