package level6;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> items;

    // 생성자
    // items를 빈 리스트로 초기화
    public Cart() {
        this.items = new ArrayList<>();
    }

    // 장바구니에 메뉴 추가 메서드
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // 장바구니가 비어있는지 확인 메서드
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 장바구니에 있는 값을 삭제 메서드
    public void clear() {
        items.clear();
    }

    // 장바구니에 있는 메뉴 출력 메서드
    public void printCart() {
        // 장바구니가 비어있지 않으면 출력
        if (!items.isEmpty()) {
            System.out.println("\n                                 [ YOUR CART ]");
            // 각 메뉴 출력
            for (MenuItem item : items) {
                item.printMenu();
            }
            System.out.println("\n                                [ TOTAL ]");
            // 장바구니에 담긴 메뉴의 금액 총합 가격 출력
            System.out.println("$ " + calculateTotal() + "\n");
        }
    }

    // 장바구니에 있는 메뉴 총 가격 계산 메서드
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getMenuPrice();
        }
        return total;
    }
}
