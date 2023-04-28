public class LinkedBinarySearchTree<E extends Comparable<E>> implements BinarySearchTree<E> {
    //Private variables
    private E data; // Root's element
    private LinkedBinarySearchTree<E> leftSubTree; // Reference to the left subtree
    private LinkedBinarySearchTree<E> rightSubTree; // Reference to the right subtree
    private int count; // Track tree's size

    //Null Constructor
    public LinkedBinarySearchTree() { this.data = null; leftSubTree = null; rightSubTree = null; this.count=0;}
    //Constructor
    public LinkedBinarySearchTree(E data) {
        this.data = data;
        leftSubTree = new LinkedBinarySearchTree<E>();
        rightSubTree = new LinkedBinarySearchTree<E>();
        count = 1 + leftSubTree.count + rightSubTree.count;
    }

    /**
     * Method that takes in element and inserts in the BST
     * It checks for 4 cases, if tree is empty, if tree element is the same candidate,
     * then it checks whether its greater or less than the trees element and puts it respectively into the right or left subtree
     * @param element
     */
    @Override
    public void insert(E element) {
        //checking if empty
        if(this.isEmpty()){
            this.data = element;
            leftSubTree = new LinkedBinarySearchTree<>();
            rightSubTree = new LinkedBinarySearchTree<>();
            count++;
        }
        //Checking if its the same element
        else if (this.data.compareTo(element) == 0) {
            this.data = element;
        }
        //Checking if it is less than
        else if (this.data.compareTo(element) > 0) {
            this.leftSubTree.insert(element);
        }
        //Checking if it is greater than
        else{
            this.rightSubTree.insert(element);
        }
    }

    /**
     * Gets root element
     * @return data candidate
     */
    @Override
    public E getRootElement() {
        return data;
    }

    /**
     * Recursively checks and returns size of the tree
     * @return int size of tree
     */
    @Override
    public int size() {
        if (this.isEmpty())
            return 0; // base case
        else
            return 1 + leftSubTree.size() + rightSubTree.size(); // recursive case
    }

    /**
     * Checks if the count is 0 and the tree is empty
     * @return if the tree is empty, boolean
     */
    @Override
    public boolean isEmpty() {
        return count==0;
    }

    /**
     * Recursively returns tree, with in order traversal by checking for 4 cases,
     * if both left and right subtree are empty
     * if only either one are empty
     * if neither are empty, then concatenates string respectively
     * @return String of tree with in order traversal
     */
    @Override
    public String toStringInOrder() {
        if(leftSubTree.isEmpty() && rightSubTree.isEmpty()){
            return this.data.toString();
        }
        else if (leftSubTree.isEmpty()){
            return this.data.toString() + " " + this.rightSubTree.toStringInOrder();
        }
        else if (rightSubTree.isEmpty()) {
            return this.leftSubTree.toStringInOrder() + " " + this.data.toString();
        }
        else {
            return this.leftSubTree.toStringInOrder() + " " + this.data.toString() + " " + this.rightSubTree.toStringInOrder();
        }
    }

    /**
     * Recursively returns tree, with pre order traversal by checking for 4 cases,
     * if both left and right subtree are empty
     * if only either one are empty
     * if neither are empty, then concatenates string respectively
     * @return String of tree with pre order traversal
     */
    @Override
    public String toStringPreOrder() {
        if(leftSubTree.isEmpty() && rightSubTree.isEmpty()){
            return this.data.toString();
        } else if (leftSubTree.isEmpty()){
            return this.data.toString() + " " + this.rightSubTree.toStringPreOrder();
        } else if (rightSubTree.isEmpty()) {
            return this.data.toString() + " " + this.leftSubTree.toStringPreOrder();
        }
        else {
            return this.data.toString() + " " + this.leftSubTree.toStringPreOrder() + " " + this.rightSubTree.toStringPreOrder();
        }
    }
    /**
     * Recursively returns tree, with post order traversal by checking for 4 cases,
     * if both left and right subtree are empty
     * if only either one are empty
     * if neither are empty, then concatenates string respectively
     * @return String of tree with post order traversal
     */
    @Override
    public String toStringPostOrder() {
        if(leftSubTree.isEmpty() && rightSubTree.isEmpty()){
            return this.data.toString();
        }
        else if (leftSubTree.isEmpty()){
            return this.rightSubTree.toStringPostOrder() + " " + this.data.toString();
        }
        else if (rightSubTree.isEmpty()) {
            return this.leftSubTree.toStringPostOrder() + " " + this.data.toString();
        }
        else {
            return this.leftSubTree.toStringPostOrder() + " " + this.rightSubTree.toStringPostOrder() + " " + this.data.toString();
        }
        }

    /**
     * Returns string of tree in format of all three traversals,
     * @return String of pre order, in order and post order
     */
    public String toString(){
        return "Tree:" + "\n" + "Pre:" + "\t" + this.toStringPreOrder() +"\n"+ "In:"+ "\t\t"+ this.toStringInOrder() + "\n" + "Post:" + "\t" + this.toStringPostOrder();
    }
}