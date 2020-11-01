package com.zjiecode.poker.judge;

import com.zjiecode.poker.Card;
import com.zjiecode.poker.judge.base.BaseJudge;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class IHighCard extends BaseJudge {
    public static final String TYPE_NAME = "HighCard";

    @Override
    public List<Card> getCardType(List<Card> cards) {
        return cards;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
