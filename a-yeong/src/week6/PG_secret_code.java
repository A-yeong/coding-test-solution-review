package src.week6;

import java.util.HashSet;
import java.util.Set;

public class PG_secret_code {

    public static String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()){
            skipSet.add(c);
        }
        for(char c : s.toCharArray()) {
            int cnt = index;
            while(cnt > 0) {
                c++;
                if(c > 'z')
                    c = 'a';
                if(!skipSet.contains(c))
                    cnt--;
            }
            answer = answer + c;
        }

        System.out.println(answer);
        return answer;

    }

    public static void main(String[] args) {
        solution("aukks", "wbqd", 5);
    }
}
