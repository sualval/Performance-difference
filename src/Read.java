import java.util.Map;

public class Read implements Runnable, ReadWrite {
    private Map<String, Integer> hashMap;

    public Read(Map<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public String getHashMap() {
        return hashMap.getClass().getName();

    }

    @Override
    public void run() {
        for (int i = 0; i < hashMap.size(); i++) {
            hashMap.get(String.valueOf(i));
        }
    }
}
