/**
 * @Description:  镜像二叉树-------考虑左右子树是镜像、左树的左和右树的右相等
 * @Author: Cheng
 * @Create: 2020-05-18 16:21
 **/
public class IsSymmetric {
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return isSymmetricChild(root.left,root.right );
    }

    public boolean isSymmetricChild(Node leftTree,Node rightTree) {
        //有一个为空
        if(leftTree == null && rightTree != null || leftTree!=null && rightTree==null){
            return false;
        }
        //两个都为空
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val != rightTree.val) {
            return false;
        }
        //值相等的情况
        //左树的左  和右树的右
        return  isSymmetricChild(leftTree.left,rightTree.right )
                &&  isSymmetricChild(leftTree.right,rightTree.left );

    }
}
