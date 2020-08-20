import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:  生成一副扑克牌  并且能够洗牌 最后轮流接牌
 * @Author: Cheng
 * @Create: 2020-05-14 11:04
 **/

/**  构造一张牌 */
class Card {
    public int rank ; //牌面的值
    public String suit; //牌的花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    @Override
    public String toString() {
        return String.format( "[%s, %-2d]",suit,rank); //自己调整的一种格式7
    }
}


public class TestCard {
    public static final String [] SUITS = {"♠", "♥", "♣", "♦"}; //牌的花色

    /**1、买一副牌*/
    private  static List<Card> buy ( ) {
        List<Card> deck = new ArrayList<>();  //新建一个Card类型的顺序表 来存储牌
        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <= 13 ; j++) {
                String suit = SUITS [i];
                int rank = j;
                Card card = new Card(rank ,suit); //构造了一张牌
                deck.add(card);                   //把牌添加进顺序表
            }
        }
        return deck;            //deck里面存储的就是一副牌
    }

    /**2、打乱一副牌*/
    private static void shuffle( List<Card> deck ) {
        for (int i = deck.size()-1; i>0; i--) {
            Random random = new Random();
            int index = random.nextInt(i);  //生成的参数是 [0,i) 左闭右开区间
            //tmp = [index]
            //[index] = [i]
            //[i] = tmp;
            Card tmp = deck.get(index);
            deck.set(index,deck.get(i));
            deck.set(i,tmp);
        }
    }



    public static void main(String[] args) {
        //1、买一副牌
        System.out.println("买牌:");
        List<Card> deck=  buy();
        System.out.println(deck);
        //2、洗牌
        System.out.println("洗牌:");

          shuffle( deck );
        System.out.println(deck);

        /**3、三人轮流接牌*/
        System.out.println("接牌:");

        List<  List<Card>   > hand = new ArrayList<>();  //想象为一个二维数组的结构

        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <3 ; j++) {
                Card card = deck.remove(0); //每次删除0位置就相当于接走了上面的一张牌
                hand.get(j).add(card); //每次hand 的0、1、2 三个人接一张牌
            }
        }
        System.out.println("第1个人的牌：");
        System.out.println(hand1);
        System.out.println("第2个人的牌：");
        System.out.println(hand2);
        System.out.println("第3个人的牌：");
        System.out.println(hand3);
        System.out.println("剩下的牌：");
        System.out.println(deck);


    }





}
