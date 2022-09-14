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
    public void add(int index, V value){
        var elem = first;
        var num = 0;
        while (elem != null){
            if(num == index){
                var set = new Entry<V>(value, elem, elem.last);
                elem = last;
            }
            num ++;
            elem = elem.next;
        }
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
    public boolean addAll(CustomLinkedList <V> lst){
        if(last != null) {
            last.next = lst.first;
            lst.first.last = last;
        } else {
            first = lst.first;
            last = lst.last;
        }
        return true;
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

    public boolean offer(V value){
        return add(value);
    }
    public boolean offerLast(V value){
        return add(value);
    }
    public boolean offerFirst(V value){
        addFirst(value);
        return true;
    }

    public V peek(){

        return getFirst();
    }
    public V peekFirst(){
        return getFirst();
    }
    public V peekLast(){
        return getLast();
    }
    public V poll(){
        if(first != null){
            var value = first.value;
            if(first.next == null){
                last = null;
            }
            first = first.next;
            return value;
        }
        return null;
    }
    public V poolFirst(){
        return poll();
    }

    public V pollLast(){
        if(last != null){
            var value = last.value;
            if(last.last == null){
                first = null;
            }
            last = last.last;
            return value;
        }
        return null;
    }
    public V pop(){
        return poll();
    }
    public void push(V value){
        addFirst(value);
    }
    public V remove(){
        return poll();
    }
    public V removeFirst(){
        return poll();
    }
    public V removeLast(){
        return pollLast();
    }
    public V remove(int index){
        var num = 0;
        var elem  = first;
        while (elem != null){
            if(num == index){
                var lastElem = elem.last;
                var nextElem = elem.next;
                lastElem.next = nextElem;
                nextElem.last = lastElem;
                return elem.value;
            }
            num ++;
            elem = elem.next;
        }
        return null;
    }

    public V remove(V value){
        var elem = first;
        while (elem != null){
            if(elem.value.equals(value)){
                var lastElem = elem.last;
                var nextElem = elem.next;
                lastElem.next = nextElem;
                nextElem.last = lastElem;
                return elem.value;
            }
            elem = elem.next;
        }
        return null;
    }
    @Override
    public String toString(){
        var str = new StringBuilder();
        var elem = first;
        str.append("[");
        while (elem != null){
            str.append(elem.value.toString());
            if(elem.next != null) {
                str.append(", ");
            }
            elem = elem.next;
        }
        str.append("]");
        return str.toString();
    }

}
