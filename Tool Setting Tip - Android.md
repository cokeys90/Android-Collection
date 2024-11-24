## Waiting For Debugger 팝업 오래유지될때
```zsh
adb shell am clear-debug-app
```

---

## Gradle Task 다 안보일때
step1: `File` &rarr; `Settings` &rarr; `Experimental` &rarr; **`~ during Gradle Sync(Check)`**  
step2: `File` &rarr; `Sync Project with Gradle File's` **(클릭)**

---

### Wi-fi ADB Pair & Connect
`모바일` &rarr; `개발자모드` &rarr; `무선 디버깅` &rarr; **페어링 코드로 기기페어링(:{port})**
```zsh
adb pair 172.30.1.41:33761
```
`모바일` &rarr; `개발자모드` &rarr; `무선 디버깅` &rarr; **IP 주소 및 포트(:{port})**
```zsh
adb connect 172.30.1.41:33761
```
> (주의) 페어링이랑 커넥트랑 포트는 다름

---

### IDE 이음자(Ligature) 설정
`Preferences` &rarr; `Editor` &rarr; `Colors&Fonts` &rarr; `Font` &rarr; **`Enable font ligature`**

### Tab Multiline (귀찮으면 Multiple rows 검색하면 찾기 쉬움)
`Preferences` &rarr; `Editor` &rarr; `General` &rarr; `Editor Tabs` &rarr; **`Multiple rows(check)`**


---

### 클래스 주석 포맷 세팅
> `Preference` &rarr; `File and Code Templates` &rarr; `Includes`(포함) &rarr; 아래 코드 입력 & `Enable Live Templates` 체크  
```java
/**
 * packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : ${USER}
 * date           : ${DATE}
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * ${DATE}           ${USER}            최초 생성
 */
```  

### 메소드 주석 자동완성 
> `Preference` &rarr; `plugin`  

| 플러그인 이름 | 설명 |
|:--|:--|
| JavaDoc | 메소드 주석 자동생성  
| BugKotlinDocument | 코틀린 메소드 주석 자동완성 안되는 버그 해결


---

### Color Scheme
#### 커서 변수 배경색 설정
a. `Editor` &rarr; `element at caret(체크)`  
b. `Editor` &rarr; `Color Scheme` &rarr; `General` &rarr; `Code` &rarr; `Identifier under caret` &rarr; Background 색 변경 (84FFC6)  
c. `Editor` &rarr; `Color Scheme` &rarr; `General` &rarr; `Code` &rarr; `Identifier under caret(write)` &rarr; Background 색 변경 (FF84CE)  
d. `Editor` &rarr; `Color Scheme` &rarr; `General` &rarr; `Editor` &rarr; `Caret row` &rarr; Background 색 변경 (FF84CE)  
