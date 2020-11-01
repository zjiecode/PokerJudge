package com.zjiecode.poker.judge;

import com.zjiecode.poker.Card;
import com.zjiecode.poker.judge.base.BaseJudge;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class DFlushJudge extends BaseJudge {
    public static final String TYPE_NAME = "Flush";
    private static final int TYPE_CARD_TYPE_COUNT = 1;

    @Override
    public List<Card> getCardType(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getType));
        //只有一种花色
        if (collect.size() == TYPE_CARD_TYPE_COUNT) {
            return cards;
        }
        return null;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
