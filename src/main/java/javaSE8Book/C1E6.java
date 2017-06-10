package javaSE8Book;

import org.junit.Test;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E6 {
    @Test
    public void catchCheckedExceptions() {
        new Thread(
                uncheck(
                        () -> {
                            System.out.println("Zzz");
                            Thread.sleep(1000);
                        }
                )
        ).start();
    }

    @FunctionalInterface
    interface RunnableEx {
        void run() throws Exception;
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception ex) {
                System.out.println("ex = " + ex);
            }
        };
    }
}
