package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_64064 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 불량 사용자
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/64064
     * 난이도 : 3
     * 유형 : dfs
     * 설명 : 카카오문제는 하나의 문제에서 다양한걸 체크하고 싶어한다는 느낌이 강하다. 미루지말고 차근차근 해보면 끝.
     * 예외 :
     **/

    Set<List<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        List<String> bannedIds = Arrays.stream(banned_id)
                .map(s -> s.replaceAll("[*]", "."))
                .collect(Collectors.toList());

        dfs(user_id, new boolean[user_id.length], banned_id.length, new ArrayList<>(), bannedIds);


        return answer.size();
    }


    public void dfs(String[] user_id, boolean[] visited, int target, List<String> pickedIds, List<String> bannedIds) {
        if (pickedIds.size() == target) {
            for (int i = 0; i < target; i++) {
                if (!pickedIds.get(i).matches(bannedIds.get(i))) {
                    return;
                }
            }
            answer.add(new ArrayList<>(pickedIds.stream().sorted().collect(Collectors.toList())));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pickedIds.add(user_id[i]);
                dfs(user_id, visited, target, pickedIds, bannedIds);
                visited[i] = false;
                pickedIds.remove(user_id[i]);
            }
        }
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] user_id, String[] banned_id, int expect) {
        Assertions.assertThat(solution(user_id, banned_id)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"12345", "aaaaa"},
                        new String[]{"*****", "*****"}, 1),
                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                        new String[]{"fr*d*", "abc1**"}, 2),
                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                        new String[]{"*rodo", "*rodo", "******"}, 2),
                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                        new String[]{"fr*d*", "*rodo", "******", "******"}, 3)
        );
    }

}
