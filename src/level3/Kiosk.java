package level3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenu();

            try {
                int order = scanner.nextInt();

                if (order < 0) { // getValidNumber()
                    throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
                } else if (order >= menuItems.size()) {
                    throw new IllegalArgumentException("\n없는 메뉴입니다.\n메뉴에 있는 번호를 골라주세요.");
                }

                if (order == 0) {
                    System.out.println("\n주문을 종료합니다.\n감사합니다!\n");
                    scanner.close();
                    return;
                }

                switch (order) { // getOrder()
                    case 1 -> System.out.println("\nAmericano를 주문하셨습니다.\n가격은 $ 4.5 입니다.");
                    case 2 -> System.out.println("\nCaffe Latte를 주문하셨습니다.\n가격은 $ 5.0 입니다.");
                    case 3 -> System.out.println("\nCappuccino를 주문하셨습니다.\n가격은 $ 5.0 입니다.");
                    case 4 -> System.out.println("\nCaramel Macchiato를 주문하셨습니다.\n가격은 $ 5.5 입니다.");
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

    public void printMenu() {
        System.out.println();
        System.out.println("                                [ STARBUCKS MENU ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        for (MenuItem item : menuItems) {
            item.printMenuList(tempNum);
            tempNum++;
        }
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }
}
