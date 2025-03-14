package level6;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private MenuController menuController;
    private Cart cart;

    // 생성자
    // 메뉴와 장바구니 초기화
    public Kiosk(List<Menu> menus) {
        this.menuController = new MenuController(menus);
        this.cart = new Cart();
    }

    // 키오스크 시작 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 장바구니가 비어있는지 확인
            boolean isCartEmpty = cart.isEmpty();
            // 카테고리 목록 출력
            menuController.printCategoryList(isCartEmpty);

            // 사용자 입력
            int categoryNum = InputValidator.getValidIntInput(scanner);

            try {
                // 0이 입력되면 키오스크 종료
                if (categoryNum == 0) {
                    System.out.println("\n주문을 종료합니다.\n감사합니다!");
                    break;
                }

                // 카테고리 번호 유효 검사
                InputValidator.validateCategoryNumber(categoryNum, menuController.getMenus().size());

                while (true) {
                    // 메뉴 목록 출력
                    menuController.printMenuList(categoryNum, isCartEmpty);

                    // 사용자 입력
                    int orderNum = InputValidator.getValidIntInput(scanner);

                    // 9 가 입력되면 뒤로가기 -> 카테고리 목록으로 이동
                    if (orderNum == 9) {
                        break;
                    }
                    
                    // 7번 입력 시 장바구니 확인
                    if (orderNum == 7) {
                        if (isCartEmpty) {
                            System.out.println("장바구니가 비어 있습니다.");
                            continue;
                        }
                        // 장바구니 목록 출력
                        cart.printCart();
                        System.out.println("주문을 계속 진행하시겠습니까?");
                        System.out.println("1. Order    | 주문");
                        System.out.println("2. Cancel   | 취소");
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.print("입력 : ");

                        // 사용자 입력
                        int orderOption = InputValidator.getValidIntInput(scanner);
                        // 유효 검사
                        InputValidator.validateOrder(orderOption);

                        if (orderOption == 1) {
                            System.out.println("주문이 완료되었습니다.");
                            cart.clear();
                            break;
                        }
                    // 8 입력시 장바구니 삭제
                    } else if (orderNum == 8) {
                        if (isCartEmpty) {
                            System.out.println("장바구니가 비어 있습니다.");
                            continue;
                        }
                        cart.clear();
                        System.out.println("주문이 취소되었습니다.");
                        break;
                    } else {
                        // 유효 검사
                        InputValidator.validateOrderNumber(categoryNum, orderNum, menuController.getMenus().get(categoryNum - 1).getMenuItems().size());

                        // 선택한 메뉴를 가져옴
                        MenuItem selectedItem = menuController.getMenuItem(categoryNum, orderNum);
                        System.out.println("\n" + selectedItem.getMenuName() + "를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. Yes  | 주문");
                        System.out.println("2. No   | 취소");
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.print("입력 : ");
                        // 사용자 입력
                        int isOrder = InputValidator.getValidIntInput(scanner);

                        // 주문 옵션 유효 검사
                        InputValidator.validateOrder(isOrder);

                        if (isOrder == 1) {
                            cart.addItem(selectedItem);
                            System.out.println("\n장바구니에 추가되었습니다.");
                        } else {
                            System.out.println("\n주문이 취소되었습니다.");
                        }
                    }

                    // 장바구니 상태 갱신
                    isCartEmpty = cart.isEmpty();
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
