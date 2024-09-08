import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        if (p == null) {
            if (q != null) return false;
        } else {
            if (q == null) return false;

            pQueue.offer(p);
            qQueue.offer(q);
        }

        while (!pQueue.isEmpty()) {
            p = pQueue.poll();
            q = qQueue.poll();

            if (p.val != q.val) return false;

            if (p.left == null) {
                if (q.left != null) return false;
            } else {
                if (q.left == null) return false;
                pQueue.offer(p.left);
                qQueue.offer(q.left);
            }
            if (p.right == null) {
                if (q.right != null) return false;
            } else {
                if (q.right == null) return false;
                pQueue.offer(p.right);
                qQueue.offer(q.right);
            }
        }

        return qQueue.isEmpty();
    }
}