package HashMap;
import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{  //generic class
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; // n
        private int N; 
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        } 

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[2 * N];
            N = 2 * N;
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            // copy old elements
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){   //O(Lambda) -> O(1)
            int bi = hashFunction(key); // bucket index goes from 0 to size-1
            int di = SearchInLL(key, bi); 
            
            if(di != -1){      // key already exists, update value
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{       // key does not exist, insert new key-value pair
                buckets[bi].add(new Node(key,value));
                n++;
            }
            double lambda = (double)n/N;

            if(lambda > 2.0){
                rehash();
            }
        }
        
        public boolean containsKey(K key){  // O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){   //O(1) 
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){    // O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }      
        }
        public ArrayList<K> keySet(){   // O(N)
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node: ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){   // O(1)
            return n==0;
        }
        
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 1);
        hm.put("USA", 2);
        hm.put("China", 3);
        hm.put("UK", 4);
        hm.put("Russia", 5);

        ArrayList<String> keys = hm.keySet();
        for(String key: keys){
            System.out.println("Key: " + key + ", Value: " + hm.get(key));
        }
    }
}
