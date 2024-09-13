import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class EventCounterPerformanceImprovement {

    private static class EventWindow {
        private final Deque<Long> events = new ArrayDeque<>();
        private final long interval;

        public EventWindow(long interval) {
            this.interval = interval;
        }

        public int update(long nanos) {
            events.addLast(nanos);
            while (!events.isEmpty() && events.peekFirst() < nanos - interval) {
                events.removeFirst();
            }
            return events.size();
        }
    }

    public static void main(String[] args) throws IOException {
        // Perform file operation once
        Path p = Paths.get("./a/b");
        if (!Files.exists(p)) {
            Files.createDirectories(p);
        }

        long start = System.nanoTime();
        int total = 100_000;
        long interval = TimeUnit.MILLISECONDS.toNanos(100);

        EventWindow eventWindow = new EventWindow(interval);
        long sum = 0;
        long lastNanos = start;

        for (int counter = 0; counter < total; counter++) {
            // Update time less frequently
            if (counter % 100 == 0) {
                lastNanos = System.nanoTime();
            }
            int count = eventWindow.update(lastNanos);
            sum += count;
        }

        long spent = System.nanoTime() - start;

        System.out.println("Average count: " + (int) (sum / (double) total) + " op");
        System.out.println("Spent time: " + TimeUnit.NANOSECONDS.toMillis(spent) + " ms");
    }
}

