package linkedlist;

import lombok.AllArgsConstructor;


public class Entry<V> {
    V value;
    Entry<V> next;
    Entry<V> last;
    public Entry(V value, Entry<V> next, Entry<V> last){
        this.value = value;
        this.next = next;
        this.last = last;
        if(next != null){
            next.last = this;
        }
        if(last != null){
            last.next = this;
        }

    }
}
