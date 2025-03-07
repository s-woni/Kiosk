# 키오스크 프로젝트

Java를 사용하여 키오스크를 구현  
단계별 요구사항에 따라 진행하며 구현

## 기능

### Lv 1. 기본적인 키오스크를 프로그래밍

1. **메뉴 출력**
    - 실행 시 메뉴 표시

2. **정수 입력 받기**
    - `Scanner`를 통해 입력 받음
    - 메뉴에 있는 숫자가 아닐 시 예외 처리
    - 음수 입력 예외 처리
    - 숫자 제외 다른 값 예외 처리

3. **입력 받은 값에 따라 주문**

4. **반복문을 이용하여 지속되게 반복**

5. **0 입력시 프로그램 종료**
    - 주문 후 '0' 문자 입력 전까지 반복

- 구조

```text
/Kiosk
    └── level1
            └── Main.java
```

- UML

![lv1-uml.png](src/image/lv1-uml.png)

### Lv 2. 