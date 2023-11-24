//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AVLTree;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        AVL avlTree = new AVL();
        System.out.print("Enter the number of node to be added:- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; ++i) {
            System.out.print("Enter the val to be added in AVL Tree:- ");
            int val = sc.nextInt();
            avlTree.insert(val);
        }

        Node root = AVL.root;
        display(root);
    }

    public static void display(Node root) {
        if (root != null) {
            StringBuilder sb = new StringBuilder();
            if (root.left == null) {
                sb.append(". -> ");
            } else {
                sb.append(root.left.data + " -> ");
            }

            sb.append(root.data);
            if (root.right == null) {
                sb.append(" <- .");
            } else {
                sb.append(" <- " + root.right.data);
            }

            System.out.println(sb);
            display(root.left);
            display(root.right);
        }
    }
}