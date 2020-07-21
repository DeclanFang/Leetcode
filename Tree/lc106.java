import java.util.HashMap;
import java.util.Map;

public class lc106 {
    int post_index;
    int[] in_order;
    int[] post_order;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in_order = inorder;
        post_order = postorder;
        post_index = inorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }

        TreeNode root = helper(0, inorder.length - 1);

        return root;
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        int val = post_order[post_index];
        post_index --;
        TreeNode node = new TreeNode(val);
        int in_index = map.get(val);
        node.right = helper(in_index + 1, right);
        node.left = helper(left, in_index - 1);

        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
