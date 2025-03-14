package level6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    // 입력한 카테고리 번호가 유효한지 확인하는 메서드
    public static void validateCategoryNumber(int categoryNum, int maxCategory) {
        if (categoryNum < 1 || categoryNum > maxCategory) {
            throw new IllegalArgumentException("\n유효하지 않은 카테고리 번호입니다.");
        }
    }

    // 입력한 주문 번호가 유효한지 확인하는 메서드
    public static void validateOrderNumber(int categoryNum, int orderNum, int maxMenuItems) {
        if (orderNum < 1 || orderNum > maxMenuItems) {
            throw new IllegalArgumentException("\n유효하지 않은 메뉴 번호입니다.");
        }
    }

    // 주문 옵션이 유효한지 확인하는 메서드
    public static void validateOrder(int orderOption) {
        if (orderOption != 1 && orderOption != 2) {
            throw new IllegalArgumentException("\n잘못된 입력입니다.");
        }
    }

    // 유효한 값(정수 값)을 받는 메서드
    public static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수 값을 입력해 주세요.");
                System.out.print("입력 : ");
                scanner.nextLine();
            }
        }
    }
}
