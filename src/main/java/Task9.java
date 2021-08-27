import java.util.Arrays;

public class Task9 {

    public static void main(String[] args) {
        String karta = "karta";
        String krata = "krata";
        String tarka = "TaRkA";
        String test = null;

        isAnagram(karta, krata);
        isAnagram(krata, tarka);
        isAnagram(karta, "");
//        isAnagram(krata, test);
        isAnagram("kij", "szczotka");

    }

    public static void isAnagram(String first, String second) {

        boolean flag = true;

        if (first == null || second == null) {
            throw new IllegalArgumentException("Niepoprawne dane wejściowe");
        } else if (first.length() != second.length()) {
            System.out.printf("Wyrazy mają różną długość, nie mogą być anagramem%n%n");
        } else {
            char[] firstArray = first.toLowerCase().toCharArray();
            Arrays.sort(firstArray);
            char[] secondArray = second.toLowerCase().toCharArray();
            Arrays.sort(secondArray);

            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] != secondArray[i]) {
                    flag = false;
                }
            }

            System.out.printf("Słowa: %s i %s są anagramem - %s%n%n", first, second, flag);

        }
    }
}
