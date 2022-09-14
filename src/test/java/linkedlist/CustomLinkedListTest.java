package linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    CustomLinkedList<String> lst = new CustomLinkedList<>();

    @Test
    void addShouldSetValue() {
        //when

    }

    @Test
    void addLastShouldAddElementToEndOnList() {
        //given
        lst.add("a");
        lst.add("b");
        lst.add("c");
        //when
        var res = lst.addLast("d");
        //then
        assertEquals(res, lst.getLast());
    }

    @Test
    void addFirstShouldAddElementToFirstElementOnList() {
        //given
        lst.add("b");
        lst.add("c");
        //when
        var res = lst.addFirst("a");
        //then
        assertEquals(res, lst.getFirst());
    }

    @Test
    void indexOfReturnMinusOne_ifEmpty_ifNotFound() {
        //when
        var res = lst.indexOf("b");
        //then
        assertEquals(res, -1);
    }

    @Test
    void indexOfReturnFirstIndexOfElement_ifNotEmpty_ifFound() {
        //given
        lst.add("a");
        lst.add("b");
        //when
        var res = lst.indexOf("b");
        //then
        assertEquals(res, 1);
    }

    @Test
    void lastIndexOfReturnMinusOne_ifEmpty_ifNotFound(){
        //when
        var res = lst.lastIndexOf("a");
        //then
        assertEquals(res, -1);
    }

    @Test
    void lastIndexOfReturnLastIndexOfElement_ifNotEmpty_ifFound(){
        //given
        lst.add("a");
        lst.add("b");
        lst.add("c");
        //when
        var res = lst.lastIndexOf("c");
        //then
        assertEquals(res, 2);
    }

    @Test
    void containsReturnFalse_ifNotFound(){
        //when
        var res = lst.contains("a");
        //then
        assertFalse(res);
    }

    @Test
    void containsReturnTrue_ifFound(){
        //given
        lst.add("a");
        lst.add("b");
        lst.add("c");
        //when
        var res = lst.contains("c");
        //then
        assertTrue(res);
    }

}
