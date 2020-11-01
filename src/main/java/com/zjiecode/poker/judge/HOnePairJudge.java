package com.zjiecode.poker.judge;

import com.zjiecode.poker.Card;
import com.zjiecode.poker.judge.base.BaseJudge;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class HOnePairJudge extends BaseJudge {
    public static final String TYPE_NAME = "OnePair";
    private static final int TYPE_CARD_TYPE_COUNT = 4;
    private static final int TYPE_CARD_NAME_COUNT_2 = 2;
    private static final int TYPE_CARD_NAME_COUNT_1 = 1;

    @Override
    public List<Card> getCardType(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getName));
        if (collect.size() != TYPE_CARD_TYPE_COUNT) {
            return null;
        }
        List<Integer> counts = new ArrayList<>();
        counts.add(TYPE_CARD_NAME_COUNT_2);
        counts.add(TYPE_CARD_NAME_COUNT_1);
        counts.add(TYPE_CARD_NAME_COUNT_1);
        counts.add(TYPE_CARD_NAME_COUNT_1);
        Collection<List<Card>> values = collect.values();
        for (List<Card> value : values) {
            if (counts.isEmpty()) {
                return null;
            }
            counts.remove(Integer.valueOf(value.size()));
        }
        if (!counts.isEmpty()) {
            return null;
        }
        List<Card> result = new ArrayList<>();
        List<Card> point = new ArrayList<>();
        for (List<Card> value : collect.values()) {
            if (value.size() == TYPE_CARD_NAME_COUNT_2) {
                result.add(value.get(0));
            } else {
                point.add(value.get(0));
            }
        }
        Collections.sort(result);
        Collections.sort(point);
        point.addAll(result);
        return point;
    }


    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
