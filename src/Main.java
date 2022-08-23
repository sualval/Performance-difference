import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Map<String, Integer> collection;
    public static Map<String, Integer> concurrent;

    public static void main(String[] args) throws InterruptedException {
        collection = Collections.synchronizedMap(new HashMap<>());
        concurrent = new ConcurrentHashMap<>();
        mapTest(new Write(collection));
        mapTest(new Write(concurrent));
        mapTest(new Read(collection));
        mapTest(new Read(concurrent));

    }
    public static void mapTest(ReadWrite readWrite) throws InterruptedException {
        long resultTime ;
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executorService.execute((Runnable) readWrite);
        }
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        long stop = System.currentTimeMillis();
        resultTime = stop - start;

        System.out.printf("%s " + readWrite.getHashMap() + " = " + resultTime + "\n", readWrite.getClass().getName().equals("Read") ? "Read" : "Write");
    }


}
