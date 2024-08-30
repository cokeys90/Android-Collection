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
