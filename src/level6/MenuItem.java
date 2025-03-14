package level6;

public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuDescription;

    public MenuItem(String menuName, double menuPrice, String menuDescription) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    public void printMenu() {
        System.out.printf("%-20s | $ %.1f | %s\n", this.menuName, this.menuPrice, this.menuDescription);
    }

    public void printMenu(int number) {
        System.out.printf("%d. %-20s | $ %.1f | %s\n", number, this.menuName, this.menuPrice, this.menuDescription);
    }

    public double getMenuPrice() {
        return this.menuPrice;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public String getMenuDescription() {
        return this.menuDescription;
    }
}
