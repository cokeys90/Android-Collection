### Waiting For Debugger 팝업 오래유지될때
```zsh
adb shell am clear-debug-app
```

<br><br><br>

---

### Gradle Task 다 안보일때
step1: `File` &rarr; `Settings` &rarr; `Experimental` &rarr; **`~ during Gradle Sync(Check)`**  
step2: `File` &rarr; `Sync Project with Gradle File's` **(클릭)**

<br><br><br>

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

<br><br><br>

---

## Build
### adb not found (에러)
환경 설정 잘 맞춘거 같은데 못찾을때
```zsh
brew install android-platform-tools
````

<br><br><br>

---

### IDE 이음자(Ligature) 설정
`Preferences` &rarr; `Editor` &rarr; `Colors&Fonts` &rarr; `Font` &rarr; **`Enable font ligature`**

### Tab Multiline (귀찮으면 Multiple rows 검색하면 찾기 쉬움)
`Preferences` &rarr; `Editor` &rarr; `General` &rarr; `Editor Tabs` &rarr; **`Multiple rows(check)`**

<br><br><br>

---

## 주석
### 클래스 주석 포맷 세팅
`Preference` &rarr; `File and Code Templates` &rarr; `Includes`(포함) &rarr; 아래 코드 입력 & `Enable Live Templates` 체크  
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
`Preference` &rarr; `plugin`  

| 플러그인 이름 | 설명 |
|:--|:--|
| JavaDoc | 메소드 주석 자동생성  
| BugKotlinDocument | 코틀린 메소드 주석 자동완성 안되는 버그 해결

<br><br><br>

---

## Color Scheme
### 커서 변수 배경색 설정
a. `Editor` &rarr; `element at caret(체크)`  
b. `Editor` &rarr; `Color Scheme` &rarr; `General` &rarr; `Code` &rarr; `Identifier under caret` &rarr; Background 색 변경 (84FFC6)  
c. `Editor` &rarr; `Color Scheme` &rarr; `General` &rarr; `Code` &rarr; `Identifier under caret(write)` &rarr; Background 색 변경 (FF84CE)  
d. `Editor` &rarr; `Color Scheme` &rarr; `General` &rarr; `Editor` &rarr; `Caret row` &rarr; Background 색 변경 (FF84CE)  

<br><br><br>

---

### Android Emulator Skin Path(Mac) [Galaxy Skin Link](https://developer.samsung.com/galaxy-emulator-skin/galaxy-s.html)
```zsh 
open /Users/jeong-yunsu/Applications/Android\ Studio.app/Contents/plugins/android/resources/device-art-resources
```

<br>

---

### Lombok Plugin 설치 (플러그인 조회 안될경우)
- `Preferences` &rarr; `Plugins` &rarr; `lombok` 검색 후 설치
- 없을 경우 https://plugins.jetbrains.com/plugin/6317-lombok/versions 에서 다운로드 후 설치



<br><br><br>