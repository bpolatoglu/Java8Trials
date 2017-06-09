package javaSE8Book;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;

import static junit.framework.Assert.assertEquals;

/**
 * Created by bpolatoglu on 09/06/2017.
 */
public class C1E1 {

    @Test
    public void testArraySort() {

        final long mainThreadId = Thread.currentThread().getId();

        String[] strArr = {"ahmet", "mehmet", "fikret", "saffet", "erdem", "adem"};
        CopyOnWriteArraySet<Long> threadIds  = new CopyOnWriteArraySet<>();

        //Normal sort
        Arrays.sort(strArr,(first, second)->{
            final long innerThreadId = Thread.currentThread().getId();
            threadIds.add(innerThreadId);
            return first.compareTo(second);
        });

        assertEquals(1,threadIds.size());
        assertEquals(mainThreadId,threadIds.toArray()[0]);

        threadIds.clear();

        Arrays.parallelSort(strArr,(first, second)->{
            final Long innerThreadId = Thread.currentThread().getId();
            threadIds.add(innerThreadId);
            return first.compareTo(second);
        });

        assertEquals(mainThreadId,threadIds.toArray()[0]);

    }

}
