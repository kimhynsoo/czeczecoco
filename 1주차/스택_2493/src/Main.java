import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] tower = new int[n];

        // 탑의 높이 입력
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            tower[i] = Integer.parseInt(input[i]);
        }

        // 스택을 사용하여 높은 탑 인덱스 찾기
        Stack<Integer> stack = new Stack<>();

        // 탑을 왼쪽에서 오른쪽으로 탐색
        for (int i = 0; i < n; i++) {
            // 현재 탑보다 높은 탑을 찾기
            while (!stack.isEmpty() && tower[stack.peek()] < tower[i]) {
                stack.pop(); // 현재 탑보다 낮은 탑 제거
            }
            // 결과 출력
            if (!stack.isEmpty()) {
                writer.write((stack.peek() + 1) + " "); // 1-based index
            } else {
                writer.write("0 "); // 더 높은 탑이 없을 경우
            }
            // 현재 탑의 인덱스를 스택에 추가
            stack.push(i);
        }

        // 버퍼에 저장된 내용을 출력
        writer.flush();
        writer.close();
        reader.close();
    }
}
