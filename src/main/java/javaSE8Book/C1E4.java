package javaSE8Book;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E4 {

    @Test
    public void listSortedFiles() {
        File[] fileArr = sort("C://");
        Arrays.asList(fileArr).forEach(System.out::println);
    }

    private File[] sort(String directory) {
        File[] fileArr = new File("C://").listFiles();
        Arrays.sort(fileArr, (first, second) -> {
            if (first.isDirectory() && !second.isDirectory())
                return -1;
            else if (!first.isDirectory() && second.isDirectory())
                return 1;
            else
                return first.getName().compareToIgnoreCase(second.getName());
        });

        return fileArr;

    }
}
