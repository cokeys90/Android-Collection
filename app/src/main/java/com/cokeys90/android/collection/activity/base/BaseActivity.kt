package com.cokeys90.android.collection.activity.base

import android.os.Bundle

/**
 * packageName    : com.cokeys90.android.collection.activity.base
 * fileName       : BaseActivity
 * author         : jeong-yunsu
 * date           : 2025. 2. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 14.           jeong-yunsu            최초 생성
 */
abstract class BaseActivity : AnimationActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}