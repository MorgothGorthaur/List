package arraylist;

import java.net.PortUnreachableException;
import java.util.Arrays;

public class CustomArrayList<V> {
    V[] elementData = (V[]) new Object[10];
    public int size = 0;

    public boolean add(V value) {
        updateElementDataLength();
        elementData[size++] = value;
        return true;
    }

    public void add(int index, V value) {
        updateElementDataLength();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = value;
        size++;
    }

    public V get(int index) {
        if (size > index) {
            return elementData[index];
        }
        return null;
    }

    public V set(int index, V value) {
        if (size > index) {
            elementData[index] = value;
            return elementData[index];
        }
        return null;
    }

    public V remove(int index) {
        if (size > index) {
            var val = elementData[index];
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
            size--;
            return val;
        }
        return null;
    }

    public boolean remove(V value) {
        var bool = false;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                System.arraycopy(elementData, i + 1, elementData, i, size - i);
                size--;
                bool = true;
            }
        }

        return bool;
    }

    public void clear() {
        elementData = (V[]) new Object[10];
        size = 0;
    }

    public boolean contains(V value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(V value) {
        for (var index = 0; index < size; index++) {
            if (elementData[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (elementData[0] != null) {
            return false;
        }
        return true;
    }

    public int lastIndexOf(V value) {
        var lastIndex = -1;
        for (var index = 0; index < size; index++) {
            if (elementData[index].equals(value)) {
                lastIndex = index;
            }
        }
        return lastIndex;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        if (fromIndex < toIndex && toIndex < size) {
            size = size - toIndex + fromIndex - 1;
            System.arraycopy(elementData, toIndex + 1, elementData, fromIndex, size);
        }
    }

    public Object[] toArray() {
        if (!isEmpty()) {
            var array = (V[]) new Object[size];
            System.arraycopy(elementData, 0, array, 0, size);
            return array;
        }
        return null;
    }

    public void trimToSize() {
        if(elementData[0] != null) {
            V[] tmp = elementData;
            elementData = (V[]) new Object[size];
            System.arraycopy(tmp, 0, elementData, 0, size);
        }
    }

    private void updateElementDataLength() {
        if (elementData.length <= size + 1) {
            V[] tmp = elementData;
            elementData = (V[]) new Object[elementData.length * 3 / 2 + 1];
            System.arraycopy(tmp, 0, elementData, 0, tmp.length);
        }
    }

    @Override
    public java.lang.String toString() {
        var str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size - 1; i++) {
            str.append(elementData[i].toString());
            str.append(", ");
        }
        str.append(elementData[size - 1].toString());
        str.append("]");
        return str.toString();
    }
}
