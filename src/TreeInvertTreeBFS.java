import java.util.LinkedList;
import java.util.Queue;

// 1. The Blueprint (Your Class Definition)
//class TreeNode {
//    int val;          // The compartment for the number
//    TreeNode left;    // The wire for the left box
//    TreeNode right;   // The wire for the right box
//
//    // Constructor: This makes a new box with a number inside it
//    TreeNode(int val) {
//        this.val = val;
//        this.left = null;  // Starts off empty
//        this.right = null; // Starts off empty
//    }
//}

// 2. The Program using your requested class name
public class TreeInvertTreeBFS {

    // 📦 Iterative BFS function to invert the tree using a Queue
    public static TreeNode invertTree(TreeNode root) {
        // Base case: If the tree is empty, do nothing
        if (root == null) {
            return null;
        }

        // Create our Queue line to hold boxes level-by-level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 🔄 Loop as long as there are boxes left in the queue line
        while (!queue.isEmpty()) {
            // 👤 Take the next box out from the front of the line
            TreeNode current = queue.poll();

            // 🧪 Swap its left and right wires
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // 📂 Put the children into the line if they exist
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        // Return the final inverted tree root
        return root;
    }

    public static void main(String[] args) {
        // --- 🛠️ Step 1: Build YOUR custom tree ---
        TreeNode topBox = new TreeNode(1);
        topBox.left = new TreeNode(10);
        topBox.left.right = new TreeNode(42);
        topBox.left.right.left = new TreeNode(7);

        System.out.println("--- BEFORE INVERSION ---");
        System.out.println("topBox.left.val: " + topBox.left.val);                  // Prints 10
        System.out.println("topBox.left.right.val: " + topBox.left.right.val);            // Prints 42
        System.out.println("topBox.left.right.left.val: " + topBox.left.right.left.val);  // Prints 7

        // --- 🔄 Step 2: Invert the tree using BFS ---
        invertTree(topBox);

        // --- 🧪 Step 3: Verify the new mirror-image paths ---
        System.out.println("\n--- AFTER INVERSION ---");

        // Everything successfully swung over to the right side!
        System.out.println("topBox.right.val: " + topBox.right.val);                 // Now prints 10
        System.out.println("topBox.right.left.val: " + topBox.right.left.val);           // Now prints 42
        System.out.println("topBox.right.left.right.val: " + topBox.right.left.right.val); // Now prints 7
    }
}