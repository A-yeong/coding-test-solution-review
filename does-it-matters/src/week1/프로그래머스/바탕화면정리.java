import java.util.Arrays;

public class Main {
    public static int[] solution(String[] wallpaper) {
        final int WIDTH = wallpaper[0].length();
        final int HEIGHT = wallpaper.length;

        int u = 0, d = HEIGHT - 1, l = 0, r = WIDTH - 1;

        // - 위아래로 한 번 찾기
        for (; !wallpaper[u].contains("#"); u++){
        }
        l = wallpaper[u].indexOf("#");
        r = wallpaper[u].lastIndexOf("#");

        for (; !wallpaper[d].contains("#"); d--){
        }
        l = Math.min(wallpaper[d].indexOf("#"), l);
        r = Math.max(wallpaper[d].lastIndexOf("#"), r);

        // - 확인한 위 아래 줄을 제외하고 좌우에서 찾기
        // 캐시 지역성을 고려하면 좋지 못한 알고리즘
        outer: for (int j = 0; j < l; j++) {
            for (int i = u + 1; i < d; i++){
                if (wallpaper[i].charAt(j) == '#'){
                    l = j;
                    break outer;
                }
            }
        }

        outer: for (int j = WIDTH - 1; r < j; j--) {
            for (int i = u + 1; i < d; i++){
                if (wallpaper[i].charAt(j) == '#'){
                    r = j;
                    break outer;
                }
            }
        }

        return new int[]{u, l, d + 1, r + 1};
    }

    public static void main(String[] args) {

        String[][] wallpapers = {
                {
                    ".#...",
                    "..#..",
                    "...#."
                },
                {
                    "..........",
                    ".....#....",
                    "......##..",
                    "...##.....",
                    "....#....."
                },
                {
                    ".##...##.",
                    "#..#.#..#",
                    "#...#...#",
                    ".#.....#.",
                    "..#...#..",
                    "...#.#...",
                    "....#...."
                },
                {
                    "..", "#."
                }
        };

        for (String[] wallpaper: wallpapers) {
            System.out.println(Arrays.toString(solution(wallpaper)));
        }
    }
}