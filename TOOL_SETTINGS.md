## Waiting For Debugger 팝업 오래유지될때
```zsh
adb shell am clear-debug-app
```


## Gradle Task 다 안보일때
```
Step1: File -> Settings -> Experimental -> ~ during Gradle Sync(Check)
```
```
Step2: File -> Sync Project with Gradle Files
```


## Wi-fi ADB Pair & Connect
#### 모바일->개발자모드->무선 디버깅->페어링 코드로 기기페어링(:39157)
```zsh
adb pair 172.30.1.41:33761
```
#### 모바일->개발자모드->무선 디버깅->IP 주소 및 포트(:39421)
```zsh
adb connect 172.30.1.41:33761
```

## IDE 이음자(Ligature) 설정
Preferences > Editor > Colors&Fonts > Font > Enable font ligature
