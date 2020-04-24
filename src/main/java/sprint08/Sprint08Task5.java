package sprint08;

import java.util.Set;
import java.util.function.Predicate;

public class Sprint08Task5 {
    static class MyUtils {
        public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
            return predicates.stream()
                    .reduce(Predicate::and).orElseThrow(IllegalArgumentException::new);
        }
    }

}
