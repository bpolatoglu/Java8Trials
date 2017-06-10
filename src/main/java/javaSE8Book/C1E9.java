package javaSE8Book;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static junit.framework.Assert.assertEquals;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E9 {
    @Test
    public void exercise9() {

        Collection2<String>  list = new ArrayList2<>();

        list.add("Birkan");
        list.add("Polatoglu");

        CopyOnWriteArraySet<String> neWList = new CopyOnWriteArraySet<>();

        list.forEachIf(neWList::add, c->c.startsWith("P"));

        assertEquals(1,neWList.size());
        assertEquals("Polatoglu", neWList.toArray()[0]);
    }

    interface Collection2<T> extends Collection<T>{
        default void forEachIf(Consumer<T> action, Predicate<T> filter){
            forEach(e -> {
                if(filter.test(e))
                    action.accept(e);
            });
        }
    }

    class ArrayList2<T> extends ArrayList<T> implements Collection2<T>{}

}
