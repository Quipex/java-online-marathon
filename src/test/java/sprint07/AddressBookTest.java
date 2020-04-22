package sprint07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    @Test
    public void testCreate() {
        AddressBook addressBook = new AddressBook(4);
        addressBook.create("aloha", "tovarish", "asd");
        addressBook.create("kuku", "lolz", "qwe");
        addressBook.create("qwe", "mome", "we123");
        boolean b = addressBook.create("qwe", "mome", "we123");
        assertFalse(b);
        addressBook.create("newM", "qwe3", "qwec");
        addressBook.create("newM1", "qwe3", "qwec");
    }
}
