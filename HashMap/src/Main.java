import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> names = new HashMap<>();

        names.put("Key", "Value");



//        names.remove("Key");

        names.replace("Key", "Value1");


        for(String name : names.keySet()) {
            System.out.println(name);
        }


    }
}