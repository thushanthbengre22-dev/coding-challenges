package com.bengre.educative.io.twopointers;

import com.bengre.educative.io.common.EduTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowestCommonAncestorV1Test {

    private final LowestCommonAncestorV1 solver = new LowestCommonAncestorV1();

    @Test
    @DisplayName("Should find LCA in a standard binary tree structure")
    void testStandardTreeLCA() {
        // Constructing the following tree:
        //        10
        //       /  \
        //      5    15
        //     / \
        //    3   7

        EduTreeNode root = new EduTreeNode(10);
        EduTreeNode n5 = new EduTreeNode(5);
        EduTreeNode n15 = new EduTreeNode(15);
        EduTreeNode n3 = new EduTreeNode(3);
        EduTreeNode n7 = new EduTreeNode(7);

        // Establishing Parent-Child relationships
        root.left = n5; n5.parent = root;
        root.right = n15; n15.parent = root;
        n5.left = n3; n3.parent = n5;
        n5.right = n7; n7.parent = n5;

        // Case 1: Nodes on different subtrees (3 and 15) -> LCA is 10
        assertEquals(root, solver.lowestCommonAncestor(n3, n15), "LCA of 3 and 15 should be 10");

        // Case 2: Nodes on same subtree (3 and 7) -> LCA is 5
        assertEquals(n5, solver.lowestCommonAncestor(n3, n7), "LCA of 3 and 7 should be 5");
    }

    @Test
    @DisplayName("Should return p if p is the direct parent of q")
    void testParentAsLCA() {
        EduTreeNode p = new EduTreeNode(1);
        EduTreeNode q = new EduTreeNode(2);

        p.left = q;
        q.parent = p;

        // LCA of 1 and 2 is 1
        assertEquals(p, solver.lowestCommonAncestor(p, q));
    }

    @Test
    @DisplayName("Should handle a skewed tree (Linked List style)")
    void testSkewedTree() {
        EduTreeNode n1 = new EduTreeNode(1);
        EduTreeNode n2 = new EduTreeNode(2);
        EduTreeNode n3 = new EduTreeNode(3);

        n1.right = n2; n2.parent = n1;
        n2.right = n3; n3.parent = n2;

        // LCA of 1 and 3 is 1
        assertEquals(n1, solver.lowestCommonAncestor(n1, n3));
    }
}
