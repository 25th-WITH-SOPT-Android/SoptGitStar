package com.greedy0110.soptgitstar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        makeController()
    }

    fun makeController() {
        // 이번에는 kotlin extensions를 이용해서 개발 진행
        btnSignUpSummit.setOnClickListener {
            val name = edtSignUpName.text.toString()
            val id = edtSignUpId.text.toString()
            val pw = edtSignUpPw.text.toString()
            val pwCk = edtSignUpPwCk.text.toString()

            // 빈 칸이 있으면 안되므로 빈 칸 체크
            if (name.isEmpty() || id.isEmpty() || pw.isEmpty() || pwCk.isEmpty()) {
                Toast.makeText(this, "내용을 채워주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 비밀번호와 비밀번호 확인이 일치하는지 체크
            if (pw != pwCk) {
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 회원가입 요청을 보낸다.
            val response = requestSignup(name, id, pw)

            if (response) {
                // TODO 회원가입 성공했으면, 메인화면으로 넘어가야 한다.

                startActivity(intent)
            }
            else {
                // 실패했으면 실패했다고 알려준다.
                Toast.makeText(this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun requestSignup(name: String, id: String, pw:String): Boolean {
        return true
    }
}
