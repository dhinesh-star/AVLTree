//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AVLTree;

public class AVL {
    static Node root;

    public AVL() {
        root = null;
    }

    void insert(int val) {
        root = this.insertIntoBST(root, val);
    }

    int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    Node insertIntoBST(Node root1, int val) {
        if (root1 == null) {
            return new Node(val);
        } else {
            if (val > root1.data) {
                root1.right = this.insertIntoBST(root1.right, val);
            } else if (val < root1.data) {
                root1.left = this.insertIntoBST(root1.left, val);
            }

            root1.height = 1 + Math.max(this.getHeight(root1.left), this.getHeight(root1.right));
            int bstFactor = this.getHeight(root1.left) - this.getHeight(root1.right);
            if (bstFactor > 1 && val < root1.left.data) {
                return this.rightRotation(root1);
            } else if (bstFactor > 1 && val > root1.left.data) {
                root1.left = this.leftRotation(root1.left);
                return this.rightRotation(root1);
            } else if (bstFactor < -1 && val > root1.right.data) {
                return this.leftRotation(root1);
            } else if (bstFactor < -1 && val < root1.right.data) {
                root1.right = this.rightRotation(root1.right);
                return this.leftRotation(root1);
            } else {
                return root1;
            }
        }
    }

    Node rightRotation(Node z) {
        Node y = z.left;
        Node t3 = y.right;
        z.left = t3;
        z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
        y.right = z;
        y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
        return y;
    }

    Node leftRotation(Node z) {
        Node y = z.right;
        Node t3 = y.left;
        z.right = t3;
        z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
        y.left = z;
        y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
        return y;
    }
}
class Node{
    int data,height;
    Node left,right;
    Node(){
        left=right=null;
        height=0;
    }
    Node(int val){
        this();
        this.data =val;
    }
}
