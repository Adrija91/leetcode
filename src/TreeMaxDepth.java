// 1. The Program
public class TreeMaxDepth {

    // 🎯 The recursive DFS function that checks EVERY branch
    public static int maxDepth(TreeNode root) {
        // Base Case: If the box is empty, it adds 0 to the depth
        if (root == null) {
            return 0;
        }

        // Ask the left child for its depth
        int leftDepth = maxDepth(root.left);

        // Ask the right child for its depth
        int rightDepth = maxDepth(root.right);

        // Take the deeper side, and add 1 for the current box
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // --- 🛠️ Step 1: Build the Zig-Zag Middle Tree ---
        TreeNode root = new TreeNode(1);

        // Left side (Short)
        root.left = new TreeNode(10);

        // Right side (Contains the deep middle path)
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(20);          // Zig middle
        root.right.left.right = new TreeNode(99);    // Zag middle

        // --- 🔍 Step 2: Calculate the Maximum Depth ---
        int depth = maxDepth(root);

        System.out.println("The maximum depth of this tree is: " + depth);
        // This will correctly print: 4
    }
}