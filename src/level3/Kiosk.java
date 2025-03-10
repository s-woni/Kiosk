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
            printMenuList();

            try {
                int order = scanner.nextInt();

                if (closeKiosk(order)) {
                    return;
                }
                validateNumber(order);
                printOrder(order);

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

    public void printMenuList() {
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
    }

    public void printOrder(int order) {
        MenuItem selectedItem = menuItems.get(order - 1);

        System.out.println("\n" + selectedItem.menuName + "를 주문하셨습니다.\n가격은 $ " + selectedItem.menuPrice + "입니다.");
    }

    public void validateNumber(int order) {
        if (order < 0) {
            throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
        } else if (order >= menuItems.size() + 1) {
            throw new IllegalArgumentException("\n없는 메뉴입니다.\n메뉴에 있는 번호를 골라주세요.");
        }
    }

    public boolean closeKiosk(int order) {
        if (order == 0) {
            System.out.println("\n주문을 종료합니다.\n감사합니다!\n");
            return true;
        }
        return false;
    }
}
