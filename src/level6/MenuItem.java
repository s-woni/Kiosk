package level6;

public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuDescription;

    // 생성자
    // 메뉴이름, 가격, 설명 초기화
    public MenuItem(String menuName, double menuPrice, String menuDescription) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    // 메뉴 정보를 출력
    public void printMenu() {
        System.out.printf("%-20s | $ %.1f | %s\n", this.menuName, this.menuPrice, this.menuDescription);
    }

    // 번호를 받아와 "번호. 메뉴 정보" 형식으로 메뉴 정보를 출력
    public void printMenu(int number) {
        System.out.printf("%d. %-20s | $ %.1f | %s\n", number, this.menuName, this.menuPrice, this.menuDescription);
    }

    // 메뉴 가격을 반환하는 메서드
    public double getMenuPrice() {
        return this.menuPrice;
    }

    // 메뉴 이름을 반환하는 메서드
    public String getMenuName() {
        return this.menuName;
    }

    // 메뉴 설명을 반환하는 메서드
    public String getMenuDescription() {
        return this.menuDescription;
    }
}
