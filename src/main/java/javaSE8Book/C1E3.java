package javaSE8Book;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E3 {

    @Test
    public void listFiles() {

        Arrays.asList(listFilesWithSpecificExtension("C://","txt")).forEach(System.out::println);
    }

    private File[] listFilesWithSpecificExtension(String directory, String extension){
        return new File(directory).listFiles(f->f.getName().toLowerCase().endsWith(extension));
    }
}
