package sprint07;

public class Sprint07Task2 {
    public static class NameList {
        private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

        public Iterator getIterator() {
            return new Iterator();
        }

        public class Iterator {
            private int counter = 0;

            private Iterator() {
            }

            public boolean hasNext() {
                return counter < names.length;
            }

            public String next() {
                return names[counter++];
            }
        }
    }
}
