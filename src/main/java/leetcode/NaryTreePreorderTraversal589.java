package main.java.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreePreorderTraversal589 {
    public static void main(String[] args) {
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        List<Node> thirdChildren = Arrays.asList(fifth, sixth);
        Node third = new Node(3, thirdChildren);

        Node second = new Node(2);
        Node fourth = new Node(4);
        List<Node> rootChildren = Arrays.asList(third, second, fourth);

        Node root = new Node(1, rootChildren);

        var solution = new NaryTreePreorderTraversal589();
        solution.preorder(root);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        res = processNode(root, res);
        return res;
    }

    private List<Integer> processNode(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    processNode(child, res);
                }
            }
        }
        return res;
    }
}
