package arraylist;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    CustomArrayList<String> list = new CustomArrayList<>();

    @Test
    void addShouldReturnTrue() {
        //when
        var res = list.add("d");
        //then
        assertTrue(res);
    }

    @Test
    void addWithKeyShouldSetValueByIndexPosition() {
        //given
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");
        //when
        list.add(4, "e");
        //then
        assertEquals("[a, b, c, d, e, f]", list.toString());
    }

    @Test
    void containsShouldReturnFalse_ifNotFound() {
        //when
        var res = list.contains("d");
        //then
        assertFalse(res);
    }

    @Test
    void containsShouldReturnTrue_ifNotFound() {
        //given
        list.add("d");
        //when
        var res = list.contains("d");
        //then
        assertTrue(res);
    }

    @Test
    void setShouldReturnNull_ifNotFound() {
        //when
        var res = list.set(1, "d");
        //given
        assertNull(res);
    }

    @Test
    void setShouldReturnValueAndReplaceOldValFromPosition_ifFound() {
        //given
        list.add("a");
        //when
        var res = list.set(0, "d");
        //then
        assertEquals(res, "d");
        assertEquals(list.toString(), "[d]");

    }

    @Test
    void removeByKeyShouldReturnNull_ifNotFound() {
        //when
        var res = list.remove(3);
        //then
        assertNull(res);
    }

    @Test
    void removeByKeyShouldReturnValue_ifFound() {
        //given
        list.add("d");
        //when
        var res = list.remove(0);
        //then
        assertEquals(res, "d");
    }

    @Test
    void removeByValueShouldReturnFalse_ifNotFound() {
        //when
        var res = list.remove("d");
        //then
        assertFalse(res);
    }

    @Test
    void removeByValueShouldReturnTrue_ifFound() {
        //given
        list.add("d");
        //when
        var res = list.remove("d");
        //then
        assertTrue(res);
    }

    @Test
    void clearShouldDecreaseSizeToZero() {
        //given
        list.add("d");
        //when
        list.clear();
        //then
        assertEquals(list.size, 0);
    }

    @Test
    void indexOfShouldReturnMinusOne_ifNotFound() {
        //when
        var res = list.indexOf("d");
        //then
        assertEquals(res, -1);
    }

    @Test
    void indexOfShouldReturnIndex_ifFound() {
        //given
        list.add("d");
        //when
        var res = list.indexOf("d");
        //then
        assertEquals(res, 0);
    }

    @Test
    void isEmptyShouldReturnTrue_ifEmpty() {
        //when
        var res = list.isEmpty();
        //then
        assertTrue(res);
    }

    @Test
    void isEmptyShouldReturnFalse_ifNotEmpty() {
        //given
        list.add("D");
        //when
        var res = list.isEmpty();
        //then
        assertFalse(res);
    }

    @Test
    void lastIndexOfShouldReturnMinusOne_ifNotFound() {
        //when
        var res = list.lastIndexOf("d");
        //then
        assertEquals(res, -1);
    }

    @Test
    void lastIndexOfShouldReturnLastIndex_ifFound() {
        //given
        list.add("a");
        list.add("b");
        list.add("a");
        //when
        var res = list.lastIndexOf("a");
        //then
        assertEquals(res, 2);
    }

    @Test
    void removeRangeShouldRemovesValuesFromFirstKeyToLastKey() {
        //given
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        //when
        list.removeRange(1, 3);
        //then
        assertEquals(list.toString(), "[a, e]");
    }

    @Test
    void toArrayShouldReturnNull_ifListIsEmpty() {
        //when
        var res = list.toArray();
        //given
        assertNull(res);
    }

    @Test
    void toArrayShouldReturnArrayOfValues_ifNotEmpty() {
        //given
        list.add("a");
        list.add("b");
        list.add("c");
        //when
        var res = list.toArray();
        //given
        assertEquals(res.length, 3);
    }

}
