package bstree;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-28 20:23
 **/
public class Test {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int [] arr = { 12,8,30,2,10,20,49,16,35,50,44};
        for (int i = 0; i <arr.length ; i++) {
            bsTree.insert(arr[i]);
        }
        System.out.print("前序遍历：");
        preOrder(bsTree.root);
        System.out.print("中序遍历：");
        inOrder( bsTree.root );
        System.out.println();
        System.out.println(bsTree.search(2).val);
        bsTree.remove(30);

        System.out.println("-----------");
        System.out.print("前序遍历：");
        preOrder(bsTree.root);
        System.out.print("中序遍历：");
        inOrder( bsTree.root );
        System.out.println();
        System.out.println(bsTree.search(30).val);



    }













    /**  前序遍历 */
    public  static void  preOrder ( BSTree.Node root ) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    /**  中序遍历 */
    public  static void  inOrder ( BSTree.Node root ) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

}
