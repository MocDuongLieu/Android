package aaa.exe.nhom_12_chuong_trinh_android.common.activity;

import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import aaa.exe.nhom_12_chuong_trinh_android.R;
import aaa.exe.nhom_12_chuong_trinh_android.common.dao.UserDAO;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText editEmail, editOldPassword, editNewPassword, editConfirm;
    Button btnChange;
    UserDAO userDAO;
    boolean isPasswordVisible = false;
    boolean isPasswordVisible2 = false;
    boolean isPasswordVisible3 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cm_activity_change_password);
        mapping();
        editOldPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX() >= (editOldPassword.getRight() - editOldPassword.getCompoundDrawables()[2].getBounds().width())){
                        isPasswordVisible = !isPasswordVisible;
                        if (isPasswordVisible) {
                            editOldPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            editOldPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_open, 0); // Icon mắt mở
                        } else {
                            editOldPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            editOldPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_close, 0); // Icon mắt đóng
                        }

                        // Đưa con trỏ văn bản về cuối
                        editOldPassword.setSelection(editOldPassword.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });
        editNewPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX() >= (editNewPassword.getRight() - editNewPassword.getCompoundDrawables()[2].getBounds().width())){
                        isPasswordVisible2 = !isPasswordVisible2;
                        if (isPasswordVisible2) {
                            editNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            editNewPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_open, 0); // Icon mắt mở
                        } else {
                            editNewPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            editNewPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_close, 0); // Icon mắt đóng
                        }

                        // Đưa con trỏ văn bản về cuối
                        editNewPassword.setSelection(editNewPassword.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });
        editConfirm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX() >= (editConfirm.getRight() - editConfirm.getCompoundDrawables()[2].getBounds().width())){
                        isPasswordVisible3 = !isPasswordVisible3;
                        if (isPasswordVisible3) {
                            editConfirm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            editConfirm.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_open, 0); // Icon mắt mở
                        } else {
                            editConfirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            editConfirm.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_close, 0); // Icon mắt đóng
                        }

                        // Đưa con trỏ văn bản về cuối
                        editConfirm.setSelection(editConfirm.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });
    }
    public void mapping(){
        userDAO = new UserDAO(this);
        editEmail = findViewById(R.id.editEmail);
        editOldPassword = findViewById(R.id.editOldPass);
        editNewPassword = findViewById(R.id.editNewPass);
        editConfirm = findViewById(R.id.editConfirm);
        btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
    }
    public void change(){
        String email = editEmail.getText().toString();
        String oldPassword = editOldPassword.getText().toString();
        String newPassword = editNewPassword.getText().toString();
        String confirmPassword = editConfirm.getText().toString();
        if(!isValidPassword(newPassword)){
            Toast.makeText(this, "Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ cái viết hoa, chữ cái thường, số và ký tự đặc biệt", Toast.LENGTH_SHORT).show();
        }
        if (!isConfirm(newPassword, confirmPassword)) {
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
        } else {
            String changePasswordResult = userDAO.changePassword(email, oldPassword, newPassword);
            Toast.makeText(this, changePasswordResult, Toast.LENGTH_SHORT).show();

            if (changePasswordResult.equals("Thành công")) {
                finish();
            }
        }
    }
    private boolean isConfirm(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
    private boolean isValidPassword(String password) {
        if (password.contains(" ") || password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[!@#$%^&*()-_+=<>?].*")){
            return false;
        }
        return true;
    }
    public void back(View v){
        finish();
    }
}
