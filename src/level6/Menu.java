package level6;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    // 생성자
    // 카테고리 이름을 받아 초기화
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    // 메뉴 아이템 추가 메서드
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // 메뉴 아이템 리스트 반환 메서드
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    // 카테고리 이름 반환 메서드
    public String getCategoryName() {
        return this.categoryName;
    }

    // 카테고리 출력 메서드
    public void printCategories(int number) {
        System.out.printf("%d. %s\n", number, categoryName);
    }
}
