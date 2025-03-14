package level5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Drinks 카테고리 생성 및 메뉴 추가
        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Americano", 4.5, "진한 에스프레소에 정수물이 더해진 커피"));
        drinksMenu.addMenuItem(new MenuItem("Caffe Latte", 5.0, "풍부하고 진한 에스프레소에 신선산 스팀 밀크가 더해진 커피"));
        drinksMenu.addMenuItem(new MenuItem("Cappuccino", 5.0, "우유 거품이 풍부한 부드러운 커피"));
        drinksMenu.addMenuItem(new MenuItem("Caramel Macchiato", 5.5, "달콤한 카라멜과 에스프레소가 어우러진 커피"));

        // Cakes 카테고리 생성 및 메뉴 추가
        Menu cakesMenu = new Menu("Cakes");
        cakesMenu.addMenuItem((new MenuItem("Chocolate Cake", 5.5, "달콤한 초콜릿 케이크")));

        // Sandwich 카테고리 생성 및 메뉴 추가
        Menu sandwichsMenu = new Menu("Sandwichs");
        sandwichsMenu.addMenuItem((new MenuItem("Egg Sandwich", 5.0, "달걀이 들어간 샌드위치")));

        // 메뉴 리스트에 카테고리들 추가
        List<Menu> menus = new ArrayList<>();
        menus.add(drinksMenu);
        menus.add(cakesMenu);
        menus.add(sandwichsMenu);

        Kiosk kiosk = new Kiosk(menus);

        // 키오스크 시작
        kiosk.start();
    }
}
