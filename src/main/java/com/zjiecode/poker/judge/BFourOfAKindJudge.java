package com.zjiecode.poker.judge;

import com.zjiecode.poker.Card;
import com.zjiecode.poker.judge.base.BaseJudge;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class BFourOfAKindJudge extends BaseJudge {
    public static final String TYPE_NAME = "FourOfAKind";
    public static final int TYPE_CARD_NAME_TYPE_COUNT = 2;
    public static final int TYPE_CARD_COUNT_FOUR = 4;
    public static final int TYPE_CARD_COUNT_ONE = 1;

    @Override
    public List<Card> getCardType(List<Card> cards) {
        Map<String, List<Card>> collect = cards.stream().collect(groupingBy(Card::getName));
        if (collect.size() != TYPE_CARD_NAME_TYPE_COUNT) {
            return null;
        }
        List<String> names = new ArrayList<>(collect.keySet());
        String name1 = names.get(0);
        String name2 = names.get(1);
        //一个是4张，一个是1张
        if ((collect.get(name1).size() == TYPE_CARD_COUNT_FOUR && collect.get(name2).size() == TYPE_CARD_COUNT_ONE)
                || (collect.get(name1).size() == TYPE_CARD_COUNT_ONE && collect.get(name2).size() == TYPE_CARD_COUNT_FOUR)) {
            List<Card> resultCards = new ArrayList<>();
            resultCards.add(collect.get(name1).get(0));
            resultCards.add(collect.get(name2).get(0));
            Collections.sort(resultCards);
            return resultCards;
        }
        return null;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
