package javaSE8Book;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Created by bpolatoglu on 10/06/2017.
 */
public class C1E2 {

    @Test
    public void listDirectories() {

        Arrays.asList(listDirectoriesWithLambda(".")).forEach(System.out::println);
        System.out.println("\n");
        Arrays.asList(listDirectoriesWithMethodReference(".")).forEach(System.out::println);
    }


    private File[] listDirectoriesWithLambda(String directory){
        return new File(directory).listFiles(d -> d.isDirectory());
    }

    private File[] listDirectoriesWithMethodReference(String directory){
        return new File(directory).listFiles(File::isDirectory);
    }
}
