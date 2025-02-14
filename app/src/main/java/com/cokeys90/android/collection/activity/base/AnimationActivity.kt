package com.cokeys90.android.collection.activity.base

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat

import com.cokeys90.android.collection.R

/**
 * packageName    : com.cokeys90.android.collection.activity.base
 * fileName       : AnimationActivity
 * author         : jeong-yunsu
 * date           : 2025. 2. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 14.           jeong-yunsu            최초 생성
 */
abstract class AnimationActivity(
    private val transitionMode: TransitionMode = TransitionMode.HORIZONTAL,
    var horizontalDirection: HorizontalDirection = HorizontalDirection.RIGHT
) : AppCompatActivity() {

    enum class TransitionType(val value: Int) {
        OPEN(Activity.OVERRIDE_TRANSITION_OPEN),
        CLOSE(Activity.OVERRIDE_TRANSITION_CLOSE)
    }

    enum class TransitionMode {
        HORIZONTAL, // 좌우
        VERTICAL,  // 상하
    }

    enum class HorizontalDirection {
        LEFT, // 왼쪽 에서 ~
        RIGHT, // 오른쪽 에서 ~
    }

    private val tag = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR // 화면 세로 고정
        } catch (e: Exception) {
            e.printStackTrace()
        }

        super.onCreate(savedInstanceState)
    }

    override fun finish() {
        super.finish()
        exitTransitionAnimation()
    }

    private fun exitTransitionAnimation() {
        val exitAnimResId = when (transitionMode) {
            TransitionMode.HORIZONTAL -> when (horizontalDirection) {
                HorizontalDirection.LEFT -> R.anim.activity_slide_exit_left_horizontal
                HorizontalDirection.RIGHT -> R.anim.activity_slide_exit_horizontal
            }

            TransitionMode.VERTICAL -> R.anim.activity_slide_exit
            else -> android.R.anim.fade_out
        }

        val enterAnimResId = when (transitionMode) {
            TransitionMode.HORIZONTAL -> when (horizontalDirection) {
                HorizontalDirection.LEFT -> R.anim.activity_slide_exit_left_horizontal_modified
                HorizontalDirection.RIGHT -> R.anim.activity_slide_exit_horizontal_modified
            }

            TransitionMode.VERTICAL -> R.anim.activity_slide_exit
            else -> 0
        }

        applyAnimation(TransitionType.CLOSE, enterAnimResId, exitAnimResId)
    }

    private fun createTransitionAnimation() {
        val enterAnimResId = when (transitionMode) {
            TransitionMode.HORIZONTAL -> when (horizontalDirection) {
                HorizontalDirection.LEFT -> R.anim.activity_slide_enter_left_horizontal
                HorizontalDirection.RIGHT -> R.anim.activity_slide_enter_horizontal
            }

            TransitionMode.VERTICAL -> R.anim.activity_slide_enter
            else -> android.R.anim.fade_in
        }

        val preEnterAnimResId = when (transitionMode) {
            TransitionMode.HORIZONTAL -> when (horizontalDirection) {
                HorizontalDirection.LEFT -> R.anim.activity_slide_enter_left_horizontal_modified
                HorizontalDirection.RIGHT -> R.anim.activity_slide_enter_horizontal_modified
            }

            TransitionMode.VERTICAL -> R.anim.activity_slide_enter
            else -> 0
        }

        applyAnimation(TransitionType.OPEN, enterAnimResId, preEnterAnimResId)
    }


    private fun applyAnimation(
        transId: TransitionType = TransitionType.OPEN,
        enterResId: Int,
        exitResId: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            overrideActivityTransition(transId.value, enterResId, exitResId)
        } else {
            overridePendingTransition(enterResId, exitResId)
        }
    }

    fun applyStatusBarMode() {
        val isNightMode = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> true
            AppCompatDelegate.MODE_NIGHT_NO -> false
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> {
                val nightModeFlags =
                    resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                nightModeFlags == Configuration.UI_MODE_NIGHT_YES
            }

            else -> false
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11 (API 30) 이상
            val windowInsetsController = window.insetsController
            if (isNightMode) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.black)
                windowInsetsController?.setSystemBarsAppearance(
                    0,  // Clear LIGHT_STATUS_BARS
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            } else {
                window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                windowInsetsController?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            }
        } else {
            // Android 10 (API 29) 이하: 기존 방식 사용
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = if (isNightMode) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.black)
                0
            } else {
                window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
}