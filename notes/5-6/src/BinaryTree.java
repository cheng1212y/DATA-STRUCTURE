
/**
 * @Description:         二叉树的遍历、计算结点、深度
 * @Author: Cheng
 * @Create: 2020-05-15 20:09
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

        /** 1、前序遍历   递归来实现*/
      public   void preOrderTraversal(Node root){
            if(root == null) {
                return;
            }
            System.out.print(root.val +" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

       /** 2、中序遍历   递归来实现*/
      public   void inOrderTraversal(Node root){
            if(root == null) {
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.val+" ");
            inOrderTraversal(root.right);
        }
       /** 3、后序遍历   递归来实现*/
      public   void postOrderTraversal(Node root){
            if(root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val+" ");
        }


        /**4、 遍历思路-求结点个数*/
      static int size = 0;
      public void getSize1(Node root) {
          if(root == null) {
              return ;
          }
          size++;                  //不为空的结点
          getSize1(root.left);
          getSize1(root.right);
      }
        // 子问题思路-求结点个数 左数个数+右数个数+1
      public  int getSize2(Node root){
            if(root == null) {
                return 0;
            }
           int a =  getSize2(root.left);
           int b =  getSize2(root.right);
           return a+b+1;
        }


       /**5、遍历思路-求叶子结点个数 */
        static int leafSize = 0;
       public void getLeafSize1(Node root) {
            if(root == null) {
                return ;
            }
            if (root.left == null && root.right == null) {
                leafSize++;                     //叶子节点的 左右孩子为空
            }
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }

        // 子问题思路-求叶子结点个数
       public int getLeafSize2(Node root) {
            if(root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int a =  getLeafSize2(root.left);
            int b =  getLeafSize2(root.right);
            return a+b ;
        }


    /**6、子问题思路-求第 k 层结点个数*/
     public int getKLevelSize(Node root ,int k) {

         if (root == null) {
             return 0;
         }
         else if ( k == 1) {
             return 1;
         }
         else {
             return   getKLevelSize( root.right , k-1) +
                     getKLevelSize(root.left , k-1);
         }

    }


         /**7、获取二叉树最大深度*/
         public int getHeight(Node root) {
             if (root == null) {
                 return 0;
             }
             int left = getHeight(root.left);  //需要保存 左右树的高度
             int right = getHeight(root.right); //否则在三目运算符中+1的时候递归会再次计算 产生超时
             return left > right ? left + 1 : right + 1;
         }
         /**8、查找 val 所在结点，没有找到返回 null*/
        // 按照 根 -> 左子树 -> 右子树的顺序进行查找
        // 一旦找到，立即返回，不需要继续在其他位置查找
         public Node find(Node root, char val) {
             if (root == null) {
                 return null;
             }
             //1、判断根节点是否是查找的数字val
             if (root.val == val) {
                 return root;
             }
             //2、左边找 左边全部递归完成后 去右边找
             Node left = find(root.left, val);
             if (left != null) {
                 return left;
             }
             //3、右边找
             Node right = find(root.right, val);
             if (right != null) {
                 return right;
             }
             //两边都没找到
             return null;
         }
    }


