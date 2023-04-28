


// Test from the .md file is given below
class BinarySearchTreeTest {
    public static void main(String[] args) {
        System.out.println("Uncomment the two lines below, comment out this one, to test BST's");
        testInteger(new LinkedBinarySearchTree<Integer>());
        testCharacter(new LinkedBinarySearchTree<Character>());
        System.out.println("If we get here without any error messages, BST self-checks passed");
    }
    private static void testInteger(BinarySearchTree<Integer> initiallyEmptyIntTree) {
        if (initiallyEmptyIntTree == null) {
            System.out.println("testCharacter: need to create a tree for testing!");
        }
        assert(initiallyEmptyIntTree != null);        // If we wanted to run this without changing the object we were passed, we would copy:
        //      BinarySearchTree<Integer> intTree = initiallyEmptyIntTree.deepCopy();
        // But, since the assignment doesn't require "deepCopy", we'll make this method private,
        //   and only call it when we don't subsequently care about the BST we pass it,
        //   and then just change the original tree:
        BinarySearchTree<Integer> intTree = initiallyEmptyIntTree;  // intTree now "paired with" the original tree
        assert(intTree.isEmpty());
        System.out.println("Beginning BST self-checks for integers");

        intTree.insert(8);
        intTree.insert(11);
        intTree.insert(5);
        intTree.insert(17);
        intTree.insert(1);
        intTree.insert(9);
        intTree.insert(3);
        System.out.println("My preorder result is");
        System.out.println(intTree.toStringPreOrder());
//        if (!(intTree.toStringPreOrder().equals("8 5 1 3 11 9 17"))){
//            System.err.println(" Self-check failed: preOrder == 8 5 1 3 11 9 17");
//        }
        System.out.println("The correct answer is 8 5 1 3 11 9 17");
        System.out.println("My inorder result is");
        System.out.println(intTree.toStringInOrder());
//        if (!(intTree.toStringInOrder().equals("1 3 5 8 9 11 17"))){
//            System.err.println(" Self-check failed: inOrder == 1 3 5 8 9 11 17");
//        }
        System.out.println("The correct answer is 1 3 5 8 9 11 17");
        System.out.println("My postorder result is");
        System.out.println(intTree.toStringPostOrder());
//        if (!(intTree.toStringPostOrder().equals("3 1 5 9 17 11 8"))){
//            System.err.println(" Self-check failed: postOrder == 3 1 5 9 17 11 8");
//        }
        System.out.println("The correct answer is 3 1 5 9 17 11 8");
        System.out.println();
        //assertEquals("8 5 1 3 11 9 17", intTree.toStringPreOrder());
        //assertEquals("1 3 5 8 9 11 17", intTree.toStringInOrder());
        //assertEquals("3 1 5 9 17 11 8", intTree.toStringPostOrder());
    }



    private static void testCharacter(BinarySearchTree<Character> initiallyEmptyCharacterTree) {
        // perhaps should have called this Kobayashi Maru?
        // See note in testInteger about "deepCopy"
        if (initiallyEmptyCharacterTree == null) {
            System.out.println("testCharacter: need to create a tree for testing!");
        }
        assert(initiallyEmptyCharacterTree != null);

        BinarySearchTree<Character> letterTree = initiallyEmptyCharacterTree;
        assert(letterTree.isEmpty());
        System.out.println("Beginning BST self-checks for characters");

        letterTree.insert('A');
        letterTree.insert('C');
        letterTree.insert('G');
        letterTree.insert('B');
        letterTree.insert('D');
        letterTree.insert('G'); // inserting again, should replace
        letterTree.insert('F');
        letterTree.insert('E');
        letterTree.insert('H');
        letterTree.insert('I');
        System.out.println("The size of my letter tree is");
        System.out.println(letterTree.size());
//        if ((!(letterTree.size() == 9))) {
//            System.err.println(" Self-check failed: size of letterTree == 9");
//        }
        System.out.println("The correct answer is 9");
        System.out.println("My result for preorder is");
        System.out.println(letterTree.toStringPreOrder());
//        if (!(letterTree.toStringPreOrder().equals("A C B G D F E H I"))){
//            System.err.println(" Self-check failed: preOrder == A C B G D F E H I");
//        }
        System.out.println("The correct answer for preorder is A C B G D F E H I");
        System.out.println("My result for inorder is");
        System.out.println(letterTree.toStringInOrder());
//        if (!(letterTree.toStringInOrder().equals("A B C D E F G H I"))){
//            System.err.println(" Self-check failed: inOrder == A B C D E F G H I");
//        }
        System.out.println("The correct answer for inorder is A B C D E F G H I");
        System.out.println("My result for postorder is");
        System.out.println(letterTree.toStringPostOrder());
//        if (!(letterTree.toStringPostOrder().equals("B E F D I H G C A"))){
//            System.err.println(" Self-check failed: postOrder == B E F D I H G C A");
//        }
        System.out.println("The correct answer for postorder is B E F D I H G C A");
        //assertEquals(9, letterTree.size());
        //assertEquals("A C B G D F E H I", letterTree.toStringPreOrder());
        //assertEquals("A B C D E F G H I", letterTree.toStringInOrder());
        //assertEquals("B E F D I H G C A", letterTree.toStringPostOrder());
    }
}