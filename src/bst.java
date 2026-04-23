
// Title: Binary Search Tree Family Program
// Author: Kayra Arı-Elçin Karagül
// ID: 10001507-10885319050
// Section: 4
// Assignment: 3

/* Description:
 This program creates and manages a family tree structure by using
 a binary tree. It supports BIRTH and MARRIED operations and prints
 the final tree in in-order traversal format.

*/


import java.util.Scanner;

// Summary: This class represents a family tree implemented using a binary tree.
// Precondition: Input commands must be valid.
// Postcondition: The family tree is created and managed according to given commands.
public class bst {

    public Node root;// Root node of the family tree

    private class Node {
        private String name;// Name of the individual
        private int age;// Age of the individual
        private Node left, right;  // Left and right children

        public Node(String name, int age) {
            this.name = name;
            this.age = age;
            this.left = null;
            this.right = null;
        }
    }

    // Summary: Public wrapper that inserts a new individual into the family tree by age.
    // Precondition: name is a non-null String, age is a positive integer.
    // Postcondition: A new node with the given name and age is inserted into the BST.
    public void birth(String name, int age) {
        root = birth(root, name, age);
    }

    // Summary: Recursively inserts a new node into the BST based on age.
    //          Smaller age goes left, larger age goes right, equal age is ignored.
    // Precondition: name is a non-null String, age is a positive integer.
    // Postcondition: Returns the updated subtree root after insertion.
    private Node birth(Node current, String name, int age) {

        if (current == null) {// If we reached an empty spot, create and return the new node
            return new Node(name, age);
        }


        if (age < current.age) {// Insert into left subtree if age is smaller
            current.left = birth(current.left, name, age);
        }
        else if (age > current.age) { // Insert into right subtree if age is larger
            current.right = birth(current.right, name, age);
        }
        else {
            // same age status so no action
        }

        return current;
    }

    // Summary: Public wrapper that searches the entire tree for a node by name.
    // Precondition: targetName is a non-null String.
    // Postcondition: Returns the node whose name matches targetName, or null if not found.
    public Node findByName(String targetName) {
        return findByName(root, targetName);
    }



    // Summary: Recursively searches the tree for a node matching the given name.
    // Precondition: targetName is a non-null String.
    // Postcondition: Returns the matching node, or null if no match is found.
    private Node findByName(Node current, String targetName) {


        if (current == null) {// if current null then return null
            return null;
        }


        if (current.name.equals(targetName)) {// checks if the name matches
            return current;
        }


        Node leftResult = findByName(current.left, targetName);//  Search in the left subtree


        if (leftResult != null) {//  If found in left subtree  return
            return leftResult;
        }

        return findByName(current.right, targetName);// Otherwise search in the right subtree
    }

    // Summary: Public wrapper that finds the parent node of the node with the given name.
    // Precondition: targetName is a non-null String and the node exists in the tree.
    // Postcondition: Returns the parent node of the target, or null if target is root or not found.
    public Node findParent(String targetName) {
        return findParent(root, targetName);
    }



    // Summary: Recursively searches the tree to find the parent of the node with the given name.
    // Precondition: targetName is a non-null String.
    // Postcondition: Returns the parent node of the target, or null if not found.
    private Node findParent(Node current, String targetName) {


        if (current == null) {// if current null then return null
            return null;
        }


        if (current.left != null && current.left.name.equals(targetName)) {// Check if the left child matches the target name
            return current;
        }


        if (current.right != null && current.right.name.equals(targetName)) {//Check if the right child matches the target name
            return current;
        }


        Node leftResult = findParent(current.left, targetName);//Search for the parent in the left subtree


        if (leftResult != null) {//If found in left subtree, return
            return leftResult;
        }


        return findParent(current.right, targetName); //then search in the right subtree
    }

    // Summary: Inserts a spouse into the tree as a sibling of the given person.
    //          The spouse is added as a child of the person's parent node.
    //          Special case: if the person is the root, spouse is added as root's right child.
    // Precondition: name is an existing individual in the tree, spouseName is a non-null String,
    //               spouseAge is a positive integer.
    // Postcondition: The spouse node is inserted if a slot is available, otherwise fails silently.
    //
    public void married(String name, String spouseName, int spouseAge) { // Find the person in the tree

        Node person = findByName(name);
        // If person does not exist, do nothing
        if (person == null) {
            return;
        }
        // Create a new spouse node
        Node spouse = new Node(spouseName, spouseAge);

        //  if the person is the root (has no parent)
        // insert spouse as the right child of root if available
        if (person == root) {
            if (root.right == null) {
                root.right = spouse;
            }
            // If root's right is already occupied insertion fails
            return;
        }
        // Find the parent of the specified person
        Node parent = findParent(name);

        // If parent is not found for some reason do nothing
        if (parent == null) {
            return;
        }

        // Insert spouse into the first available child slot of the parent
        if (parent.left == null) {
            // if left child is empty, insert here
            parent.left = spouse;

        }

        else if (parent.right == null) {
            // if right child is empty, insert here
            parent.right = spouse;
        }
        // If both children are occupied insertion fails
    }

    // Summary: Public wrapper that prints all nodes using in-order traversal.
    // Precondition: The tree may be empty or contain nodes.
    // Postcondition: All node names are printed in ascending age order followed by a newline.
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }


    // Summary: Recursively traverses the tree in-order and prints each node's name.
    // Precondition: current is a node or null.
    // Postcondition: All names in the subtree are printed in in-order sequence.
    private void printInOrder(Node current) {
        // if empty subtree
        if (current == null) {
            return;
        }
        // Visit left subtree first
        printInOrder(current.left);

        // Print current node's name
        System.out.print(current.name + " ");

        // Visit right subtree last
        printInOrder(current.right);
    }


    // Summary: Checks whether the tree is empty.
    // Precondition: None.
    // Postcondition: Returns true if the root is null, false otherwise.
    public boolean isEmpty() {

        return root == null;
    }


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        bst family = new bst();

        // Reads the number of commands
        int N = input.nextInt();
        input.nextLine(); // Consume the trailing newline after the integer

        for (int i = 0; i < N; i++) { // Process each command

            String line = input.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("BIRTH")) {
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                family.birth(name, age);
            }
            else if (command.equals("MARRIED")) {
                String name = parts[1];
                String spouseName = parts[2];
                int spouseAge = Integer.parseInt(parts[3]);
                family.married(name, spouseName, spouseAge);
            }
        }

        family.printInOrder();// Print the final family tree using in-order traversal
    }
}