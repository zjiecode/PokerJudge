package com.zjiecode.poker.judge.base;

import com.zjiecode.poker.Card;

import java.util.List;

public interface IJudge {

    /**
     * 获取一副牌的牌型，如果没有就返回null
     *
     * @param cards 一副牌
     * @return 匹配到牌型后，从小到达返回剩余的比较点数
     */
    List<Card> getCardType(List<Card> cards);

    /**
     * 裁判
     *
     * @param cards1 玩家1的牌
     * @param cards2 玩家@的牌
     * @return 返回不为空表示有结果了
     */
    String judge(List<Card> cards1, List<Card> cards2);

    /**
     * 获取牌型名字
     *
     * @return 返回牌型名字
     */
    String getTypeName();
}
