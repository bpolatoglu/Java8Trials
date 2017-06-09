package java8;

import java.util.function.Function;

/**
 * Created by bpolatoglu on 29/05/2017.
 */
public class MainComparator {

    public static void main(String[] args) {
        Comparator<Person> cmpAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2) -> p2.getLastName().compareTo(p1.getLastName());

        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p -> p.getFirstName();
        Function<Person, String> f3 = p -> p.getLastName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonFirstName = Comparator.comparing(Person::getFirstName);

        Comparator<Person> cmp = cmpPersonAge.thenComparing(cmpFirstName);

        Comparator<Person> cmp2 = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getAge);
    }
}
