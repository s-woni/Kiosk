package level3;

public class MenuItem {
    public String menuName;
    public double menuPrice;
    public String menuDescription;

    // 생성자
    // 메뉴이름, 가격, 설명 초기화
    public MenuItem(String menuName, double menuPrice, String menuDescription) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    // 메뉴 정보를 출력
    public void printMenu(int number) {
        System.out.printf("%d. %-20s | $ %.1f | %s\n", number, this.menuName, this.menuPrice, this.menuDescription);
    }
}
