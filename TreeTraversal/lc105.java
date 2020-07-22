import java.util.HashMap;
import java.util.Map;

public class lc105 {
    int pre_index;
    int[] pre_order;
    int[] in_order;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_index = 0;
        pre_order = preorder;
        in_order = inorder;
        map = new HashMap<>();

        for (int i = 0; i < preorder.length; i ++) {
            map.put(inorder[i], i);
        }

        TreeNode root = helper(0, preorder.length - 1);

        return root;
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;

        int val = pre_order[pre_index];
        TreeNode node = new TreeNode(val);
        pre_index ++;

        int in_index = map.get(val);

        node.left = helper(left, in_index - 1);
        node.right = helper(in_index + 1, right);

        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

