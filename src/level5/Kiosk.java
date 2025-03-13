package level5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printCategoryList();

            try {
                int categoryNum = scanner.nextInt();

                getCategoryNumber(categoryNum);
                while(true) {
                    printMenuList(categoryNum);

                    try {
                        System.out.print("order : ");
                        int order = scanner.nextInt();

                        if (order == 9) {
                            break;
                        }
                        getOrderNumber(categoryNum, order);
                        printOrder(categoryNum, order);
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("잘못된 입력입니다.");
                        System.out.println("숫자를 입력해주세요.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("잘못된 입력입니다.");
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    public void printCategoryList() {
        System.out.println();
        System.out.println("                                [ STARBUCKS MENU ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        for (Menu item : menus) {
            item.printCategories(tempNum);
            tempNum++;
        }
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    public void printMenuList(int categoryNum) {
        Menu selectedMenu = menus.get(categoryNum - 1);
        List<MenuItem> menuItems = selectedMenu.getMenuItems();
        System.out.println();
        System.out.println("                                [ " + selectedMenu.getCategoryName() + " ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        for (MenuItem item : menuItems) {
            item.printMenu(tempNum);
            tempNum++;
        }
        System.out.println("9. Back                 | 뒤로가기");
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    public void printOrder(int categoryNum, int order) {
        Menu selectedMenu = menus.get(categoryNum - 1);
        MenuItem selectedItem = selectedMenu.getMenuItems().get(order - 1);

        System.out.println("\n" + selectedItem.getMenuName() + "를 주문하셨습니다.\n가격은 $ " + selectedItem.getMenuPrice() + "입니다.");
    }

    public void getCategoryNumber(int categoryNum) {
        validateNumber(categoryNum, menus.size());
    }

    public void getOrderNumber(int categoryNum, int order) {
        Menu selectedMenu = menus.get(categoryNum - 1);
        validateNumber(order, selectedMenu.getMenuItems().size());
    }

    public void validateNumber(int number, int maxSize) {
        if (closeKiosk(number)) {
            System.exit(0);
        } else if (number < 0) {
            throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
        } else if (number > maxSize) {
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
