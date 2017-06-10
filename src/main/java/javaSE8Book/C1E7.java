package javaSE8Book;

import org.junit.Test;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E7 {
    @Test
    public void runTwoRunnables() {
        new Thread(
                andThen(
                        () -> System.out.println("Zzz"),
                        () -> System.out.println("Yyy")
                )
        ).start();
    }


    private static Runnable andThen(Runnable r1, Runnable r2) {

        return () -> {
            r1.run();
            r2.run();
        };
    }

}
