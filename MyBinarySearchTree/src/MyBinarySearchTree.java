/**
 * @Description:    手动实现二叉搜索树  Binary Search Tree
 *
 *          二叉搜索树又称二叉排序树，它或者是一棵空树**，或者是具有以下性质的二叉树:
 *          1、若它的左子树不为空，则左子树上所有节点的值都小于根节点的值
 *          2、若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
 *          3、它的左右子树也分别为二叉搜索树
 * @Create: 2020-08-23 19:08
 **/
public class MyBinarySearchTree {
        public static class Node {  //内部类 结点
            public int val ;
            public Node left ;
            public Node right ;

            public Node(int val) {  //构造方法构造结点
                this.val = val;
            }
        }
        public Node root = null; //BST的根结点置为空

        /** -----------1、插入一个元素----------*/
        public  boolean insert ( int val ) {
            Node node = new Node(val);  //构造一个结点
            if ( root == null) {       //根为空，新结点就置为根结点
                root = node;
                return true;
            }
            // 根结点不为空的情况
            Node parent =null;   //记录的是cur的父亲结点
            Node cur = root;
            while (cur != null) {
                if (cur.val == val) {  //BST中不能有重复的值
                    return false;
                }
                else if ( val <cur.val ) {  //小于往左走，parent记录cur的父亲结点
                    parent = cur;
                    cur = cur.left;
                }
                else {                  //大于就往右边走
                    parent = cur;
                    cur = cur.right;
                }
                //此时cur已经为空， parent记录的是叶子结点的值，添加的时候是往p上加
                //两种情况---->判断添加的左右位置
            }
            if (val<parent.val) {
                parent.left =node;
            }
            else {
                parent.right=node;
            }
            return true;
        }


        /** -----------2、查找一个元素----------*/
        public Node search ( int key ) {
            Node cur = this.root;
            while ( cur != null) {
                if (key < cur.val) {
                    cur = cur.left;
                }else if (key>cur.val){
                    cur =cur.right;
                }
                else {
                    return cur;
                }
            }
            //这个null包含了
            // 1、没找到val
            // 2、root为null的情况
            return null;
        }

        /** -----------3、删除一个元素----------*/
        public void  removeNode  ( Node parent,Node cur) {//cur是要删除的结点
            //1、左为空的大情况
            if ( cur.left == null) {
                if (cur == root) { //根结点
                    root = cur.right;
                }else if (cur == parent.left) {//cur是p的左
                    parent.left = cur.right;
                }else {                        //cur是p的右
                    parent.right = cur.right;
                }

                //2、右为空的大情况
            }else if ( cur.right == null){
                if ( cur == root) {         //根结点
                    root =cur.left;
                }else if (cur==parent.left ) {  //cur是p的左
                    parent.left = cur.left;
                }else {                         //cur是p的右
                    parent.right = cur.left;
                }

                //3、左右都不为空的大情况
            }else {
                /**去cur的右树找最小值为cur的替罪羊
                 将替罪羊覆盖为cur的值
                 删除掉替罪羊结点*/
                Node targetParent = cur;
                Node target = cur.right;//去右边找最小值
                while ( target.left!= null) {
                    targetParent = target;
                    target = targetParent.left;
                }
                //此时替罪羊找到，将它覆盖掉删除结点
                if ( targetParent.left == target) {
                    cur.val = target.val;   //替罪羊去覆盖删除结点
                    targetParent.left = target.right;//删除掉替罪羊结点
                }
                //cur的右孩子 就是替罪羊
                else {
                    cur.val = target.val;
                    targetParent.right = target.right;
                }
            }
        }

        public boolean remove (int key ) {
            Node cur = this.root;
            Node parent =null; //记录要删除结点的父亲
            while ( cur != null) {
                if ( cur.val==key ) {  //找到这个key就可以进行删除
                    removeNode ( parent,cur); //具体的删除细节操作封装在外面
                    return true;
                }else if ( key < cur.val) {
                    parent = cur;
                    cur = cur.left;
                }else {
                    parent = cur;
                    cur = cur.right;
                }
            }
            //只有删除成功才会返回true
            //这个false包含了 没找到要删除的val和root为null的情况
            return false;
        }
    }

