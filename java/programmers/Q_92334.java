package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q_92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //누가 누구를 신고했는지
        Map<String, Set<String>> reporterMap = new HashMap<>();
        //신고당한사람
        Map<String, Integer> reportedMap = new HashMap<>();
        //중복신고 제거
        Set<String> reports = new HashSet<>(Arrays.asList(report));

        //초기화
        for (int i = 0; i < id_list.length; i++) {
            reporterMap.put(id_list[i], new HashSet<>());
            reportedMap.put(id_list[i], 0);

        }

        for (String singo : reports) {
            String[] split = singo.split(" ");
            String reporter = split[0];
            String reported = split[1];
            reporterMap.get(reporter).add(reported);
            reportedMap.put(reported, reportedMap.get(reported) + 1);
        }

        //메일 발송
        for (int i = 0; i < id_list.length; i++) {
            for (String a : reporterMap.get(id_list[i])) {
                if (reportedMap.get(a) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    @Test
    public void test1() {
        Assertions.assertArrayEquals(
            solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                     new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                     2),
            new int[]{2, 1, 1, 0});
    }

    @Test
    public void test2() {
        Assertions.assertArrayEquals(
            solution(new String[]{"con", "ryan"},
                     new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                     3),
            new int[]{0, 0});
    }
}







