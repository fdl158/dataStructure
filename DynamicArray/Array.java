package cn.delingw.DynamicArray;

/**
 * @author delingw
 * @version 1.0
 * 封装一个动态数组
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 指定数组容量
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    // 默认数组容量为10
    public Array() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素数量
    public int getSize() {
        return size;
    }

    //  返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {
        // 索引位置小于0 或者 大于数组中的元素 则抛出异常
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        //扩容
        if (size == data.length) {
            resize(data.length * 2);
        }
        // 添加
        for (int i = size - 1; i >= index; i--) {
            // 所有数据往后边移
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //在所有元素前面添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在末尾添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获取index索引的元素
    public E get(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
    // 获取数值中最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 获取数组中第一个元素
    public E getFirst(){
        return get(0);
    }

    // 修改index索引位置的元素
    public void set(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引,不存在返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素,返回删除的元素
    public E remove(int index) {
        // >= 是因为 size是表示即将要存放数据的位置,是null的
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        // 删除
        E delE = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //删除到了一定程度容量也减,防止(均摊)复杂度动荡,当元素删除到1/4时, 就把容量减半
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        return delE;
    }

    // 删除数组中第一个元素,返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除数组中最后一个元素,返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除数组中指定元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 扩容数组  newCapacity大小
    public void resize(int newCapacity) {
        E[] new_arr = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            new_arr[i] = data[i];
        }
        data = new_arr;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("Array: size=%d , capacity=%s\n", size, data.length));
        buf.append('[');
        for (int i = 0; i < size; i++) {
            buf.append(data[i]);
            if (i != size - 1) {
                buf.append(',');
            }
        }
        buf.append(']');
        return buf.toString();
    }

}
