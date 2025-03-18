package src.week7;

/*
1. 아이디어
- 이진탐색 사용
- start를 0, end를 가장 긴 나무의 길이로 잡고 이진탐색
    - 나무를 잘랐을 때 총합이 m보다 크면 result에 값 저장하고 start를 mid로 옮겨 이진탐색 재수행
    - 나무를 잘랐을 때 총합이 m보다 작으면 end를 mid로 옮겨 이진탐색 재수행

2. 자료구조
- int start, end, mid: 이진탐색을 수행하기 위해 저장하는 값들
- int[]: 트리의 길이를 저장하는 변수

3. 시간복잡도
- 이진탐색의 시간복잡도는 O(logN)
- 최악의 경우 시간복잡도 log1000000 < 2억(자바 1초 연산 수)

4. 공간복잡도
- 나무의 수 n이 최악의 경우 1,000,000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int n, m;
    static int result = 0;
    static int start = 0;
    static int end = 0;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(input > end)
                end = input;
            trees[i] = input;
        }

        // 이진탐색 시작
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            // 잘랐을 때 나무의 길이
            for(int tree: trees) {
                if(tree > mid)
                    total += tree - mid;
            }
            // 나무가 모자랄 경우 더 많이 자름(왼쪽 탐색)
            if(total < m)
                end = mid - 1;
            // 나무가 충분한 경우 더 적게 자름(오른쪽 탐색)
            else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
