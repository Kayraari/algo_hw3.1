import java.util.Scanner;

public class bst {

    public Node root;

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
    public void birth(String name, int age) {
        root = birth(root, name, age);
    }

    private Node birth(Node current, String name, int age) {

        // boş yere geldiysek yeni node oluştur
        if (current == null) {
            return new Node(name, age);
        }

        // yaşa göre BST yerleştirme
        if (age < current.age) {
            current.left = birth(current.left, name, age);
        }
        else if (age > current.age) {
            current.right = birth(current.right, name, age);
        }
        else {
            // TODO: aynı yaş durumu (istersen boş bırakabilirsin)
        }

        return current;
    }

    // ---------------------------------------------------
    // FIND PERSON BY NAME
    // ---------------------------------------------------
    public Node findByName(String targetName) {
        return findByName(root, targetName);
    }

    private Node findByName(Node current, String targetName) {

        // TODO:
        // 1. current null ise return null
        // 2. current.name equals targetName ise return current
        // 3. solda ara
        // 4. solda bulursan return et
        // 5. sağda ara

        return null;
    }

    // ---------------------------------------------------
    // FIND PARENT
    // ---------------------------------------------------
    public Node findParent(String targetName) {
        return findParent(root, targetName);
    }

    private Node findParent(Node current, String targetName) {

        // TODO:
        // 1. current null ise return null
        // 2. current.left varsa ve adı eşitse return current
        // 3. current.right varsa ve adı eşitse return current
        // 4. solda parent ara
        // 5. bulursan return et
        // 6. sağda ara

        return null;
    }

    // ---------------------------------------------------
    // MARRIED
    // ---------------------------------------------------
    public void married(String name, String spouseName, int spouseAge) {

        Node person = findByName(name);

        if (person == null) {
            return;
        }

        Node spouse = new Node(spouseName, spouseAge);

        // root special case
        if (person == root) {
            // TODO:
            // root.right boşsa ekle
            // değilse fail
            return;
        }

        Node parent = findParent(name);

        if (parent == null) {
            return;
        }

        // TODO:
        // if parent.left boşsa → spouse
        // else if parent.right boşsa → spouse
        // else → fail
    }

    // ---------------------------------------------------
    // INORDER
    // ---------------------------------------------------
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node current) {

        if (current == null) {
            return;
        }

        printInOrder(current.left);

        System.out.print(current.name + " ");

        printInOrder(current.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    // ---------------------------------------------------
    // MAIN
    // ---------------------------------------------------
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        bst family = new bst();

        int N = input.nextInt();
        input.nextLine(); // newline temizle

        for (int i = 0; i < N; i++) {

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

        family.printInOrder();
    }
}