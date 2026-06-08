import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 📦 Blueprint for the binary tree nodes
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLvlOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 👥 Queue to keep track of nodes layer by layer
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size(); // 📐 Number of elements at the current level
            List<Integer> currentLvl = new ArrayList<>();

            // 🔄 Process all nodes belonging to this specific level
            for (int i = 0; i < lvlSize; i++) {
                TreeNode cur = q.poll();
                currentLvl.add(cur.val);

                // 🌿 Queue up the children for the next level
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 🏁 Add the completed layer to our results list
            res.add(currentLvl);
        }

        return res;
    }

    // 🛠️ Main method to test the code inside IntelliJ
    public static void main(String[] args) {
        // Constructing a sample tree:
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLvlOrderTraversal solution = new BinaryTreeLvlOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);

        // 🖨️ Output should be: [[3], [9, 20], [15, 7]]
        System.out.println("Level Order Traversal: " + result);
    }
}