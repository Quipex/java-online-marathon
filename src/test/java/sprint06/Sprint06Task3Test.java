package sprint06;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class Sprint06Task3Test {
    @Test
    public void test() {
        for (Method method : Sprint06Task3.Square.class.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }

}
