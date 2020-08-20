/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-15 20:09
 **/
public class Test {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();      //调用方法得到二叉树

        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();

        binaryTree.postOrderTraversal(root);
        System.out.println();

        binaryTree.getSize1( root);
        System.out.println("结点的个数:"+binaryTree.size);

        System.out.println(binaryTree.getSize2(root));

        binaryTree.getLeafSize1(root);
        System.out.println(binaryTree.leafSize);


        System.out.println(binaryTree.getLeafSize2(root));


        System.out.println(binaryTree.getKLevelSize(root, 2));

        System.out.println("===二叉树高度====");
        System.out.println(binaryTree.getHeight(root));
        System.out.println("===查找val====");
        Node ret = binaryTree.find(root, 'B');
        System.out.println(ret.val);

    }
}
