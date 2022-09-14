package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    CustomLinkedList<String> lst = new CustomLinkedList<>();

    @Test
    void addShouldSetValue() {
        //when
        var res = lst.add("a");
        //then
        assertTrue(res);
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
        assertEquals(lst.toString(), "[a, b, c, d]");
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
        assertEquals(lst.toString(), "[a, b, c]");
    }
    @Test
    void addElementByIndex(){
        //given
        lst.add("a");
        lst.add("c");
        lst.add("d");
        //when
        lst.add(1,"b");
        //then
        assertEquals(lst.toString(), "[a, b, c, d]");
    }

   @Test
   void addAllToEmpty(){
        //given
        var list = new CustomLinkedList<String>();
        list.add("a");
        list.add("b");
        //when
        var res = lst.addAll(list);
        //then
        assertTrue(res);

    }
    @Test
    void addAllToNotEmpty(){
        //given
        lst.add("a");
        var list = new CustomLinkedList<String>();
        list.add("b");
        list.add("c");
        //when
        var res = lst.addAll(list);
        //then
        assertTrue(res);
        assertEquals(lst.toString(), "[a, b, c]");
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
    @Test
    void offerShouldAddValue(){
        //when
        var res = lst.offer("a");
        //then
        assertTrue(res);
        assertEquals(lst.toString(), "[a]");

    }
    @Test
    void  offerLast(){
        //when
        var res = lst.offerLast("a");
        //then
        assertTrue(res);
        assertEquals(lst.toString(), "[a]");
    }
    @Test
    void offerFirst(){
        //given
        lst.add("b");
        //when
        var res = lst.offerFirst("a");
        assertTrue(res);
        assertEquals(lst.toString(), "[a, b]");
    }

    @Test
    void poll(){
        //given
        lst.add("d");
        //when
        var res = lst.poll();
        //then
        assertEquals(res, "d");
        assertEquals(lst.toString(), "[]");
    }

    @Test
    void pollLast(){
        //given
        lst.add("d");
        //when
        var res = lst.pollLast();
        //then
        assertEquals(res, "d");
        assertEquals(lst.toString(), "[]");
    }

    @Test
    void removeByIndex(){
        //given
        lst.add("a");
        lst.add("b");
        lst.add("c");
        //when
        var res = lst.remove(1);
        //then
        assertEquals(res, "b");
        assertEquals(lst.toString(), "[a, c]");

    }

    @Test
    void removeByValue(){
        //given
        lst.add("a");
        lst.add("b");
        lst.add("c");
        //when
        var res = lst.remove("b");
        //then
        assertEquals(res, "b");
        assertEquals(lst.toString(), "[a, c]");

    }

}
