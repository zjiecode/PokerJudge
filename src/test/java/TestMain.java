import com.zjiecode.poker.JudgeManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestMain {

    @Test
    public void testMain() {
        String[] names = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        String[] types = new String[]{"H", "D", "S", "C"};
        List<String> cards = new ArrayList<>();
        for (String name : names) {
            for (String type : types) {
                cards.add(name + type);
            }
        }
        while (true) {
            String cards1 = generate(cards);
            String cards2 = generate(cards);
            String s1 = JudgeManager.getInstance().judge(cards1, cards2);
            System.out.println(s1);
        }
    }

    /**
     * 随机生成一副牌
     */
    private static String generate(List<String> cards) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<String> test = new ArrayList<>(cards);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(test.remove(random.nextInt(test.size())));
        }
        return stringBuilder.toString();
    }
}
