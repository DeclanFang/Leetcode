import java.util.Arrays;

public class lc889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;

        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) return root;

        int L = 0;
        for (int i = 0; i < pre.length; i ++) {
            if (pre[1] == post[i]) {
                L = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, pre.length), Arrays.copyOfRange(post, L, pre.length - 1));

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
