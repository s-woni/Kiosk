package level3;

public class MenuItem {
    public String menuName;
    public double menuPrice;
    public String menuDescription;

    public MenuItem(String menuName, double menuPrice, String menuDescription) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    public void printMenu(int number) {
        System.out.printf("%d. %-20s | $ %.1f | %s\n", number, this.menuName, this.menuPrice, this.menuDescription);
    }
}
