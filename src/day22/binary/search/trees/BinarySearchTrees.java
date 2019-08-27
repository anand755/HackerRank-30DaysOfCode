package day22.binary.search.trees;

import java.util.Scanner;

public class BinarySearchTrees {
    public static int getHeight(Node root) {
        //Write your code here
        int leftHight = 0;
        int rightHight = 0;
        if (root.left != null) {
            leftHight = getHeight(root.left) + 1;
        }

        if (root.right != null) {
            rightHight = getHeight(root.right) + 1;
        }

        return (rightHight > leftHight ? rightHight : leftHight);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
