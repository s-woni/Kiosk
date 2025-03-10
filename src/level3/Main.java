package level3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<>();
        Kiosk kiosk = new Kiosk(menuItems);

        menuItems.add(new MenuItem("Americano", 4.5, "진한 에스프레소에 정수물이 더해진 커피"));
        menuItems.add(new MenuItem("Caffe Latte", 5.0, "풍부하고 진한 에스프레소에 신선산 스팀 밀크가 더해진 커피"));
        menuItems.add(new MenuItem("Cappuccino", 5.0, "우유 거품이 풍부한 부드러운 커피"));
        menuItems.add(new MenuItem("Caramel Macchiato", 5.5, "달콤한 카라멜과 에스프레소가 어우러진 커피"));

        kiosk.start();

    }
}
