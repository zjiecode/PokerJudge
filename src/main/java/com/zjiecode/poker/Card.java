package com.zjiecode.poker;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    private static Map<String, Integer> codes;

    static {
        codes = new HashMap<>();
        codes.put("2", 2);
        codes.put("3", 3);
        codes.put("4", 4);
        codes.put("5", 5);
        codes.put("6", 6);
        codes.put("7", 7);
        codes.put("8", 8);
        codes.put("9", 9);
        codes.put("T", 10);
        codes.put("J", 11);
        codes.put("Q", 12);
        codes.put("K", 13);
        codes.put("A", 14);
    }


    /**
     * 点数
     */
    private String name;
    /**
     * 编码
     */
    private int code;
    /**
     * 花色
     */
    private String type;

    public Card(String name, String type) {
        this.name = name;
        this.code = codes.get(name);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Card o) {
        return code - o.code;
    }
}
