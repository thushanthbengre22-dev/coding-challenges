package com.bengre.educative.io.common;

public class EduTreeNode {
    int data;
     public EduTreeNode left;
     public EduTreeNode right;
     public EduTreeNode parent;

     public EduTreeNode(int value) {
         this.data = value;
         this.left = null;
         this.right = null;
         this.parent = null;
     }
}
