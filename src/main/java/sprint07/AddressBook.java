package sprint07;

import java.util.*;


@SuppressWarnings("unchecked")
public class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        String recording = read(firstName, lastName);
        if (recording != null) {
            return false;
        }
        if (counter + 1 > addressBook.length) {
            increaseCapacity();
        }
        addressBook[counter++] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
        return true;
    }

    public String read(String firstName, String lastName) {
        return find(firstName, lastName)
                .map(pair -> pair.address)
                .orElse(null);
    }

    public boolean update(String firstName, String lastName, String address) {
        Optional<NameAddressPair> foundPair = find(firstName, lastName);
        if (foundPair.isPresent()) {
            foundPair.get().address = address;
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String firstName, String lastName) {
        int index = indexOf(firstName, lastName);
        if (index >= 0) {
            int numMoved = counter - index - 1;
            if (numMoved > 0) {
                System.arraycopy(addressBook, index + 1, addressBook, index, numMoved);
            }
            addressBook[--counter] = null;
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return counter;
    }

    private Optional<NameAddressPair> find(String firstName, String lastName) {
        int index = indexOf(firstName, lastName);
        if (index >= 0) {
            return Optional.of(addressBook[index]);
        }
        return Optional.empty();
    }

    /**
     * @return index of the element in the backed array, if no element found returns -1;
     */
    private int indexOf(String firstName, String lastName) {
        for (int index = 0; index < size(); index++) {
            NameAddressPair pair = addressBook[index];
            if (pair.person.firstName.equals(firstName) && pair.person.lastName.equals(lastName)) {
                return index;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        int arrayLength = addressBook.length == 0 ? 1 : addressBook.length;
        addressBook = Arrays.copyOf(addressBook, arrayLength * 2);
    }

    public void sortedBy(SortOrder order) {
        Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair thisPair, NameAddressPair thatPair) {
                switch (order) {
                    case ASC:
                        return thisPair.person.compareTo(thatPair.person);
                    case DESC:
                        return thatPair.person.compareTo(thisPair.person);
                    default:
                        throw new IllegalArgumentException("Unknown order: " + order.name());
                }
            }
        });
    }

    @Override
    public Iterator<NameAddressPair> iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator {
        private int counter;

        public boolean hasNext() {
            return counter < size();
        }

        public String next() {
            NameAddressPair pair = addressBook[counter++];
            return pair == null ? null : pair.toString();
        }
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public String toString() {
            return "First name: " + person.firstName + ", Last name: " + person.lastName + ", Address: " + address;
        }

        private static class Person implements Comparable<Person> {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

            @Override
            public int compareTo(Person that) {
                int fNameComparison = this.firstName.compareTo(that.firstName);
                return fNameComparison == 0 ? this.lastName.compareTo(that.lastName) : fNameComparison;
            }
        }
    }
}

enum SortOrder {
    ASC,
    DESC
}
