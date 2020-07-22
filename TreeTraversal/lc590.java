import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc590 {
    public List<Integer> postorder(Node root) {
        Stack<Node> s = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        s.push(root);

        while (!s.isEmpty()) {
            Node node = s.pop();
            for (Node ch : node.children) {
                s.push(ch);
            }
            res.addFirst(node.val);
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
