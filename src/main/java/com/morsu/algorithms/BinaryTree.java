package com.morsu.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        Node newNode = new Node(data);

        if ( node == null) {
            return newNode;
        }

        if (node.data <= data) {
            node.left = insert(node.left, data);
        } else
            node.right = insert(node.right, data);

        return node;
    }

    public void preOrder(){
        System.out.println("================= PRE ORDER ==================");
        preOrder(this.root);
        System.out.println();
        System.out.println("----------------------------------------------");
    }

    private void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.print(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder() {
        System.out.println("================= POST ORDER ==================");
        postOrder(this.root);
        System.out.println();
        System.out.println("----------------------------------------------");
    }

    private void postOrder(Node node) {
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node);
    }

    private void inOrder() {
        System.out.println("================= IN ORDER ==================");
        inOrder(this.root);
        System.out.println();
        System.out.println("----------------------------------------------");
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node);
        inOrder(node.right);
    }

    public int depth() {
        return depth(this.root, 0);
    }

    private int depth(Node node, int level) {

        if (node == null) {
            return  level;
        }

        int leftDepth = depth(node.left, level+1);
        int rightDepth = depth(node.right, level+1);

        return Math.max(leftDepth, rightDepth);
    }

    public List<Node> getSameLevelNodes(int level) {
        List<Node> levelNodes = new ArrayList<>();
        levelNodes(this.root,level, levelNodes);

        return levelNodes;
    }

    private void levelNodes(Node node, int level, List<Node> levelNodes) {
        if (node == null) return;

        if ( level == 1) {
            levelNodes.add(node);
            return;
        }

        levelNodes(node.left, level-1, levelNodes);
        levelNodes(node.right, level-1, levelNodes);
    }

    private int widthAtLevel(int level) {
        return getSameLevelNodes(level).size();
    }

    private int maxWidth() {
        int depth = depth();
        int maxDepth = 0;

        for (int i = 1; i <= depth; i++) {
            maxDepth = Math.max(maxDepth, widthAtLevel(i));
        }

        return maxDepth;
    }

    public void breadthFirstSearch() {
        int depth = depth();
        List<Node> allNodes = new ArrayList<>();
        for (int i = 1; i <= depth; i++) {
            allNodes.addAll(getSameLevelNodes(i));
        }

        System.out.println("======================================= BFS =========================================");
        System.out.println(allNodes);
        System.out.println("-------------------------------------------------------------------------------------");
    }

    static class Node {

        private Node left;
        private Node right;

        private int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("%d ",data);
        }
    }

    public static void main(String[] args) {
        /*
                10
               /   \
             11     4
            /      / \
          12      9   3
          /
         25

         */
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(11);
        binaryTree.insert(12);
        binaryTree.insert(25);
        binaryTree.insert(3);

        System.out.println("======================================= DFS =========================================");
        binaryTree.preOrder();
        binaryTree.inOrder();
        binaryTree.postOrder();
        System.out.println("--------------------------------------------------------------------------------------");

        binaryTree.breadthFirstSearch();

        System.out.println(String.format("Depth of tree, %d", binaryTree.depth()));
        int level = 3;
        System.out.println(String.format("Nodes at Level# %d are %s", level, binaryTree.getSameLevelNodes(level)));
        System.out.println(String.format("Max width of tree# %d", binaryTree.maxWidth()));


    }
}
