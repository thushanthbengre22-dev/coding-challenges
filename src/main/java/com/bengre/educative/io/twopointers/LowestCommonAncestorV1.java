package com.bengre.educative.io.twopointers;

import com.bengre.educative.io.common.EduTreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorV1 {

    public EduTreeNode lowestCommonAncestor(EduTreeNode p, EduTreeNode q) {
        if (p.parent == null) {
            return p;
        }
        if (q.parent == null) {
            return q;
        }
        Set<EduTreeNode> ancestors = new HashSet<>();
        EduTreeNode res = null;
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (ancestors.contains(q)) {
                res = q;
                break;
            }
            q = q.parent;
        }
        return res;
    }
}
