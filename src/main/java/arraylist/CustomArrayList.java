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

    public void add(int key, V value) {
        updateElementDataLength();
        System.arraycopy(elementData, key, elementData, key + 1, size - key);
    }

    public V get(int key) {
        if (elementData.length >= key) {
            return elementData[key];
        }
        return null;
    }

    public V set(int key, V value) {
        if (elementData.length >= key && elementData[key] != null) {
            elementData[key] = value;
            return value;
        }
        return null;
    }

    public V remove(int key) {
        var val = elementData[key];
        System.arraycopy(elementData, key + 1, elementData, key, size - key);
        size--;
        return val;
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
    }

    public boolean contains(V value) {
        for (V elem : elementData) {
            if (elem.equals(value)) {
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
            return true;
        }
        return false;
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
        size = size - toIndex + fromIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex, size);

    }

    public V[] toArray() {
        return elementData;
    }

    public void trimToSize() {
        V[] tmp = elementData;
        elementData = (V[]) new Object[size];
        System.arraycopy(tmp, 0, elementData, 0, size);
    }

    private void updateElementDataLength() {
        if (elementData.length <= size + 1) {
            V[] tmp = elementData;
            elementData = (V[]) new Object[elementData.length * 3 / 2 + 1];
            System.arraycopy(tmp, 0, elementData, 0, tmp.length);
        }
    }

}
