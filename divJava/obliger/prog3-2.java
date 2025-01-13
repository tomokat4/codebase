import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    // 1. Metode for å legge til et tall i BST
    void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // 2. Metode for å finne minste tallet i BST
    int findMin() {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    // 3. Metode for å finne største tallet i BST
    int findMax() {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    // 4. Metode for å slette det største tallet i BST
    void deleteMax() {
        root = deleteMaxRec(root);
    }

    private TreeNode deleteMaxRec(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root.left;
        root.right = deleteMaxRec(root.right);
        return root;
    }

    // 6. Metode for å sjekke om et gitt tall finnes i treet
    int search(int value) {
        return searchRec(root, value) ? 1 : -1;
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    // In-Order Traversal
    void inorderTraversal() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 7. Test treet med verdiene: 100, 35, 120, 10, 40, 110, 140
        int[] values = {100, 35, 120, 10, 40, 110, 140};
        for (int value : values) {
            bst.insert(value);
        }

        // Test: Finn minste og største tall
        System.out.println("Minste tall i treet: " + bst.findMin());
        System.out.println("Største tall i treet: " + bst.findMax());

        // Slett største tallet
        bst.deleteMax();
        System.out.println("Etter å ha slettet største tall:");
        bst.inorderTraversal();
	
        // Test om et gitt tall finnes i treet
	System.out.println("Oppgi et tall som det skal letes etter i treet: ");
	boolean running = true;
	int searchValue = 110;
	Scanner scanner = new Scanner(System.in);
	searchValue = scanner.nextInt();
        System.out.println("Søker etter " + searchValue + ": " + (bst.search(searchValue) == 1 ? "Funnet" : "Ikke funnet"));
    }
}

