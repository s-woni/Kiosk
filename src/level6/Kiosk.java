package level6;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private MenuController menuController;
    private Cart cart;

    public Kiosk(List<Menu> menus) {
        this.menuController = new MenuController(menus);
        this.cart = new Cart();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean isCartEmpty = cart.isEmpty();
            menuController.printCategoryList(isCartEmpty);

            int categoryNum = InputValidator.getValidIntInput(scanner);

            try {
                if (categoryNum == 0) {
                    System.out.println("\n주문을 종료합니다.\n감사합니다!");
                    break;
                }

                InputValidator.validateCategoryNumber(categoryNum, menuController.getMenus().size());

                while (true) {
                    menuController.printMenuList(categoryNum, isCartEmpty);

                    int orderNum = InputValidator.getValidIntInput(scanner);

                    if (orderNum == 9) {
                        break;
                    }

                    if (orderNum == 7) {
                        if (isCartEmpty) {
                            System.out.println("장바구니가 비어 있습니다.");
                            continue;
                        }
                        cart.printCart();
                        System.out.println("주문을 계속 진행하시겠습니까?");
                        System.out.println("1. Order    | 주문");
                        System.out.println("2. Cancel   | 취소");
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.print("입력 : ");

                        int orderOption = InputValidator.getValidIntInput(scanner);
                        InputValidator.validateOrder(orderOption);

                        if (orderOption == 1) {
                            System.out.println("주문이 완료되었습니다.");
                            cart.clear();
                            break;
                        }
                    } else if (orderNum == 8) {
                        if (isCartEmpty) {
                            System.out.println("장바구니가 비어 있습니다.");
                            continue;
                        }
                        cart.clear();
                        System.out.println("주문이 취소되었습니다.");
                        break;
                    } else {
                        InputValidator.validateOrderNumber(categoryNum, orderNum, menuController.getMenus().get(categoryNum - 1).getMenuItems().size());

                        MenuItem selectedItem = menuController.getMenuItem(categoryNum, orderNum);
                        System.out.println("\n" + selectedItem.getMenuName() + "를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. Yes  | 주문");
                        System.out.println("2. No   | 취소");
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.print("입력 : ");
                        int isOrder = InputValidator.getValidIntInput(scanner);

                        InputValidator.validateOrder(isOrder);

                        if (isOrder == 1) {
                            cart.addItem(selectedItem);
                            System.out.println("\n장바구니에 추가되었습니다.");
                        } else {
                            System.out.println("\n주문이 취소되었습니다.");
                        }
                    }

                    isCartEmpty = cart.isEmpty();
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
