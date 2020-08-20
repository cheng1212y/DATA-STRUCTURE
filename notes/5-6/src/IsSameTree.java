/**
 * @Description:  判断两个二叉树是否相等
 * @Author: Cheng
 * @Create: 2020-05-17 16:14
 **/
/**二叉树问题先考虑一个结点做的事，其他得交给框架*/
public class IsSameTree {


    public boolean isSameTree(Node root1, Node root2) {
        // 都为空的话，显然相同
        if (root1 == null && root2 == null) return true;
        // 一个为空，一个非空，显然不同
        if (root1 == null || root2 == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (root1.val != root2.val) return false;

        // root1 和 root2 比较是相等的
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

}
