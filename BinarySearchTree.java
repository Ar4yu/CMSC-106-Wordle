public interface BinarySearchTree<E extends Comparable<E> > {
    void insert(E element);
    E getRootElement();
    int size();
    boolean isEmpty();

    String toStringInOrder();
    String toStringPreOrder();
    String toStringPostOrder();
}
