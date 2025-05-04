import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 매트리스 크기 입력
        int n = scanner.nextInt();

        // n x n 매트리스 생성
        int [][] matrix = new int[n + 1][n + 1];

        // 매트리스를 0으로 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = 0;
            }
        }

        // 사과의 개수 입력
        int k = scanner.nextInt();

        // 사과의 좌표를 저장할 배열 생성
        int [][] apple = new int[k][2];
        for (int i = 0; i < k; i++) {
            apple[i][0] = scanner.nextInt(); // x 좌표
            apple[i][1] = scanner.nextInt(); // y 좌표
        }

        // 사과의 위치를 매트리스에 표시
        for (int i = 0; i < k; i++) {
            matrix[apple[i][0]][apple[i][1]] = 1; // 1은 사과를 나타냄
        }

        // 방향 전환 정보를 저장할 배열
        int x = scanner.nextInt();
        scanner.nextLine();

        // 방향 전환 정보를 입력받을 배열 생성
        String [][] direction = new String[x][2];
        for (int i = 0; i < x; i++) {
            direction[i][0] = scanner.next(); // 시간
            direction[i][1] = scanner.next(); // 방향 (D 또는 L)
        }

        int time = 0; // 게임 시간
        boolean flag = true; // 충돌 여부 플래그
        int snake_length = 1; // 뱀의 길이
        int [][] snake = new int[k + 1][2]; // 뱀의 위치를 저장할 배열

        // 뱀의 초기 위치 설정
        for (int i = 0; i < k + 1; i++) {
            snake[i][0] = 1; // x 좌표 초기화
            snake[i][1] = 1; // y 좌표 초기화
        }

        int dir_index = 0;  // 방향 인덱스 (0= 오른쪽, 1= 아래, 2= 왼쪽, 3= 위)

        while (true) {
            int next_row = snake[0][0]; // 뱀의 머리 위치
            int next_col = snake[0][1]; // 뱀의 머리 위치
            time++; // 시간 증가

            // 방향에 따른 다음 위치 계산
            switch (dir_index) {
                case 0: // 오른쪽
                    next_col++;
                    break;
                case 1: // 아래
                    next_row++;
                    break;
                case 2: // 왼쪽
                    next_col--;
                    break;
                case 3: // 위
                    next_row--;
                    break;
            }

            // 자기 몸과 충돌 검사
            for (int i = 1; i < snake_length; i++) {
                if (next_row == snake[i][0] && next_col == snake[i][1]) {
                    flag = false; // 충돌 발생
                    break;
                }
            }

            if (flag == false) {
                break; // 충돌 시 루프 종료
            }

            // 벽과 충돌 검사
            if (next_row < 1 || next_row > n || next_col < 1 || next_col > n) {
                break; // 벽에 충돌 시 루프 종료
            }

            // 사과를 먹었을 때
            if (matrix[next_row][next_col] == 1) {
                // 뱀의 길이를 늘리기
                for (int i = k; i > 0; i--) {
                    snake[i][0] = snake[i - 1][0];
                    snake[i][1] = snake[i - 1][1];
                }
                // 뱀의 머리 위치 업데이트
                snake[0][0] = next_row;
                snake[0][1] = next_col;

                snake_length++; // 뱀 길이 증가
                matrix[next_row][next_col] = 0; // 사과 제거
            } else { // 사과를 먹지 않았을 때
                if (snake_length == 1) { // 길이가 1일 때
                    snake[0][0] = next_row;
                    snake[0][1] = next_col;
                    // 뱀의 나머지 부분을 머리 위치로 설정
                    for (int i = 0; i < k + 1; i++) {
                        snake[i][0] = snake[0][0];
                        snake[i][1] = snake[0][1];
                    }
                } else { // 길이가 1이 아닐 때
                    // 뱀의 길이를 유지하기 위해 위치 업데이트
                    for (int i = snake_length - 1; i < k + 1; i++) {
                        snake[i][0] = snake[snake_length - 2][0];
                        snake[i][1] = snake[snake_length - 2][1];
                    }

                    for (int i = snake_length - 2; i > 0; i--) {
                        snake[i][0] = snake[i - 1][0];
                        snake[i][1] = snake[i - 1][1];
                    }

                    // 뱀의 머리 위치 업데이트
                    snake[0][0] = next_row;
                    snake[0][1] = next_col;
                }
            }

            // 방향 전환 처리
            for (int i = 0; i < x; i++) {
                if (time == Integer.parseInt(direction[i][0])) { // 시간에 따라 방향 전환
                    if (direction[i][1].equals("D")) { // 오른쪽으로 회전
                        dir_index++;
                        if (dir_index == 4) {
                            dir_index = 0; // 방향 인덱스 순환
                        }
                    } else { // 왼쪽으로 회전
                        dir_index--;
                        if (dir_index == -1) {
                            dir_index = 3; // 방향 인덱스 순환
                        }
                    }
                }
            }
        }

        // 게임 종료 시 시간 출력
        System.out.println(time);
    }
}
