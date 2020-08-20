package equals;

/**
 * @Description:         引用类型的比较是否相等 需要重写 equals方法，否则调用默认的Object的equals方法比较的是地址
 *                       缺点：  因为所有类都是继承自 Object 的，所以直接覆写即可，不过只能比较相等与
 *                               否，equal只能按照相等进行比较，不能按照大于、小于的方式进行比较。
 * @Author: Cheng
 * @Create: 2020-05-27 12:07
 **/

/**1. 如果指向同一个对象，返回 true
 2. 如果传入的为 null，返回 false
 3. 如果传入的对象类型不是 Card，返回 false
 4. 按照类的实现目标完成比较，例如这里只要花色和数值一样，就认为是相同的牌
 */

class Card {
    public int rank;   //数值
    public String suit;//花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null  || !(o instanceof Card)){
            return false;   /**对象0不是Card的一个实例或者子类*/
        }
        Card card = (Card) o; //对象强制转换为Card类型
        if (this.rank == card.rank && this.suit ==card.suit  ) {
            return true;
        }
        return false;
    }
}
public class Test {
    public static void main(String[] args) {
        Card card1 = new Card(6,"♥");
        Card card2= new Card(6,"♥");
        Card card3 = new Card(9,"♦");
        System.out.println( card1.equals(card2));
        System.out.println( card1.equals(card3));















    }







}
