import core.Game;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import static core.Game.printReport;

public class CapacityTest {
    private final long spins = 10000;
    private static int counter=0;


    @Test
    public void capacityTest() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);  // Using 10 threads for example

        // AtomicInteger to safely accumulate the results from multiple threads
        AtomicInteger totalSum = new AtomicInteger(0);

        List<Future<Void>> futures = new ArrayList<>();

        for (int i = 0; i < spins; i++) {
            Game game = new Game();
            //counter++;
            //System.out.println("Instances: " + counter);
            futures.add(executor.submit(() -> {
                int result = game.run();
                totalSum.addAndGet(result);
                return null;
            }));
        }

        // Wait for all tasks to finish
        for (Future<Void> future : futures) {
            future.get();
        }

        executor.shutdown();

        int resInt = totalSum.get();
        double resDouble = resInt;
        System.out.println("RTP: " + (resDouble/(spins*10))*100);

        printReport();

    }


}
