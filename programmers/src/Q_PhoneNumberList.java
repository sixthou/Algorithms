import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Q_PhoneNumberList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (final String s : phone_book) {
            System.out.println(s);
            for (int j = 0; j < s.length(); j++) {
                System.out.println(s.substring(0, j));
                if (set.contains(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return answer;
    }

    @Test
    public void test1(){
        Assertions.assertEquals(solution(new String[]{"119", "97674223", "1195524421"}), false);
    }

    @Test
    public void test2(){
        Assertions.assertEquals(solution(new String[]{"123","456","789"}), true);
    }

    @Test
    public void test3(){
        Assertions.assertEquals(solution(new String[]{"12","123","1235","567","88"}), false);
    }
}
