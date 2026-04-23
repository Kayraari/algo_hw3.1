import java.util.Scanner;

public class bst {

    // Root of the family tree
    public Node root;

    // Node structure
    // Each person must store:
    // - name
    // - age
    // - left child
    // - right child
    private class Node {
        private String name;
        private int age;
        private Node left, right;

        public Node(String name, int age) {
            this.name = name;
            this.age = age;
            this.left = null;
            this.right = null;
        }
    }

    // ---------------------------------------------------
    // BIRTH
    // ---------------------------------------------------
    // This part was correct in your idea:
    // You need one public method and one recursive helper.
    // BUT comparison must be done with AGE, not NAME.
    public void birth(String name, int age) {
        root = birth(root, name, age);
    }

    private Node birth(Node x, String name, int age) {
        // Base case:
        // If current position is empty, create and return new node
        if (x == null) {
            return new Node(name, age);
        }

        // Compare by AGE because BIRTH must follow BST rule by age
        if (age < x.age) {
            x.left = birth(x.left, name, age);
        } else if (age > x.age) {
            x.right = birth(x.right, name, age);
        } else {
            // TODO:
            // Decide what you want to do if ages are equal.
            // For now, you may leave it like this or ignore duplicates.
        }

        return x;
    }

    // ---------------------------------------------------
    // FIND PERSON BY NAME
    // ---------------------------------------------------
    // Important:
    // Tree is NOT ordered by name.
    // So you CANNOT search with compareTo like a normal BST search.
    // You must traverse the whole tree.
    public Node findByName(String targetName) {
        return findByName(root, targetName);
    }

    private Node findByName(Node x, String targetName) {
        // TODO:
        // 1. If x is null, return null
        // 2. If x.name equals targetName, return x
        // 3. Search left subtree
        // 4. If found on left, return it
        // 5. Otherwise search right subtree

        return null; // replace this
    }

    // ---------------------------------------------------
    // FIND PARENT BY NAME
    // ---------------------------------------------------
    // You need this for MARRIED command.
    public Node findParent(String targetName) {
        return findParent(root, targetName);
    }

    private Node findParent(Node x, String targetName) {
        // TODO:
        // 1. If x is null, return null
        // 2. If x.left exists and x.left.name equals targetName, return x
        // 3. If x.right exists and x.right.name equals targetName, return x
        // 4. Search left subtree for parent
        // 5. If found, return it
        // 6. Otherwise search right subtree

        return null; // replace this
    }

    // ---------------------------------------------------
    // MARRIED
    // ---------------------------------------------------
    // Format: MARRIED name spouseName age
    // Steps:
    // 1. Find the person with given name
    // 2. Find that person's parent
    // 3. Insert spouse as child of that parent
    // 4. Special case: if person is root, spouse goes to root.right if empty
    public void married(String name, String spouseName, int spouseAge) {
        // TODO:
        // Step 1: Find the person node
        Node person = findByName(name);

        // If person not found, do nothing or print error
        if (person == null) {
            // TODO: optional error handling
            return;
        }

        // Step 2: Create spouse node
        Node spouse = new Node(spouseName, spouseAge);

        // Step 3: Special case if person is root
        if (person == root) {
            // TODO:
            // If root.right is empty, insert spouse there
            // Otherwise insertion fails
            return;
        }

        // Step 4: Find parent of the given person
        Node parent = findParent(name);

        if (parent == null) {
            // TODO: optional error handling
            return;
        }

        // Step 5: Insert spouse into parent's empty child
        // Rule:
        // if left empty -> left
        // else if right empty -> right
        // else insertion fails

        // TODO:
        // Write the actual insertion logic here
    }

    // ---------------------------------------------------
    // INORDER TRAVERSAL
    // ---------------------------------------------------
    // Output must be printed in inorder:
    // left -> root -> right
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node x) {
        if (x == null) {
            return;
        }

        printInOrder(x.left);

        // This part is correct idea:
        // print the current node between left and right
        System.out.print(x.name + " ");

        printInOrder(x.right);
    }

    // ---------------------------------------------------
    // OPTIONAL HELPER
    // ---------------------------------------------------
    // You may use this if you want to test tree structure while debugging
    public boolean isEmpty() {
        return root == null;
    }

    // ---------------------------------------------------
    // MAIN
    // ---------------------------------------------------
    // This is only the structure.
    // You will complete input reading yourself.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        bst family = new bst();

        // TODO:
        // 1. Read number of commands
        // 2. Loop that many times
        // 3. Read each command line
        // 4. Split the line into parts
        // 5. If command is BIRTH:
        //      family.birth(name, age);
        // 6. If command is MARRIED:
        //      family.married(name, spouseName, age);
        // 7. After all commands, call:
        //      family.printInOrder();



        family.printInOrder();
    }
}