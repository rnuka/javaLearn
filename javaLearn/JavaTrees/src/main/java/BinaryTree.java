/**
 * Created by rnuka on 11/5/16.
 */
public interface BinaryTree {

    /**
     *
     * @param n
     */
    void add(Node n);


    /**
     *
     * @param n
     * @return
     */
    boolean remove(Node n);


    /**
     *
     * @param n
     * @return
     */
    boolean isExist(Node n);


    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @return
     */
    int size();
}
