package aaa.exe.nhom_12_chuong_trinh_android.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import aaa.exe.nhom_12_chuong_trinh_android.R;
import aaa.exe.nhom_12_chuong_trinh_android.common.dao.UserDAO;
import aaa.exe.nhom_12_chuong_trinh_android.common.objects.UserSession;
import aaa.exe.nhom_12_chuong_trinh_android.main.activity.CreateProfileActivity;
import aaa.exe.nhom_12_chuong_trinh_android.main.dao.ProfileDAO;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUserName, edtPassword;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cm_activity_login);
        mapping();
    }
    public void mapping(){
        btnLogin = findViewById(R.id.btnLogin);
        edtPassword = findViewById(R.id.edtPassword);
        edtUserName = findViewById(R.id.edtUserName);
        userDAO = new UserDAO(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){
        String userName = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this,"Phải nhập tên người dùng và mật khẩu.",Toast.LENGTH_SHORT).show();
            return;
        }

        boolean checkUser = userDAO.checkUser(userName,password);

        if (checkUser){
            Toast.makeText(LoginActivity.this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
            int user_id = userDAO.getUserId(userName, password);
            if(user_id==0){
                Toast.makeText(LoginActivity.this,"Lỗi",Toast.LENGTH_SHORT).show();
            }
            else{
                UserSession userSession = UserSession.getInstance();
                userSession.setUserId(user_id);
                ProfileDAO profileDAO = new ProfileDAO(this);
                if(profileDAO.checkProfile(user_id)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(LoginActivity.this, CreateProfileActivity.class);
                    startActivity(intent);
                }
                finish();
            }

        }else {
            Toast.makeText(LoginActivity.this,"Tên đăng nhập và mật khẩu không tồn tại.",Toast.LENGTH_SHORT).show();
        }

    }
    public void toRegister(View v){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);

    }
}