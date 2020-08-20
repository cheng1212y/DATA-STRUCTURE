import java.util.Arrays;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-19 16:00
 **/
public class TestMain {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        Node root = binaryTree.buildTree();
        System.out.println("========1、层序遍历==========");
        binaryTree.levelOrderTraversal(root );
        System.out.println("========2、判断完全二叉树==========");
        System.out.println(binaryTree.isCompleteTree(root));
        System.out.println("========3、前序遍历===非递归=======");
        binaryTree.preOrderTraversal(root);
        System.out.println("========4、中序遍历===非递归=======");
        binaryTree.inOrderTraversal(root);
        System.out.println("========5、后序遍历===非递归=======");
        binaryTree.postOrderTraversal(root);
        System.out.println(  "=====================================");
        System.out.println("="+         "进阶二叉树"            +"=");
        System.out.println(  "=====================================");

        System.out.println("========1、根据字符串构建二叉树=======");
        Node root22 = binaryTree.myBuildTre( "ABC##DE#G##F###");
        binaryTree.inOrderTraversal(root22);








    }}

