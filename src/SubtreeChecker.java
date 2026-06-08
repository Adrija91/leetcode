// 📦 The Blueprint: Defines what a single tree node looks like
class TreeNodeSub {
    int val;             // The number stored in this box
    TreeNodeSub left;    // 🔄 Changed from TreeNode to TreeNodeSub
    TreeNodeSub right;   // 🔄 Changed from TreeNode to TreeNodeSub

    // Constructor to initialize a new node
    TreeNodeSub(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// 🚀 The Main Program
public class SubtreeChecker {

    // 🌲 Main method to check if subRoot is a subtree of root
    public static boolean isSubtree(TreeNodeSub root, TreeNodeSub subRoot) {
        // 1. An empty tree is always a subtree of any tree!
        if (subRoot == null) {
            return true;
        }
        // 2. If the main tree is null (but subRoot isn't), no match is possible
        if (root == null) {
            return false;
        }

        // 3. Check if the trees match perfectly starting at the current node
        if (sameTree(root, subRoot)) {
            return true;
        }

        // 4. If not, hunt recursively down the left and right branches using OR
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 🤝 Helper method to check if two trees are completely identical
    private static boolean sameTree(TreeNodeSub p, TreeNodeSub q) {
        // 1. Check if BOTH are null first
        if (p == null && q == null) {
            return true;
        }
        // 2. Now safely check if ONLY ONE is null
        if (p == null || q == null) {
            return false;
        }
        // 3. Check if the values match
        if (p.val != q.val) {
            return false;
        }

        // 4. Recursively check the left and right child nodes
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // --- 🛠️ Step 1: Build the Large Main Tree ---
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNodeSub root = new TreeNodeSub(1);
        root.left = new TreeNodeSub(2);
        root.right = new TreeNodeSub(3);
        root.left.left = new TreeNodeSub(4);
        root.left.right = new TreeNodeSub(5);

        // --- 🛠️ Step 2: Build the Subtree to Find ---
        //    2
        //   / \
        //  4   5
        TreeNodeSub subRoot = new TreeNodeSub(2);
        subRoot.left = new TreeNodeSub(4);
        subRoot.right = new TreeNodeSub(5);

        // --- 🧪 Step 3: Run the Checker ---
        boolean result = isSubtree(root, subRoot);
        System.out.println("Is it a subtree? " + result); // Will print: true
    }
}