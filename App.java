import java.util.List;

public class App {
    public static void main(String[] args) {
        ChainHashMap dic = new ChainHashMap();
        dic.put("key", "value");
        dic.put("key2", "value2");
        dic.put("key3", "value3");

        System.out.println(dic);
    }
}
