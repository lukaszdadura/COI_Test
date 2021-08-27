import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task8 {

    public static void main(String[] args) {

        String[] trees = {"brzoza", "modrzew", "grab", "buk", "wierzba"};
        List<String> treesAsList = Arrays.asList(trees);
        Iterator<String> iterator = treesAsList.iterator();

        System.out.printf("Wyświetlenie listy przy użyciu iteratora: %n");

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.printf("%n%nWyświetlenie listy przy użyciu strumienia: %n");

        Arrays.stream(trees).forEach(System.out::println);
    }
}
