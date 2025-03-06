package src.week6;

import java.util.Stack;

public class PG_make_hamburger {
    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int ing : ingredient) {
            stack.push(ing);
            if(stack.size() >= 4){
                int size = stack.size();
                if(stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}
