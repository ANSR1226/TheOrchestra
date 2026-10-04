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
        this.capacity = 3;
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

    public void delete(String K){
        int index = HashFunction(K);

        Node head = buckets[index];

        while (head!=null){
            if (head.key.equals(K)){
                if (head.next == null){
                    buckets[index] = null;
                    System.out.printf("Key: %s DELETED !!\n", K);
                    return;
                }else{
                    buckets[index] = head.next;
                    System.out.printf("Key: %s DELETED !!\n", K);
                    return;
                }
            }
            Node previous = head;
            Node current = head;

            while(current.next != null){
                current = current.next;
                if (current.key.equals(K)){
                    previous.next = current.next;
                    current = null;
                    System.out.printf("Key: %s DELETED !\n", K);
                    return;
                }
                previous = previous.next;
            }
        }
        System.out.print("Key not in the Hashtable.\n");
        return;
    }


    public void search(String K){
        int index = HashFunction(K);
        Node head = buckets[index];

        if (head!=null){
            Node current = head;
            if (current.key.equals(K)){
                System.out.printf("Key %s FOUND !! ---- BUCKET LOCATION: %d\n", K,index);
                return;
            }
            while (current.next != null){
                current = current.next;
                if (current.key.equals(K)){
                    System.out.printf("Key %s FOUND !! ---- BUCKET LOCATION: %d\n", K,index);
                    return;
                }
            }
        }

        System.out.print("NO KEY FOUND !!\n");
        return;
    }

    public void display(){
        Node head;

        for (int i = 0; i<capacity; i++){
            head = buckets[i];  
            Node current = head;

            if (head == null){
                System.out.printf("| BUCKET %d: NULL\n", i);
            }else{
                System.out.printf("| BUCKET %d: KEY - %s, VALUE =  %d ", i,current.key, current.value);
                while(current.next!=null){
                    current = current.next;
                    System.out.printf("--> BUCKET %d: KEY - %s, VALUE =  %d ", i,current.key, current.value);
                }
                System.out.println("");
            }
        }
    }


    public static void main(String[] args){
        String key;
        int value, option;
        
        Scanner sc = new Scanner(System.in);
        customMap map = new customMap();


        while(true){
            System.out.print("1. Put\n2. Delete\n3. Search\n4. Display\n5. Exit\nOption: ");
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
                case 2:
                    System.out.print("To be deleted key: ");
                    String del_key = sc.nextLine();
                    map.delete(del_key);
                    break;
                case 3:
                    System.out.print("Search Key: ");
                    String search_key = sc.nextLine();
                    map.search(search_key);
                    break;
                
                case 4:
                    map.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.print("Enter a valid option.");
            }
        }
    }    
}