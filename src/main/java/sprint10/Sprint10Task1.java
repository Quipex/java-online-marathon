package sprint10;

public class Sprint10Task1 {
    public class Wrapper<T> {
        private T value;
        public Wrapper(T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }
}
