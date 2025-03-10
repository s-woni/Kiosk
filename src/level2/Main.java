package level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Americano", 4.5, "진한 에스프레소에 정수물이 더해진 커피"));
        menuItems.add(new MenuItem("Caffe Latte", 5.0, "풍부하고 진한 에스프레소에 신선산 스팀 밀크가 더해진 커피"));
        menuItems.add(new MenuItem("Cappuccino", 5.0, "우유 거품이 풍부한 부드러운 커피"));
        menuItems.add(new MenuItem("Caramel Macchiato", 5.5, "달콤한 카라멜과 에스프레소가 어우러진 커피"));

        while(true) {

            System.out.println();
            System.out.println("                                [ STARBUCKS MENU ]");
            System.out.println("--------------------------------------------------------------------------------------");
            int tempNum = 1;
            for (MenuItem item : menuItems) {
                item.printMenu(tempNum);
                tempNum++;
            }
            System.out.println("0. Exit                 | 종료");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.print("메뉴를 선택해주세요 : ");


            try {
                int order = scanner.nextInt();

                if (order < 0) {
                    throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
                } else if (order >= 5) {
                    throw new IllegalArgumentException("\n없는 메뉴입니다.\n메뉴에 있는 번호를 골라주세요.");
                }

                switch (order) {
                    case 1 -> System.out.println("\nAmericano를 주문하셨습니다.\n가격은 $ 4.5 입니다.");
                    case 2 -> System.out.println("\nCaffe Latte를 주문하셨습니다.\n가격은 $ 5.0 입니다.");
                    case 3 -> System.out.println("\nCappuccino를 주문하셨습니다.\n가격은 $ 5.0 입니다.");
                    case 4 -> System.out.println("\nCaramel Macchiato를 주문하셨습니다.\n가격은 $ 5.5 입니다.");
                    case 0 -> {
                        System.out.println("\n주문을 종료합니다.\n감사합니다!\n");
                        scanner.close();
                        return;
                    }
                }
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
