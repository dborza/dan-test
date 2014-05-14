package com.dan.test.learn;

/**
 * Used to demo different implementations of a Set interface.
 *
 * Created by gborza on 14/05/2014.
 */
public class SetImpl {

    /**
     * Define a basic interface for defining methods for a set data structure.
     */
    static interface Set {

        /**
         * Add a new element to the set.
         */
        void add(Integer i);

        /**
         * Remove an element from the set.
         * @return {@code true} if element was found and removed, {@code false} otherwise.
         */
        boolean remove(Integer i);

        /**
         * Checks whether an element is being contained by the set.
         *
         * @return {@code true} in case of success, {@code false} otherwise.
         */
        boolean contains(Integer i);

        /**
         * Number of elements in the set.
         */
        int size();
    }

    /**
     * Our first implementation of the {@link Set} interface.
     */
    static class SetImpl1 implements Set {

        public void add(Integer i) {
            //  Provide implementation of method
        }

        public boolean remove(Integer i) {
            //  Provide implementation of method
            return false;
        }

        public boolean contains(Integer i) {
            //  Provide implementation of method
            return false;
        }

        public int size() {
            //  Provide implementation of method
            return -1;
        }
    }

    /**
     * Simple test scenario for our implementation.
     */
    public static void main (final String [] args) {

        final Set set1 = new SetImpl1();

        set1.add(1);
        set1.add(2);
        assert set1.contains(1);
        assert set1.contains(2);
        assert set1.size() == 2;
        set1.remove(1);
        assert ! set1.contains(1);
        assert set1.size() == 1;

    }

}
