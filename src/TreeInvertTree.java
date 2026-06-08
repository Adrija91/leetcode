//recursion
class TreeNodeA {
    int val;          // The compartment for the number
    TreeNodeA left;    // The wire for the left box
    TreeNodeA right;   // The wire for the right box

    // Constructor: This makes a new box with a number inside it
    TreeNodeA(int val) {
        this.val = val;
        this.left = null;  // Starts off empty
        this.right = null; // Starts off empty
    }
}

// 2. The Program
public class TreeInvertTree {

    // 🔄 Your exact recursive DFS function
    public static TreeNodeA invertTree(TreeNodeA root) {
        if (root == null) {
            return null;
        }

        TreeNodeA temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        // --- 🛠️ Step 1: Build YOUR custom tree ---
        TreeNodeA topBox = new TreeNodeA(1);
        topBox.left = new TreeNodeA(10);
        topBox.left.right = new TreeNodeA(42);
        topBox.left.right.left = new TreeNodeA(7);

        System.out.println("--- BEFORE INVERSION ---");
        System.out.println("topBox.left.val: " + topBox.left.val);                  // Prints 10
        System.out.println("topBox.left.right.val: " + topBox.left.right.val);            // Prints 42
        System.out.println("topBox.left.right.left.val: " + topBox.left.right.left.val);  // Prints 7

        // --- 🔄 Step 2: Invert the tree using recursion ---
        invertTree(topBox);

        // --- 🧪 Step 3: Verify the new mirror-image paths ---
        System.out.println("\n--- AFTER INVERSION ---");

        // Everything that was on the left has swung over to the right side!
        System.out.println("topBox.right.val: " + topBox.right.val);                 // Now prints 10
        System.out.println("topBox.right.left.val: " + topBox.right.left.val);           // Now prints 42
        System.out.println("topBox.right.left.right.val: " + topBox.right.left.right.val); // Now prints 7
    }
}