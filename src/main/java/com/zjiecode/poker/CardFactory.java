package com.zjiecode.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardFactory {
    /**
     * 根据输入构造一副牌
     */
    public static List<Card> createCards(String inputStr) {
        List<Card> cards = new ArrayList<>();
        String[] s = inputStr.split(" ");
        for (String s1 : s) {
            cards.add(new Card(s1.substring(0, 1), s1.substring(1)));
        }
        //排序
        Collections.sort(cards);
        return cards;
    }
}
