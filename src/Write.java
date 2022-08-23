import java.util.Map;

public class Write implements Runnable, ReadWrite {
    private Map<String, Integer> hashMap;

    public Write(Map<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public String getHashMap() {
        return hashMap.getClass().getName();
    }

    @Override
    public void run() {
        for (int i = 0; i < 970000; i++) {
            Integer randomValue = (int) (Math.random() * 550000);
            hashMap.put(String.valueOf(randomValue), randomValue);
        }
    }
}
