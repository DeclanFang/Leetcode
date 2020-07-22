import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc589 {
    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        Stack<Node> s = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            for (int i = node.children.size() - 1; i >= 0; i --) {
                s.push(node.children.get(i));
            }
            res.add(node.val);
        }

        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
