package hashbuckgeneric;

import java.util.Objects;

/**
 * @Description:   哈希桶的泛型版本
 * @Author: Cheng
 * @Create: 2020-05-29 21:02
 **/  class Person {
    public int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class hashbuckgeneric <K,V>{
        static class Node<K,V> {   //内部类的 结点
            public K key;
            public V val;
            public Node<K,V> next;
            public Node(K key,V val) {
                this.key = key;
                this.val = val;
            }
        }
    /**-----------哈希桶底层数组--------------------*/
        public Node<K,V>[] array = (Node<K,V>[])new Node[10];
        public int usedSize;
    /**------------1、哈希桶中添加操作--------------------*/
        public void put(K key,V val) {
            int hash = key.hashCode();
            int index = hash % array.length;//哈希函数计算key值的对应在数组中的索引
            for (Node cur = array[index];cur != null;cur = cur.next) {//遍历索引位置所挂载的链表
                if(cur.key.equals(key)) {
                    cur.val = val; //key相同 更新val值
                    return;
                }
            }
            Node<K,V> node = new Node<>(key,val);
            node.next = array[index];
            array[index] = node;
            this.usedSize++;
        }

        /**----2、get方法---------*/
        public V get(K key) {
            //1、找位置
            //2、遍历单链表开始找  找到返回val值
            int hash = key.hashCode();
            int index = hash % array.length;
            Node<K,V> cur = array[index];
            while (cur != null) {
                if(cur.key.equals( key) ) {
                    return  cur.val;
                }
                cur = cur.next;
            }
            return null;
        }

        public static void main(String[] args) {
            Person person1 = new Person(12);
            Person person2 = new Person(12);
            System.out.println(person1.hashCode());
            System.out.println(person2.hashCode());

            System.out.println(person1.equals(person2));
        }
    }

