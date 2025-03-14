package level5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    // 생성자
    // menus 리스트를 받아 추기화
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // 키오스크 시작 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // 카테고리 출력
            printCategoryList();

            try {
                // 사용자 입력
                int categoryNum = scanner.nextInt();

                // 카테고리 번호 유효 검사
                checkedCategoryNumber(categoryNum);
                while(true) {
                    // 카테고리에 따른 메뉴 출력
                    printMenuList(categoryNum);

                    try {
                        // 사용자 입력
                        int order = scanner.nextInt();

                        // 9 입력 시 카테고리 화면으로 돌아감
                        if (order == 9) {
                            break;
                        }

                        // 메뉴 번호 유효성 검사
                        checkedOrderNumber(categoryNum, order);
                        // 주문 정보 출력
                        printOrder(categoryNum, order);
                    // 숫자가 아닌 다른 값 입력 시 예외 처리
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

    // 카테고리 출력 메서드
    public void printCategoryList() {
        System.out.println();
        System.out.println("                                [ STARBUCKS MENU ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        // 각 카테고리 출력
        for (Menu item : menus) {
            item.printCategories(tempNum);
            tempNum++;
        }
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    // 메뉴 출력 메서드
    public void printMenuList(int categoryNum) {
        Menu selectedMenu = menus.get(categoryNum - 1);
        List<MenuItem> menuItems = selectedMenu.getMenuItems();
        System.out.println();
        System.out.println("                                [ " + selectedMenu.getCategoryName() + " ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        // 각 메뉴 출력
        for (MenuItem item : menuItems) {
            item.printMenu(tempNum);
            tempNum++;
        }
        System.out.println("9. Back                 | 뒤로가기");
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    // 주문 정보 출력 메서드
    public void printOrder(int categoryNum, int order) {
        // 사용자가 입력한 번호에 대한 카테고리 정보 가져옴
        Menu selectedMenu = menus.get(categoryNum - 1);
        // 사용자가 고른 카테고리 내부의 메뉴에 대한 정보 가져옴
        MenuItem selectedItem = selectedMenu.getMenuItems().get(order - 1);

        System.out.println("\n" + selectedItem.getMenuName() + "를 주문하셨습니다.\n가격은 $ " + selectedItem.getMenuPrice() + "입니다.");
    }

    // 입력한 카테고리 번호가 유효한지 확인하는 메서드
    public void checkedCategoryNumber(int categoryNum) {
        validateNumber(categoryNum, menus.size());
    }

    // 입력한 주문 번호가 유효한지 확인하는 메서드
    public void checkedOrderNumber(int categoryNum, int order) {
        Menu selectedMenu = menus.get(categoryNum - 1);
        validateNumber(order, selectedMenu.getMenuItems().size());
    }

    // 입력한 번호와 리스트의 크기를 가져와 유효 검사 메서드
    public void validateNumber(int number, int maxSize) {
        if (closeKiosk(number)) {
            System.exit(0);
        } else if (number < 0) {
            throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
        } else if (number > maxSize) {
            throw new IllegalArgumentException("\n없는 메뉴입니다.\n메뉴에 있는 번호를 골라주세요.");
        }
    }

    // 키오스크 종료 메서드
    public boolean closeKiosk(int order) {
        // 0 이 들어오면 키오스크 프로그램 종료
        if (order == 0) {
            System.out.println("\n주문을 종료합니다.\n감사합니다!\n");
            return true;
        }
        return false;
    }
}
