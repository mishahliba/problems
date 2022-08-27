package main.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestor235 {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4, three, five);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8, seven, nine);
        TreeNode two = new TreeNode(2, zero, four);
        TreeNode six = new TreeNode(6, two, eight);
        var solution = new LowestCommonAncestor235();
        TreeNode common = solution.lowestCommonAncestor(six, two, four);

        System.out.println(common);
    }

    // bad solution. correct solution has 5 lines. just compare left and right value with current - that`s the answer
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        Queue<TreeNode> leftPath = findPath(new LinkedList<>(), p, root);
        Queue<TreeNode> rightPath = findPath(new LinkedList<>(), q, root);
        List<TreeNode> leftList = new ArrayList<>(leftPath);
        List<TreeNode> rightList = new ArrayList<>(rightPath);
        Collections.reverse(leftList);
        Collections.reverse(rightList);

        TreeNode result = null;
        List<TreeNode> smaller = leftList.size() >= rightList.size() ?  rightList : leftList;
        List<TreeNode> bigger = leftList.size() < rightList.size() ?  rightList : leftList;
        for (int i = 0; i < smaller.size(); i++) {
                if(smaller.get(i) == bigger.get(i)) {
                    result = smaller.get(i);
                }
        }
        return result;
    }

    private Queue<TreeNode> findPath(Queue<TreeNode> path, TreeNode p, TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        } else if (!path.contains(p)) {
            findPath(path, p, root.left);
            findPath(path, p, root.right);
            path.add(root);
        }
        if (!path.contains(p)) {
            path.poll();
        } else if (path.contains(p)) {
            return path;
        }
        return path;
    }
}
