package ru.innolearn.day02.comparables;

/**
 * Created by marina on 06.12.2016.
 */
class A implements Comparable<A> {
    int x;

    @Override
    public int compareTo(A o) {
        return x - o.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return x == a.x;
    }

    @Override
    public int hashCode() {
        return x;
    }
}
