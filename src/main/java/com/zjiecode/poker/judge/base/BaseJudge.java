package com.zjiecode.poker.judge.base;

import com.zjiecode.poker.Card;

import java.util.List;

import static com.zjiecode.poker.JudgeManager.TIE;

public abstract class BaseJudge implements IJudge {
    protected static final int ZERO = 0;
    protected static final String PLAY1 = "player1";
    protected static final String PLAY2 = "player2";
    protected static final String WIN_SAME_TYPE = "%s wins - high card:%s";
    protected static final String WIN_NOT_SAME_TYPE = "%s wins - %s";


    @Override
    public String judge(List<Card> cards1, List<Card> cards2) {
        List<Card> cardType1 = getCardType(cards1);
        List<Card> cardType2 = getCardType(cards2);
        if (cardType1 != null && cardType2 != null) {
            CompareResult compare = compare(cardType1, cardType2);
            if (compare.getCompare() == ZERO) {
                return TIE;
            }
            return String.format(WIN_SAME_TYPE, compare.getCompare() > ZERO ? PLAY1 : PLAY2, compare.getName());
        }
        if (cardType1 != null) {
            return String.format(WIN_NOT_SAME_TYPE, PLAY1, getTypeName());
        }
        if (cardType2 != null) {
            return String.format(WIN_NOT_SAME_TYPE, PLAY2, getTypeName());
        }
        return null;
    }

    /**
     * 按照点数大小匹配牌型
     */
    private CompareResult compare(List<Card> cards1, List<Card> cards2) {
        for (int i = cards1.size() - 1; i >= 0; i--) {
            Card card1 = cards1.get(i);
            Card card2 = cards2.get(i);
            int compare = card1.compareTo(card2);
            if (compare != ZERO) {
                return new CompareResult(compare, compare > ZERO ? card1.getName() : card2.getName());
            }
        }
        return new CompareResult(ZERO, null);
    }

    /**
     * 比较结果，并返回判断一副牌大小的那一张牌
     */
    static class CompareResult {
        private final int compare;
        private final String name;

        public CompareResult(int compare, String name) {
            this.compare = compare;
            this.name = name;
        }

        public int getCompare() {
            return compare;
        }

        public String getName() {
            return name;
        }
    }
}
