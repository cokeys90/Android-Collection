> API 업그레이드 되면서 자주 사용하는 기능 기록

<br><br><br>

---


### Device Back Button
- **Android**: `onBackPressed()`

```java
OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
    @Override
    public void handleOnBackPressed() {
    }
};
getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
```

```kotlin
val onBackPressedCallback = object : OnBackPressedCallback(true) {
    override fun handleOnBackPressed() {
        // 뒤로 가기 버튼을 눌렀을 때 처리할 내용
    }
}
onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
```

<br><br><br>

---

### ActivityForResult
1. GO `A.activity` &rarr; `B.Activity`
```java
ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
    Intent data = result.getData();
    if (data == null) {
        tLog.e(tag, "resultCode:" + result.getResultCode() + " => data is null");
        return;
    }
    if (result.getResultCode() == 0) {
        // 처리할 내용
    }
});

Intent intent = new Intent(getActivity(), AutoDoorSettingsActivity.class);
intent.putExtra("key", "value");
resultLauncher.launch(intent);
```

2. BACK `B.Activity` &rarr; `A.activity`
```java
setResult("B.activityResultCode");
finish();
```
or
```java
Intent intent = new Intent();
intent.putExtra("key", "value");
setResult("B.activityResultCode", intent);
finish();
```