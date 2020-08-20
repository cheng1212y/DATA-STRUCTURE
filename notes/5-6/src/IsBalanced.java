/**
 * @Description: 是否为平衡二叉树-----------左右子树的高度差绝对值<2
 * @Author: Cheng
 * @Create: 2020-05-18 16:18
 **/
public class IsBalanced {
    public boolean isBalanced(Node root) {
        if(root == null ) {
            return true;
        }
        int left = getHeight( root.left  );
        int right = getHeight( root.right  );

        return Math.abs(   left-right    ) <2 &&
                isBalanced( root.left) &&
                isBalanced(root.right);
    }
    //求树的高度
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight( root.left );  //需要保存 左右树的高度
        int right = getHeight( root.right ); //否则在三目运算符中+1的时候递归会再次计算 产生超时
        return left > right ? left +1:right+1;

    }

}
