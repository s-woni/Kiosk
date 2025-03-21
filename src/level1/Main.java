package level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            // 메뉴판 출력
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
                // 메뉴 선택
                int order = scanner.nextInt();

                // 음수 or 메뉴에 없는 번호 선택시 예외처리
                if (order < 0) {
                    throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
                } else if (order >= 5) {
                    throw new IllegalArgumentException("\n없는 메뉴입니다.\n메뉴에 있는 번호를 골라주세요.");
                }

                // 각 메뉴별 주문
                switch (order) {
                    case 1 -> System.out.println("\nAmericano를 주문하셨습니다.\n가격은 $ 4.5 입니다.");
                    case 2 -> System.out.println("\nCaffe Latte를 주문하셨습니다.\n가격은 $ 5.0 입니다.");
                    case 3 -> System.out.println("\nCappuccino를 주문하셨습니다.\n가격은 $ 5.0 입니다.");
                    case 4 -> System.out.println("\nCaramel Macchiato를 주문하셨습니다.\n가격은 $ 5.5 입니다.");
                    // 0 입력시 주문 종료 및 프로그램 종료
                    case 0 -> { 
                        System.out.println("\n주문을 종료합니다.\n감사합니다!\n");
                        scanner.close();
                        return;
                    }
                }
            // 숫자가 아닌 다른 값이 들어왔을 때 예외처리
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("잘못된 입력입니다.");
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}