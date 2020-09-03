package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname PokerOrder
 * @Created by zgw
 * @Date 2020-08-29 10:31
 * @Description 扑克牌排序
 */
public class PokerOrder {
    public static void main(String[] args) {

        String[] cards={"s1","s3","s9","s4","h1","p3","p3","q5","q4","q9","k2","k1"};
        String[] ret = getPokerOrder(cards);
        for (String r:ret
             ) {

            System.out.println(r);
        }
        for (String r:cards
        ) {

            System.out.println(r);
        }
    }
    public static String[] getPokerOrder(String[] cards){
        Arrays.sort(cards, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                char[] c1= s.toCharArray();
                char[] c2= t1.toCharArray();
                switch (c1[0]){
                    case 'k': c1[0]='a';break;
                    case 's': c1[0]='b';break;
                }
                switch (c2[0]){
                    case 'k': c2[0]='a';break;
                    case 's': c2[0]='b';break;
                }
                //第一个比较之后，相同则比较第二个，否则按第一个顺序
                if (c1[0]==c2[0]){
                    return c1[1]-c2[1];
                }
                //按照 k s h p q
                return c1[0]-c2[0];
            }
        });
        return cards;
    }
}
