package thread;

public class DifferentWayOfThreadCreation {

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Runnable Thread");
         new Thread(r1).start();

         new Thread(() -> System.out.println("Thread")).start();

    }
}
