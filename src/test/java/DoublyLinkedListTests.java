import DoublyLinkedList.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTests {

    @Test
    public void ensureProperOrder() {
        var list = new DoublyLinkedList<String, String>();

        list.addNode("1", "1");
        assertEquals(list.getTail().getKey(),"1");
        assertEquals(list.getHead().getKey(),"1");

        list.addNode("2", "2");
        assertEquals(list.getTail().getKey(),"1");
        assertEquals(list.getHead().getKey(),"2");

        list.addNode("3", "3");
        assertEquals(list.getTail().getKey(),"1");
        assertEquals(list.getHead().getKey(),"3");
    }
}
