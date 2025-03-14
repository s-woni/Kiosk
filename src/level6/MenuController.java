package level6;

import java.util.List;

public class MenuController {
    private List<Menu> menus;

    // 생성자
    // 메뉴 목록 초기화
    public MenuController(List<Menu> menus) {
        this.menus = menus;
    }

    // 메뉴 목록 반환 메서드
    public List<Menu> getMenus() {
        return menus;
    }

    // 카테고리 목록 출력 메서드
    public void printCategoryList(boolean isCartEmpty) {
        System.out.println("\n                                [ STARBUCKS MENU ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        for (Menu item : menus) {
            item.printCategories(tempNum);
            tempNum++;
        }
        printOrderMenu(isCartEmpty);
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    // 메뉴 목록 출력 메서드
    public void printMenuList(int categoryNum, boolean isCartEmpty) {
        Menu selectedMenu = menus.get(categoryNum - 1);
        List<MenuItem> menuItems = selectedMenu.getMenuItems();
        System.out.println("\n                                [ " + selectedMenu.getCategoryName() + " ]");
        System.out.println("--------------------------------------------------------------------------------------");
        int tempNum = 1;
        for (MenuItem item : menuItems) {
            item.printMenu(tempNum);
            tempNum++;
        }
        printOrderMenu(isCartEmpty);
        System.out.println("9. Back                 | 뒤로가기");
        System.out.println("0. Exit                 | 종료");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    // 장바구니에 메뉴가 담길 시 관련 메뉴 출력 메서드
    public void printOrderMenu(boolean isCartEmpty) {
        if (!isCartEmpty) {
            System.out.println("7. Orders               | 장바구니");
            System.out.println("8. Cancel               | 주문 취소");
        }
    }

    // 카테고리 번호와 메뉴 번호에 해당하는 메뉴 반환 메서드
    public MenuItem getMenuItem(int categoryNum, int orderNum) {
        if (categoryNum < 1 || categoryNum > menus.size()) {
            throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
        }
        Menu selectedMenu = menus.get(categoryNum - 1);
        if (orderNum < 1 || orderNum > selectedMenu.getMenuItems().size()) {
            throw new IllegalArgumentException("유효하지 않은 메뉴 번호입니다.");
        }
        return selectedMenu.getMenuItems().get(orderNum - 1);
    }
}
