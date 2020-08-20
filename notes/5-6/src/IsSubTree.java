/**
 * @Description: 判断一个数是否是另一个树的子树 t树在s中对比 s中t开始往后的子孙结点都看
 * @Author: Cheng
 * @Create: 2020-05-17 16:50
 **/
public class IsSubTree {
    public boolean isSubtree(Node s, Node t) {
        if( s == null || t == null ) {
            return false;
        }
        //两树相同
        if(  isSameTree( s,  t)  ) return true;
        //t是否是s左树的子树
        if(isSubtree(s.left, t)) return true;
        //t是否是s右树的子树
        if(isSubtree(s.right, t))return true;
        return false;

    }

    public static boolean isSameTree(Node s, Node t) {
        // 都为空的话，显然相同
        if (s == null && t == null) return true;
        // 一个为空，一个非空，显然不同
        if (s == null || t == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (s.val != t.val) return false;

        // root1 和 root2 该比的都比完了
        return isSameTree(s.left, t.left)
                && isSameTree(s.right, t.right);
    }

}
