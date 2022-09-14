package linkedlist;



public class CustomLinkedList<V> {
    Entry<V> first;
    Entry<V> last;
    public boolean add(V value){
        if(first == null){
            first = new Entry<>(value, last, null);
            last =first;
        } else {
            last = new Entry<>(value, null, last);
        }
        return true;
    }
    public V addLast(V value){
        add(value);
        return last.value;
    }
    public V addFirst(V value){
        first = new Entry<>(value, first, null);
        if(last == null){
            last = first;
        }
        return first.value;
    }
    public void clear(){
        first = null;
        last = null;
    }
    public boolean contains(V value){
        var elem = first;
        while (elem != null){
            if(elem.value.equals(value)){
                return true;
            }
            elem = elem.next;
        }
        return false;
    }
    public V element(){
        if(first != null){
            return first.value;
        }
        return null;
    }

    public V get(int index){
        var elem = first;
        var num = 0;
        while (elem != null && num <= index){
            if (num == index){
                return elem.value;
            }
            elem = elem.next;
            num ++;
        }
        return null;
    }
    public V getFirst(){
        if(first != null){
            return first.value;
        }
        return null;
    }
    public V getLast(){
        if(last != null){
            return last.value;
        }
        return null;
    }
    public int indexOf(V value){
        var elem = first;
        var num = 0;
        while (elem != null){
           if(elem.value.equals(value)){
               return num;
           }
           num ++;
           elem = elem.next;
        }
        return -1;
    }
    public int lastIndexOf(V value){
        var elem = first;
        var lastIndex = -1;
        var num = 0;
        while (elem != null){
            if(elem.value.equals(value)){
                lastIndex = num;
            }
            num ++;
            elem = elem.next;
        }
        return lastIndex;
    }
    
}
