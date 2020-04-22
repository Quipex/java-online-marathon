package sprint07;

import org.junit.jupiter.api.Test;

class NameListTest {

    @Test
    public void test() {
        Sprint07Task2.NameList list = new Sprint07Task2.NameList();
        Sprint07Task2.NameList.Iterator iterator = list.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
