import java.util.HashSet;
import java.util.Set;

public class Q_42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Set<String> completionSet = new HashSet();

        for(String name : completion){
            completionSet.add(name);
        }

        for(String name : participant){
            if(!completionSet.contains(name)){
                answer = name;
                break;
            }
        }



        return answer;
    }


}



