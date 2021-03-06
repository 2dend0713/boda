package com.aeye.nextlabel.feature.user

import android.os.Bundle
import androidx.activity.viewModels
import com.aeye.nextlabel.R
import com.aeye.nextlabel.databinding.ActivityLoginBinding
import com.aeye.nextlabel.feature.common.BaseActivity
import com.aeye.nextlabel.global.*
import com.aeye.nextlabel.util.LoginUtil.logout

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        setFragment()
        supportFragmentManager.setFragmentResultListener(MOVE_FRAGMENT, this) { _, bundle ->
            val transaction = supportFragmentManager.beginTransaction()
            when(bundle[FRAGMENT_BUNDLE_KEY]) {
                JOIN_FRAGMENT -> {
                    transaction.replace(R.id.frame_layout_login, JoinFragment()).commit()
                }
                LOGIN_FRAGMENT -> {
                    transaction.replace(R.id.frame_layout_login, LoginFragment()).commit()
                }
            }
        }
    }

    private fun setFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_login, LoginFragment()).commit()
    }
}