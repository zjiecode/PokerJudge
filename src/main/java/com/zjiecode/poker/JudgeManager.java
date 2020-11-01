package com.zjiecode.poker;

import com.zjiecode.poker.judge.*;
import com.zjiecode.poker.judge.base.IJudge;

import java.util.ArrayList;
import java.util.List;

public class JudgeManager {
    public static final String TIE = "tie";
    private List<IJudge> judges = new ArrayList<>();
    private static JudgeManager sInstance;

    private JudgeManager() {
        judges.add(new AStraightFlushJudge());
        judges.add(new BFourOfAKindJudge());
        judges.add(new CFullHouseJudge());
        judges.add(new DFlushJudge());
        judges.add(new EStraightJudge());
        judges.add(new FThreeOfAKindJudge());
        judges.add(new GTwoPairJudge());
        judges.add(new HOnePairJudge());
        judges.add(new IHighCard());
    }

    public static JudgeManager getInstance() {
        if (sInstance == null) {
            sInstance = new JudgeManager();
        }
        return sInstance;
    }

    /**
     * 裁判2个玩家的输赢
     */
    public String judge(String player1, String player2) {
        List<Card> cards1 = CardFactory.createCards(player1);
        List<Card> cards2 = CardFactory.createCards(player2);
        for (IJudge judge : judges) {
            String result = judge.judge(cards1, cards2);
            if (result != null) {
                return result;
            }
        }
        //平手
        return TIE;
    }


}
