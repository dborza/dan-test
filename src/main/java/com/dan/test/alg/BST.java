package com.dan.test.alg;

/**
 * Created by gborza on 28/04/2014.
 */
public class BST {

    static class Node {

        /**
         * Value of the node
         */
        int v;

        /**
         * Left node
         */
        Node left;

        /**
         * Right node
         */
        Node right;

        /**
         * Reference to parent node
         */
        Node parent;

        /**
         * Construct a node.
         */
        Node(int v, Node l, Node r) {
            this.v = v;
            this.left = l;
            this.right = r;
            this.parent = null;
            if (l != null) {
                l.parent = this;
            }
            if (r != null) {
                r.parent = this;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
//                    ", left=" + left +
//                    ", right=" + right +
//                    ", parent=" + parent +
                    '}';
        }
    }

    /**
     * Delete node of value v from tree identified by it's root node.
     *
     * @return The root of the resulting tree.
     */
    static Node delete(Node root, int v) {

        if (root == null) {
            throw new IllegalStateException("Value " + v + " not found in tree");
        }

        //  We found the desired value. Let's delete it.
        if (root.v == v) {
            final Node parent = root.parent;
            //  Leaf node
            if (root.left == null && root.right == null) {
                //  We delete the root node. Return null as the new root.
                if (parent == null) {
                    return null;
                } else {
                    //  Delete the reference from the parent to the leaf
                    if (parent.left == root) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (root.left == null) {
                Node maxLeft = extractMax(root.left);
                root.v = maxLeft.v;
                maxLeft.parent.left = null;
            } else if (root.right == null) {
                Node minRight = extractMin(root.right);
                if (minRight != null) {
                    root.v = minRight.v;
                    minRight.parent.right = null;
                }
            } else {
                Node maxLeft = extractMax(root.left);
                if (maxLeft != null) {
                    root.v = maxLeft.v;
                    maxLeft.parent.left = null;
                }
            }
        } else {
            if (v < root.v) {
                return delete(root.left, v);
            } else {
                return delete(root.right, v);
            }
        }

        return root;
    }

    static Node extractMin(Node n) {

        if (n == null) {
            return null;
        }

        if (n.left == null) {
            return n;
        }

        return extractMin(n.left);
    }

    static Node extractMax(Node n) {

        if (n == null) {
            return null;
        }

        if (n.right != null) {
            return n;
        }

        return extractMin(n.left);
    }

    static void inner(Node n) {

        if (n == null) {
            return;
        }

        inner(n.left);
        System.out.print(n + " ");
        inner(n.right);
    }

    static void pre(Node n) {

        if (n == null) {
            return;
        }

        System.out.print(n + " ");

        pre(n.left);
        pre(n.right);
    }

    static void post(Node n) {

        if (n == null) {
            return;
        }

        post(n.left);
        post(n.right);

        System.out.print(n + " ");
    }

    public static void main (String [] args) {

        Node root = new Node(
                5,
                new Node(2,
                        new Node(1, null, null),
                        new Node(3, null, null)),
                new Node(7,
                        new Node(6, null, null),
                        new Node(8, null, null))

        );

        inner(root);

        System.out.println();

        pre(root);

        System.out.println();

        post(root);

        //Node newRoot = delete(root, 2);

        //inner(newRoot);

    }

}
