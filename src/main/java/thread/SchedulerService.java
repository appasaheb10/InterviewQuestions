package thread;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerService {
    public void task() throws InterruptedException {
        System.out.println("Before");
        Thread.sleep(2000);
        System.out.println("After");
    }

    public static void main(String[] args) {
        SchedulerService schedulerService = new SchedulerService();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        service.schedule(() -> {
            try {
                schedulerService.task();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },5, TimeUnit.SECONDS);
    }
}
