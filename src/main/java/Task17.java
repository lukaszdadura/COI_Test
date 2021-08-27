import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Task17 {

    public static void main(String[] args) {

        List<String> peselNumbers = Arrays.asList("01231344837", "02231244837", "03282844837", "46031244837", "90010711494");

        peselNumbers.stream()
                .forEach(Task17::verifyAge);

    }

    public static void verifyAge(String pesel) {

        LocalDate today = LocalDate.now();
        int comparedValue = today.minusYears(18).compareTo(getDateOfBirth(pesel));

        if (comparedValue < 0) {
            System.out.printf("Osoba z numerem PESEL: %s urodzona %s w dniu dzisiejszym jest pełnoletnia - %s%n", pesel, getDateOfBirth(pesel), false);
        } else {
            System.out.printf("Osoba z numerem PESEL: %s urodzona %s w dniu dzisiejszym jest pełnoletnia - %s%n", pesel, getDateOfBirth(pesel), true);
        }
    }

    public static LocalDate getDateOfBirth(String pesel) {

        LocalDate dateOfBirth;

        if (pesel.length() != 11) {
            throw new IllegalArgumentException("Niepoprawna wartość PESEL");
        } else {
            String yearOfBirth = pesel.substring(0, 2);
            String monthOfBirth = pesel.substring(2, 4);
            String dayOfBirth = pesel.substring(4, 6);

            try {
                int parsedYearOfBirth = Integer.parseInt(yearOfBirth);
                int parsedMonthOfBirth;

                if (parsedYearOfBirth <= 21 && parsedYearOfBirth >= 0) {
                    parsedMonthOfBirth = Integer.parseInt(monthOfBirth) - 20;
                } else {
                    parsedMonthOfBirth = Integer.parseInt(monthOfBirth);
                }

                int parsedDayOfBirth = Integer.parseInt(dayOfBirth);

                if (parsedYearOfBirth <= 21 && parsedYearOfBirth >= 0) {
                    parsedYearOfBirth += 2000;
                } else {
                    parsedYearOfBirth += 1900;
                }

                dateOfBirth = LocalDate.of(parsedYearOfBirth, parsedMonthOfBirth, parsedDayOfBirth);

                return dateOfBirth;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Niepoprawne dane, nie udało się zamienić na liczbę");
            }
        }
        return null;
    }
}
