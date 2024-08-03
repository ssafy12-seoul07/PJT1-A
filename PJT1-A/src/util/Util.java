package util;

import java.util.Scanner;

public class Util {
	private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int inputInt(String msg) {
        System.out.print(msg);
        int result = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        return result;
    }

    public static void printLine() {
        System.out.println("--------------------");
    }

    public static void printLine(char ch) {
        for (int i = 0; i < 20; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void printLine(char ch, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void screenClear() {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
        // 참고: 이 방법은 완벽한 화면 클리어가 아니며, 터미널 환경에 따라 다를 수 있습니다.
    }

    // Scanner 리소스를 해제하는 메서드 (필요시 호출)
    public static void closeScanner() {
        sc.close();
    }
}
