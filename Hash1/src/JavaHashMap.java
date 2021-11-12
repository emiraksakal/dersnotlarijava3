import java.util.HashMap;

/**
 *
 * @author Ozay
 */
public class JavaHashMap {
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, String> dictionary  = new HashMap<>(9);

        dictionary.put("Tag","day");
        dictionary.put("Hut","hat");
        dictionary.put("Uhr","clock");
        dictionary.put("Rad","wheel");
        dictionary.put("Ohr","ear");
        dictionary.put("Tor","gate");
        System.out.println("dictionary=" + dictionary);
        System.out.println("dictionary.size()=" + dictionary.size());
        System.out.println("dictionary.keySet()=" + dictionary.keySet());
        System.out.println("dictionary.values()=" + dictionary.values());
        System.out.println("dictionary.get(\"Uhr\")=" + dictionary.get("Uhr"));
        System.out.println("dictionary.remove(\"Rad\")=" + dictionary.remove("Rad"));
        System.out.println("dictionary.get(\"Rad\")=" + dictionary.get("Rad"));
        System.out.println("dictionary=" + dictionary);
        System.out.println("dictionary.size()=" + dictionary.size());
    }
}
