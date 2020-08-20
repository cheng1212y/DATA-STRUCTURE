import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 *                          1、二叉树的 层序遍历
 *                          2、判断是否为完全二叉树
 *                          3、非递归实现 前中后三种遍历
 *
 * @Author: Cheng
 * @Create: 2020-05-19 15:58
 **/
class Node {
    public char val;              //值为字符ABC
    public Node left;//左孩子-》左子树
    public Node right;//右孩子-》右子树

    public Node(char val) {
        this.val = val;
    }
}


public class BinaryTree {

    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

            /**--------------1、层序遍历--------非递归借助队列--------*/
            public  void levelOrderTraversal(Node root) {
                if ( root == null ) {
                    return ;
                }
                Queue< Node> queue = new LinkedList<>();
                //队列不为空 入队
                queue.offer(root);
                while ( !queue.isEmpty()) {   //队列不为空的时候打印

                    //每一次进入这个循环，就相当于是每一层的数据
                    Node cur =queue.poll();  //cur记录的是队头 每次删除

                    if (cur != null) {                   //cur不为空的时候 打印cur 并且将左右入队
                        System.out.print (cur.val + " ");
                        if (  cur.left != null ) {
                            queue.offer(cur.left);
                        }
                        if (  cur.right != null ) {
                            queue.offer(cur.right);
                        }
                    }
                }
                System.out.println();
            }


            /**--------------2、断一棵树是不是完全二叉树--------*/
            public boolean isCompleteTree(Node root) {
                if (root == null) {
                    return  false;
                }
                Queue<Node> queue = new LinkedList<>();
                queue.offer( root);
                // 1、队列不为空
                Node cur = null;
                while ( !queue.isEmpty()) {
                //2、cur不为空的时候
                     cur = queue.poll();
                    if (cur!= null) {
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    }else {
                        break;  //cur为空了就去检查队列
                    }
                }
                //3、如果队列中都存放的是null  那么是完全二叉树 有一个不是就不是
                while (  !queue.isEmpty() ) {
                    Node cur2 = queue.peek();
                    if ( cur2 != null) {
                        return false;
                    }
                    else {
                        queue.poll();
                    }
                }
                return true;
            }




            /**--------------3、非递归前序遍历--------借助栈----*/
          public   void preOrderTraversal(Node root) {
              Stack<Node> stack = new Stack<>();
              if ( root == null) {
                  return;
              }
              Node cur = root;
              //栈不为空的情况 是为了重新确定top的位置
              while (cur != null || !stack.empty()) {

                  while (cur != null) {
                      stack.push(cur);
                      System.out.print( cur.val+" ");
                      cur = cur.left;
                  }
                  //栈顶的top可以弹出并记录是为了找到cur的右树
                  Node top = stack.pop();
                  cur = top.right;
              }
              System.out.println();
            }




            /**--------------4、非递归中序遍历--------*/
            public void inOrderTraversal(Node root) {
                Stack<Node> stack = new Stack<>();
                if ( root == null) {
                    return;
                }
                Node cur = root;
                //栈不为空的情况 是为了重新确定top的位置
                while (cur != null || !stack.empty()) {
                    while (cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    }
                    //栈顶的top可以弹出并记录是为了找到cur的右树
                    Node top = stack.pop();
                    System.out.print( top.val+" ");   //注意比较和前序遍历 只是打印时候位置改变了
                    cur = top.right;
                }
                System.out.println();
            }
            /**--------------5、非递归后序遍历--------*/
            public void postOrderTraversal(Node root) {
                Stack<Node> stack = new Stack<>();
                if ( root == null) {
                    return;
                }
                Node cur = root;
                Node prev = null;
                //栈不为空的情况 是为了重新确定top的位置
                while (cur != null || !stack.empty()) {
                    while (cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    }
                    // cur 拿到的是栈顶元素 相当于上一个cur的父节点
                     cur = stack.peek();
                    //右边等于空 直接打印根节点
                    if ( cur.right == null || cur.right == prev) {  /** 1、右边为空------或者右边被打印过了 ，就可以打印根节点了*/
                        System.out.print(cur.val+ " ");
                        stack.pop();
                        prev = cur;   /**2、加prev是为了防止cur无线循环的进入else去打印右子树*/
                        cur =null;    /** 3、防止进入上层的循环后 再次将cur入队*/
                    }
                    else {  //不为空 就将cur指向它的右
                        cur = cur.right;
                    }
                }
                System.out.println();
             }

             /**
              *
              *   进阶二叉树题型
              *
              *
              * */


            /**--------1、根据字符串构建二叉树--------------*/
            public int i = 0;
            public Node myBuildTre ( String str) {
                    Node root = null;
                    if(str.charAt(i) != '#') {
                        root = new Node(str.charAt(i));
                        i++;
                        root.left = myBuildTre(str);
                        root.right = myBuildTre(str);
                    }else {
                        i++;
                    }
                    return root;
                }

             /**3、给定一个二叉树, 找到该树中两个指定节点的最近公共祖先*/

             public Node lowestCommonAncestor(Node root, Node p, Node q) {
                 if ( root == null) {
                     return null;
                 }
                 //1、root就是祖先
                 if ( root == p || root == q) {
                     return root;
                 }
                //2、递归的去左右树中寻找
                 Node left = lowestCommonAncestor(root.left,  p,  q);
                 Node right = lowestCommonAncestor(root.right,  p,  q);

                 // 第一种情况 pq分布在root左右
                 if ( left != null && right != null) {
                     return root;
                 }
                 // 第二种情况 pq分布在root左
                 else if ( left != null ) {
                     return left;
                 }
                 // 第二种情况 pq分布在root右
                 else {
                     return right;
                 }
             }




 }



