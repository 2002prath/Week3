package Hashing;

public class Main {
    public static void main(String[] args) {
        // Creating a CustomHashMap for Integer (Key) and String (Value)
        CustomHashMap<Integer, String> map = new CustomHashMap<>(1, "One");

        System.out.println("Key: " + map.getKey());
        System.out.println("Value: " + map.getValue());

        // Creating a CustomHashMap for String (Key) and Double (Value)
        CustomHashMap<String, Double> priceMap = new CustomHashMap<>("Apple", 1.5);
        System.out.println("Fruit: " + priceMap.getKey());
        System.out.println("Price: " + priceMap.getValue());
    }
}
class CustomHashMap<K, V> {
    // Now you can use K and V as types for keys and values.
    private K key;
    private V value;

    // Constructor to initialize with key-value pair
    public CustomHashMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Methods to interact with the key-value pair
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // You can add more methods here to implement your HashMap functionality
}
