package level3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    // 생성자
    // menuItems 리스트를 받아 초기화
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 키오스크 시작 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // 메뉴 출력
            printMenuList();

            try {
                // 사용자 입력
                int order = scanner.nextInt();

                // 0 입력시 프로그램 종료
                if (closeKiosk(order)) {
                    return;
                }
                // 입력 값 유효 검사
                validateNumber(order);
                // 주문정보 출력
                printOrder(order);
            
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
    }

    // 메뉴 출력 메서드
    public void printMenuList() {
        System.out.println();
        System.out.println("                                [ STARBUCKS MENU ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        // 메뉴판 내부 메뉴 출력
        for (MenuItem item : menuItems) {
            item.printMenu(tempNum);
            tempNum++;
        }
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    // 주문 정보 출력 메서드
    public void printOrder(int order) {
        // 사용자가 입력한 번호에 해당하는 메뉴를 가져옴
        MenuItem selectedItem = menuItems.get(order - 1);

        System.out.println("\n" + selectedItem.menuName + "를 주문하셨습니다.\n가격은 $ " + selectedItem.menuPrice + "입니다.");
    }

    // 입력한 값이 유효한지 검사하는 메서드
    public void validateNumber(int order) {
        if (order < 0) {
            throw new IllegalArgumentException("\n음수를 입력하셨습니다.\n양수를 입력해주세요.");
        } else if (order > menuItems.size()) {
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
