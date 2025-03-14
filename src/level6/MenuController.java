package level6;

import java.util.List;

public class MenuController {
    private List<Menu> menus;

    public MenuController(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

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

    public void printOrderMenu(boolean isCartEmpty) {
        if (!isCartEmpty) {
            System.out.println("7. Orders               | 장바구니");
            System.out.println("8. Cancel               | 주문 취소");
        }
    }

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
