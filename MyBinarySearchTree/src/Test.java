/**
 * @Description:  测试类
 * @Author: Cheng
 * @Create: 2020-08-23 19:10
 **/

public class Test {
    public static void main(String[] args) {
        MyBinarySearchTree MyBinarySearchTree = new MyBinarySearchTree();
        int [] arr = { 12,8,30,2,10,20,49,16,35,50,44};
        for (int i = 0; i <arr.length ; i++) {
            MyBinarySearchTree.insert(arr[i]);
        }
        System.out.print("前序遍历：");
        preOrder(MyBinarySearchTree.root);
        System.out.print("中序遍历：");
        inOrder( MyBinarySearchTree.root );
        System.out.println();
        System.out.println(MyBinarySearchTree.search(2).val);
        MyBinarySearchTree.remove(30);

        System.out.println("-----------");
        System.out.print("前序遍历：");
        preOrder(MyBinarySearchTree.root);
        System.out.print("中序遍历：");
        inOrder( MyBinarySearchTree.root );
        System.out.println();
    }

    /**  前序遍历 */
    public  static void  preOrder ( MyBinarySearchTree.Node root ) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    /**  中序遍历 */
    public  static void  inOrder ( MyBinarySearchTree.Node root ) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

}
