package com.lintcode.algorithm;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.*;

/**
 * 二叉树的序列化和反序列化
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/22
 */
public class BinaryTreeSerializeAndDeserialize {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);
        while (queue.size() > 0) {
            current = queue.poll();
            if (current != null) {
                result.add(Integer.toString(current.val));
                queue.add(current.left);
                queue.add(current.right);
            } else {
                result.add("#");
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            if ("#".equals(result.get(i))) {
                result.remove(i);
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder("{");
        result.forEach(str->sb.append(str).append(","));
        return sb.deleteCharAt(sb.length()-1).append("}").toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.length()==0) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        TreeNode root = new TreeNode();
        TreeNode parentNode = new TreeNode();
        Queue<TreeNode> current = new ArrayDeque<>();
        int count = 1;
        boolean isRoot = true;
        for (int i = 0; i < split.length; i++) {
            String val = split[i];
            if (!"#".equals(val)) {
                TreeNode newNode = new TreeNode(Integer.parseInt(val));
                if (!isRoot) {
                    current.add(newNode);
                    if (count == 1) {
                        parentNode.left = newNode;
                        count++;
                    } else {
                        parentNode.right = newNode;
                        parentNode = current.poll();
                        count--;

                    }
                } else {
                    root = new TreeNode(Integer.parseInt(val));
                    isRoot = false;
                    parentNode = root;
                }
            } else {
                if (count == 1) {
                    parentNode.left = null;
                    count++;
                } else {
                    parentNode.right = null;
                    parentNode = current.poll();
                    count--;
                }
            }
        }
        return root;
    }

    @Test
    public void test() {
        System.out.println(serialize(deserialize("{}")));
    }
}