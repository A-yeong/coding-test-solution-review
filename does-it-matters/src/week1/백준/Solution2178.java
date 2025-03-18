import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2178 {
    record Point(int y, int x, int count) {}

    public static int solution(String[] maze) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length()];
        int[] dy = {0,  0, 1, -1};
        int[] dx = {1, -1, 0,  0};

        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.y == maze.length -1 && current.x == maze[0].length() -1) {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int currentY = current.y + dy[i];
                int currentX = current.x + dx[i];
                if (currentY >= 0 && currentY < maze.length && currentX >= 0 && currentX < maze[0].length() && !visited[currentY][currentX] && maze[currentY].charAt(currentX) == '1') {
                    visited[currentY][currentX] = true;
                    queue.offer(new Point(currentY, currentX, current.count + 1));
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        final int N = input.nextInt();
//        final int M = input.nextInt();
//        input.nextLine();
//
//        String[] maze = new String[N];
//        for (int i = 0; i < N; i++) {
//            maze[i] = input.nextLine();
//        }

        String[][] mazes = {
                {
                    "101111",
                    "101010",
                    "101011",
                    "111011",
                },
                {
                        "110110",
                        "110110",
                        "111111",
                        "111101"
                },
                {
                        "1011101110111011101110111",
                        "1110111011101110111011101"
                },
                {
                        "1011111",
                        "1110001",
                        "1000001",
                        "1000001",
                        "1000001",
                        "1000001",
                        "1111111"
                },
        };

        for (String[] maze: mazes) {
            System.out.println(solution(maze));
        }
    }
}