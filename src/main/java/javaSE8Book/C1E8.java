package javaSE8Book;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E8 {

    @Test
    public void exercise8() {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));

        for (Runnable runner:runners) {
           new Thread(runner).start();
        }

        runners.clear();

        for (int i = 0; i <names.length ; i++) {
            // runners.add(()->System.out.println(names[i]));
            String name = names[i];
            runners.add(()->System.out.println(name));
        }

        for (Runnable runner:runners) {
            new Thread(runner).start();
        }

    }
}
