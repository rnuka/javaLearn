/**
 * Created by rnuka on 11/5/16.
 */

public class BinarySearchTree implements BinaryTree {

    int size;

    static Node root;


    /**
     * Adding a new node to Binary Tree
     * @param node
     */
    public void add(Node node){

        root = add(root, node);
    }

    /**
     * private call to do add src.main.Node recursively
     * @param currRoot
     * @param currNode
     */
    private Node add(Node currRoot, Node currNode){

        if(currRoot == null){
            currRoot = currNode;
        }
        else if(currNode.data <= currRoot.data) {
            currRoot.left =   add(currRoot.left, currNode);
        }
        else if(currNode.data > currRoot.data) {
            currRoot.right =  add(currRoot.right, currNode);
        }

        return currRoot;
    }

    /**
     * print tree in Pre-order Traversal
     * @param root
     */
    public void printPreOrder(Node root){
        if(root.left != null){
            printPreOrder(root.left);
        }
        System.out.println(root.data);
        if(root.right != null){
            printPreOrder(root.right);
        }
    }


    /**
     * Removing node from Binary Tree
     * @param node
     */
    public boolean remove(Node node){

        if(root.data == node.data){
            //TODO :
        }else{
            remove(root, node);
        }


        return false;
    }

    private Node findLeftMostElementParent(Node root){

        if(root == null){
            return null;
        }

        if(root != null && root.left == null ){
            return root;
        }

        if(root.left != null && root.left.left == null){
            return root;
        }
        return findLeftMostElementParent(root.left);
    }

    private boolean remove(Node croot, Node cnode){

        if(croot.left != null) {
            if (croot.left.data == cnode.data) {
                //leaf node
                if(croot.left.left == null && croot.left.right == null){
                    //remove croot.left
                    croot.left = null;
                }else{
                    //only left sub tree present
                    if(croot.left.right == null){
                        Node temp = croot.left.left;
                        croot.left.left = null;
                        croot.left = temp;

                    }
                    //if right sub tree is present
                    else {

                        //preserve left sub tree if present
                        Node crootLeftLeft = null;
                        if(croot.left.left != null){
                            crootLeftLeft =croot.left.left;
                        }

                        Node crootLeftRight = croot.left.right;

                        //get parent of left most element in right sub tree
                        Node temp = findLeftMostElementParent(croot.left.right);

                        //if left most element has right sub tree, then map the right sub tree to above temp node
                        Node leftMostRst = temp;
                        if(temp.left != null && temp.left.right != null){
                            leftMostRst = temp.left;
                            temp.left = temp.left.right;

                            croot.left = leftMostRst;
                            croot.left.left = crootLeftLeft;
                            croot.left.right = crootLeftRight;
                        }else{
                            croot.left = leftMostRst;
                            croot.left.left = crootLeftLeft;
                        }
                        System.out.println("Left most element in RST = " + temp.data);

                    }
                }
            }


        }


        return false;
    }

    /**
     * Check if tree is empty or not, return true if empty
     * @return
     */
    public boolean isEmpty(){
        return (size == 0);
    }


    /**
     * Check if node data is present in given Binary tree
     * @return
     */
    public boolean isExist(Node node){
        return isExist(root, node);
    }

    private boolean isExist(Node croot, Node cnode){

        if(croot == null || cnode == null){
            return false;
        }

        if(cnode.data == croot.data){
            return true;
        }
        boolean foundInLst = false;
        boolean foundInRst = false;

        if(croot.left != null && croot.data > cnode.data) {
            foundInLst = isExist(croot.left, cnode);
        }

        if(croot.right != null && croot.data < cnode.data) {
            foundInRst = isExist(croot.right, cnode);
        }

        return (foundInLst || foundInRst);
    }


    /**
     * size of binary tree
     */
    public int size(){
        return size;
    }


}
