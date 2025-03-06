package src.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, p1, p2, m;
    static List<Integer>[] relations;
    static boolean[] isVisit;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        relations = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relations[x].add(y);
            relations[y].add(x);
        }
        isVisit = new boolean[n + 1];
        dfs(p1, 0);
        System.out.println(ans);
    }

    private static void dfs(int cur, int depth) {
        if (cur == p2){
            ans = depth;
            return;
        }

        isVisit[cur] = true;

        for (int next : relations[cur]) {
            if(!isVisit[next])
                dfs(next, depth + 1);
        }
    }
}
