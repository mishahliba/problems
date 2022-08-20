package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        TreeNode twenty = new TreeNode(20, fifteen, seven);

        TreeNode nine = new TreeNode(9);
        TreeNode root1 = new TreeNode(3, nine, twenty);

        TreeNode two = new TreeNode(2);
        TreeNode root2 = new TreeNode(1, null, two);

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two1 = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode root3 = new TreeNode(1, two1, three);


        var solution = new BinaryTreeLevelOrderTraversal102();
        List<List<Integer>> result = solution.levelOrder(root1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = processLevel(root, new ArrayList<>(), 0);
        return result;
    }

    private List<List<Integer>> processLevel(TreeNode node, List<List<Integer>> levels, int level) {
        if (levels.size() == level && node != null) {
            List<Integer> currentLevel = new ArrayList<>();
            levels.add(currentLevel);
        }
        if (node != null) {
            levels.get(level).add(node.val);
            processLevel(node.left, levels, level + 1);
            processLevel(node.right, levels, level + 1);
        }

        return levels;
    }
}
