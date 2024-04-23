1.Waiting For Debugger 팝업 오래유지될때
adb shell am clear-debug-app

2.무선 디버깅, 페어링 할때와 Connect 할때 포트값이 다른점 주의
2-1.모바일->개발자모드->무선 디버깅->페어링 코드로 기기페어링(:39157)
```zsh
/Users/jeong-yunsu/Library/Android/sdk/platform-tools/adb pair 172.30.1.41:39157
```
2-2.모바일->개발자모드->무선 디버깅->IP 주소 및 포트(:39421)
```zsh
/Users/jeong-yunsu/Library/Android/sdk/platform-tools/adb connect 172.30.1.41:39421
```
