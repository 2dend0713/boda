package com.aeye.nextlabel.feature.user

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.aeye.nextlabel.R
import com.aeye.nextlabel.databinding.FragmentPasswordUpdateBinding
import com.aeye.nextlabel.feature.common.BaseFragment
import com.aeye.nextlabel.feature.main.MainActivity
import com.aeye.nextlabel.model.dto.Password
import com.aeye.nextlabel.model.dto.UserForLogin
import com.aeye.nextlabel.util.InputValidUtil

class PasswordUpdateFragment : BaseFragment<FragmentPasswordUpdateBinding>(
    FragmentPasswordUpdateBinding::bind, R.layout.fragment_password_update
) {

    val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val btnUpdate = binding.containedButtonUpdate

        btnUpdate.setOnClickListener {
            if (checkInputForm()) {
                updatePassword()
            }
        }
    }

    private fun updatePassword() {
        val userId = binding.password.text.toString()
        val password = binding.passwordConfirmation.text.toString()

        userViewModel.updatePassword(Password(userId, password))
    }

    private fun checkInputForm(): Boolean {
        var result = 1

        val password = binding.password.text.toString()
        val passwordConfirmation = binding.passwordConfirmation.text.toString()

        if(!InputValidUtil.isValidPassword(password)) {
            result *= 0
            binding.password.error = resources.getText(R.string.passwordErrorMessage)
        }
        if(password != passwordConfirmation) {
            result *= 0
            binding.passwordConfirmation.error = resources.getText(R.string.passwordConfirmErrorMessage)
        }

        return when(result) {
            1 -> true
            else -> false
        }
    }
}