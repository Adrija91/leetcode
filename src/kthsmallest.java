import java.util.Stack;

// 🌳 Definition for a binary tree node provided by the problem
class TreeNodeN {
    int val;
    TreeNodeN left;
    TreeNodeN right;
    TreeNodeN() {}
    TreeNodeN(int val) { this.val = val; }
    TreeNodeN(int val, TreeNodeN left, TreeNodeN right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class kthsmallest {
    private int counter = 0;
    private int result = 0;

    // 🔍 Main method to test the solution inside IntelliJ
    public static void main(String[] args) {
        // 🛠️ Fixed: Instantiating the correct class name matching line 16
        kthsmallest solver = new kthsmallest();

        /*
         * Let's build this sample BST:
         *        4
         *       / \
         *      2   5
         *     / \
         *    1   3
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int k = 3;
        int answer = solver.kthSmallest(root, k);

        System.out.println("The " + k + "rd smallest element is: " + answer);
    }

    // 🚀 Your Recursive DFS In-Order Solution
    public int kthSmallest(TreeNode root, int k) {
        inorderDFS(root, k);
        return result;
    }

    private void inorderDFS(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // 1. Traverse Left Subtree ⬅️
        inorderDFS(node.left, k);

        // 2. Process Current Node 🟢
        counter++;
        if (counter == k) {
            result = node.val;
            return;
        }

        // 3. Traverse Right Subtree ➡️
        inorderDFS(node.right, k);
    }
}