import java.util.ArrayDeque;
import java.util.Deque;

public class Solution18258 {
    public static void solution(String[] commands) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (String command: commands) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "push":
                    queue.offer(Integer.parseInt(tokens[1])); break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.poll()); break;
                case "size":
                    System.out.println(queue.size()); break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0); break;
                case "front":
                    System.out.println(queue.getFirst()); break;
                case "back":
                    System.out.println(queue.getLast()); break;
            }
        }
    }

    public static void main(String[] args) {

        String[][] commandsSet = {
                {
                    "push 1",
                    "push 2",
                    "front",
                    "back",
                    "size",
                    "empty",
                    "pop",
                    "pop",
                    "pop",
                    "size",
                    "empty",
                    "pop",
                    "push 3",
                    "empty",
                    "front"
                }
        };

        for (String[] commands: commandsSet) {
            solution(commands);
        }
    }
}