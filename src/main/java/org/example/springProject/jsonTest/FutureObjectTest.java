package org.example.springProject.jsonTest;
import java.util.concurrent.*;

public class FutureObjectTest {

        private static int counter = 0;
        public static void main(String[] unused) throws Exception {
            ExecutorService service = null;
            try {
                service = Executors.newSingleThreadExecutor();
                Future<?> result = service.submit(() -> {
                    for(int i = 0; i < 500; i++) FutureObjectTest.counter++;
                });
                result.get(10, TimeUnit.SECONDS);
                System.out.println("Reached!");
            } catch (TimeoutException e) {
                System.out.println("Not reached in time");
            } finally {
                if(service != null) service.shutdown();
            }
        }
}
