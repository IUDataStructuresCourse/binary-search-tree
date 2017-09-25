import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentTest {
    BinarySearchTree<Integer> T;
    HashSet<Integer> H;
    int[] A = { 5, 2, 4, 1, 5, 9, 8 }, A_sorted = { 1, 2, 4, 5, 8, 9 };

    @Before
    public void setUp() {
        T = new BinarySearchTree<Integer>();
        H = new HashSet<Integer>();
    }
    @Test
    public void test_find() throws Exception {
        for (int i = 0; i != A.length; ++i) {
            T.insert(A[i]);
            H.add(A[i]);
        }
        for (Integer k : H) assertTrue(T.find(k));
        for (int k : A_sorted) assertTrue(T.find(k));
    }

    @Test
    public void test_remove() throws Exception {
        for (int i = 0; i != A.length; ++i) {
            T.insert(A[i]);
            H.add(A[i]);
        }
        for (int i = 0; i != A.length; ++i) {
            T.remove(A[i]);
            assert T.find(A[i]) == false;
        }
    }

    @Test
    public void test_kth_smallest_on_empty_tree() throws Exception {
        try {
            BinarySearchTree<Integer> T = new BinarySearchTree<>();
            T.kth_smallest(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void test_kth_smallest_on_tree_one_node() throws Exception
    {
        BinarySearchTree<Integer> T = new BinarySearchTree<>();
        T.insert(42);
        assertEquals(T.kth_smallest(0), new Integer(42));
    }

    @Test
    public void test_kth_smallest_on_tree_three_nodes() throws Exception
    {
        BinarySearchTree<Integer> T = new BinarySearchTree<>();
        T.insert(42);
        T.insert(21);
        T.insert(53);
        assertEquals(T.kth_smallest(0), new Integer(21));
        assertEquals(T.kth_smallest(1), new Integer(42));
        assertEquals(T.kth_smallest(2), new Integer(53));
    }

    @Test
    public void test_kth_smallest_on_tree_size_seven() throws Exception {
        for (int i = 0; i != A.length; ++i) {
            T.insert(A[i]);
            H.add(A[i]);
        }
        for (int i = 0; i != A_sorted.length; ++i) {
            int small = T.kth_smallest(i);
            assertEquals(small, A_sorted[i]);
        }
    }

}