package sprint09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sprint09Task1 {
    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> reversedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }

    public class MyUtils {
        public String intToRoman(int number) {
            if ((number <= 0) || (number > 3999)) {
                throw new IllegalArgumentException(number + " is not in range (0,3999]");
            }

            List<RomanNumeral> romanNumerals = RomanNumeral.reversedValues();

            int i = 0;
            StringBuilder arabic = new StringBuilder();

            while ((number > 0) && (i < romanNumerals.size())) {
                RomanNumeral currentSymbol = romanNumerals.get(i);
                if (currentSymbol.getValue() <= number) {
                    arabic.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
                } else {
                    i++;
                }
            }

            return arabic.toString();
        }
    }
}
