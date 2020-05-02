package sprint10;

import java.awt.*;

public class Sprint10Task3 {
    public class Wrapper<T extends Shape> {
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
