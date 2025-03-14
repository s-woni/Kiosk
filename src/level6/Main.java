package level6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Americano", 4.5, "진한 에스프레소에 정수물이 더해진 커피"));
        drinksMenu.addMenuItem(new MenuItem("Caffe Latte", 5.0, "풍부하고 진한 에스프레소에 신선산 스팀 밀크가 더해진 커피"));
        drinksMenu.addMenuItem(new MenuItem("Cappuccino", 5.0, "우유 거품이 풍부한 부드러운 커피"));
        drinksMenu.addMenuItem(new MenuItem("Caramel Macchiato", 5.5, "달콤한 카라멜과 에스프레소가 어우러진 커피"));

        Menu cakesMenu = new Menu("Cakes");
        cakesMenu.addMenuItem(new MenuItem("Chocolate Cake", 5.5, "달콤한 초콜릿 케이크"));
        cakesMenu.addMenuItem(new MenuItem("Cheese Cake", 4.5, "치즈 케이크"));

        Menu sandwichsMenu = new Menu("Sandwich");
        sandwichsMenu.addMenuItem(new MenuItem("Egg Sandwich", 5.0, "달걀이 들어간 샌드위치"));
        sandwichsMenu.addMenuItem(new MenuItem("Bacon Sandwich", 5.5, "베이컨 샌드위치"));

        List<Menu> menus = new ArrayList<>();
        menus.add(drinksMenu);
        menus.add(cakesMenu);
        menus.add(sandwichsMenu);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
