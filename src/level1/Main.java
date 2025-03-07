package level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("                                [ STARBUCKS MENU ]");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("1. Americano            | $ 4.5 | 진한 에스프레소에 정수물이 더해진 커피");
        System.out.println("2. Caffe Latte          | $ 5.0 | 풍부하고 진한 에스프레소에 신선산 스팀 밀크가 더해진 커피");
        System.out.println("3. Cappuccino           | $ 5.0 | 우유 거품이 풍부한 부드러운 커피");
        System.out.println("4. Caramel Macchiato    | $ 5.5 | 달콤한 카라멜과 에스프레소가 어우러진 커피");
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");

        try {
            int order = scanner.nextInt();

            if (order < 0) {
                throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.\n");
            } else if (order >= 5) {
                throw new IllegalArgumentException("\n없는 메뉴입니다.\n메뉴에 있는 번호를 골라주세요.\n");
            }
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("잘못된 입력입니다.");
            System.out.println("숫자를 입력해주세요.");
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}