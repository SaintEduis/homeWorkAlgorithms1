package org.example;

import org.example.exceptions.BadIndexException;
import org.example.exceptions.BadItemException;

public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;

    public StringListImpl() {
        this.stringList = new String[0];
        this.size = 0;
    }

    public StringListImpl(String[] stringList) {
        this.stringList = stringList;
        this.size = stringList.length;
    }

    @Override
    public String add(String item) {
        if (item != null) {
            String[] temporaryList = stringList;
            stringList = new String[size + 1];
            size++;
            System.arraycopy(temporaryList, 0, stringList, 0, size - 1);
            stringList[size - 1] = item;
            return item;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String add(int index, String item) {
        if (item != null) {
            if (index < size && index >= 0) {
                String[] temporaryList = stringList;
                stringList = new String[size + 1];
                size++;
                System.arraycopy(temporaryList, 0, stringList, 0, index);
                System.arraycopy(temporaryList, index, stringList, index + 1, size - index - 1);
                stringList[index] = item;
                return item;
            } else {
                throw new BadIndexException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String set(int index, String item) {
        if (item != null) {
            if (index < size && index >= 0) {
                stringList[index] = item;
                return item;
            } else {
                throw new BadIndexException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String remove(String item) {
        if (item != null) {
            for (int i = 0; i < size; i++) {
                if (stringList[i].equals(item)) {
                    String[] temporaryList = stringList;
                    stringList = new String[size - 1];
                    size--;
                    System.arraycopy(temporaryList, 0, stringList, 0, i);
                    System.arraycopy(temporaryList, i + 1, stringList, i, size - i);
                    return item;
                }
            }
            throw new BadItemException();
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String remove(int index) {
        if (index < size && index >= 0) {
            String result = stringList[index];
            String[] temporaryList = stringList;
            stringList = new String[size - 1];
            size--;
            System.arraycopy(temporaryList, 0, stringList, 0, index);
            System.arraycopy(temporaryList, index + 1, stringList, index, size - index);
            return result;
        } else {
            throw new BadIndexException();
        }
    }

    @Override
    public boolean contains(String item) {
        if (item != null) {
            for (int i = 0; i < size; i++) {
                if (stringList[i].equals(item)) {
                    return true;
                }
            }
            return false;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public int indexOf(String item) {
        if (item != null) {
            for (int i = 0; i < size; i++) {
                if (stringList[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public int lastIndexOf(String item) {
        if (item != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (stringList[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String get(int index) {
        if (index < size && index >= 0) {
            return stringList[index];
        } else {
            throw new BadIndexException();
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList != null) {
            if (size != otherList.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(stringList[i].equals(otherList.toArray()[i]))) {
                    return false;
                }
            }
            return true;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        stringList = new String[0];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return stringList;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += stringList[i].hashCode();
        }
        return result + size;
    }
}
