package thread.coding;



public class ThreadInSequence {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("start 1");
                System.out.println("end 1");
            }//run
        });

        final Thread t2  = new Thread(new Runnable() {
            public void run() {
                System.out.println(" start 2 ");
                try {
                    t1.join(2000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
                System.out.println(" end 2");
            }
        }) ;

        final Thread t3 = new Thread( new Runnable() {
            public void run() {
                System.out.println(" start 3 ");

                try {
                    t2.join(4000);
                }catch(Exception e) {
                    e.getStackTrace();
                }
                System.out.println(" end  3 ");
            }
        });
        // we are reversing the order of the start() method

        t3.start();
        t2.start();
        t1.start();


    }
}