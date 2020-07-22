import java.util.Stack;

public class lc1008 {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(nums);
        System.out.println(root);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        s.push(root);
        for (int i = 1; i < preorder.length; i ++) {
            int cur = preorder[i];
            TreeNode curr = new TreeNode(cur);
            if (cur < s.peek().val) {
                s.peek().left = curr;
                s.push(curr);
            }
            else {
                TreeNode temp = s.pop();
                while (!s.isEmpty() && s.peek().val < cur) {
                    temp = s.pop();
                }
                temp.right = curr;
                s.push(curr);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
}
