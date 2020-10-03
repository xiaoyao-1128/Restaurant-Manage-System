package 算法;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class LeetCode117 {
    public static void main(String[] args) {
        LeetCode117 test = new LeetCode117();
        Node root = new Node(0,new Node(2,
                                        new Node(1,
                                                new Node(5), new Node(1), null),
                                  null, null),
                                    new Node(4,
                                        new Node(3,
                                                null, new Node(6), null),
                                        new Node(-1,
                                                null, new Node(8), null), null),
                              null);
        test.connect(root);
    }

    public Node connect(Node root) {
        return conncet2(root, null);
    }
    public Node conncet2(Node root, Node conNode){
        if(root != null){
            if(conNode == null){
                root.next = null;
            }else{
                root.next = conNode;
                if (conNode.right != null) conNode = conNode.left;
                else if(conNode.right != null) conNode = conNode.right;
                else{
                    conNode = null;
                }
            }
            Node right = conncet2(root.right, conNode);
            if(root.right != null) conNode = root.right;
            Node left = conncet2(root.left, conNode);
            return root;
        }else return null;
    }
}
