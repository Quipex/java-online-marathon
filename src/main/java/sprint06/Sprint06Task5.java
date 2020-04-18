package sprint06;

import java.util.*;
import java.util.stream.Collectors;

public class Sprint06Task5 {
    /*
    Create interface DrinkReceipt with methods String getName() and
    DrinkReceipt addComponent(String componentName, int componentCount).

    Create interface DrinkPreparation with method Map<String, Integer> makeDrink() to return a
    drink components.

    Create interface Rating with method int getRating().

    Class Caffee contains fields String name, int rating,
    Map of ingredients and implements interfaces DrinkReceipt,
    DrinkPreparation and Rating.

    Method makeDrink() prepare coffee with typically components: {Water=100, Arabica=20}.

    Espresso and Cappuccino classes extends the Caffee Class and override method makeDrink().
    Espresso caffee has 50 g. of Water. Cappuccino caffee has an additional of 50 g. of Milk.
    Create a averageRating() method of the MyUtils class to return a Map with coffee name as key
    and coffee average rating as value.

    For example, for a given list
    [Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
    Espresso [name=Espresso, rating=10],
    Cappuccino [name=Cappuccino, rating=6], Caffee [name=Caffee, rating=6]]
    you should get
    {Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
     */

    interface DrinkReceipt {
        String getName();

        DrinkReceipt addComponent(String componentName, int componentCount);
    }

    interface DrinkPreparation {
        /**
         * @return drink components
         */
        Map<String, Integer> makeDrink();
    }

    interface Rating {
        int getRating();
    }

    static class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
        private String name;
        private int rating;
        private Map<String, Integer> ingredients;

        public Caffee() {
            ingredients = new HashMap<>();
            ingredients.put("Water", 100);
            ingredients.put("Arabica", 20);
        }

        public Caffee(String name, int rating) {
            this();
            this.name = name;
            this.rating = rating;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public Map<String, Integer> getIngredients() {
            return ingredients;
        }

        public void setIngredients(Map<String, Integer> ingredients) {
            this.ingredients = ingredients;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public DrinkReceipt addComponent(String componentName, int componentCount) {
            ingredients.merge(componentName, componentCount, Integer::sum);
            return this;
        }

        @Override
        public Map<String, Integer> makeDrink() {
            return ingredients;
        }

        @Override
        public int getRating() {
            return rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Caffee caffee = (Caffee) o;
            return rating == caffee.rating &&
                    Objects.equals(name, caffee.name) &&
                    Objects.equals(ingredients, caffee.ingredients);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating, ingredients);
        }
    }

    static class Espresso extends Caffee {

        public Espresso() {
            super();
            getIngredients().put("Water", 50);
        }

        public Espresso(String name, int rating) {
            super(name, rating);
        }

        @Override
        public Map<String, Integer> makeDrink() {
            return super.makeDrink();
        }
    }

    static class Cappuccino extends Caffee {

        public Cappuccino() {
            super();
            getIngredients().put("Milk", 50);
        }

        public Cappuccino(String name, int rating) {
            super(name, rating);
        }

        @Override
        public Map<String, Integer> makeDrink() {
            return super.makeDrink();
        }
    }

    static public class MyUtils {
        public static Map<String, Double> averageRating(List<Caffee> coffees) {
            List<Caffee> filteredCoffees = coffees.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            if (filteredCoffees.isEmpty()) {
                return new HashMap<>();
            }
            Map<String, IntSummaryStatistics> coffeeToMovingAverage = new HashMap<>();
            for (Caffee filteredCoffee : filteredCoffees) {
                IntSummaryStatistics movingAverage = coffeeToMovingAverage
                        .getOrDefault(filteredCoffee.getName(), new IntSummaryStatistics());
                movingAverage.accept(filteredCoffee.getRating());
                coffeeToMovingAverage.put(filteredCoffee.getName(), movingAverage);
            }
            return coffeeToMovingAverage.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, map -> map.getValue().getAverage()));
        }
    }
}
