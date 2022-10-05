package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button xacnhan_btn;
    EditText txt_user, txt_pass;
    CheckBox cb_remember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        txt_user.setText(sharedPreferences.getString("taikhoan", ""));
        txt_pass.setText(sharedPreferences.getString("matkhau", ""));
        cb_remember.setChecked(sharedPreferences.getBoolean("checked", false));

        xacnhan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txt_user.getText().toString().trim();
                String password= txt_pass.getText().toString().trim();

                if(username.equals("letruongthinh") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    if(cb_remember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else{
                    Toast.makeText(MainActivity.this, "Loi dang nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        xacnhan_btn = findViewById(R.id.xacnhan_btn);
        txt_user = findViewById(R.id.txt_user);
        txt_pass = findViewById(R.id.pass);
        cb_remember = findViewById(R.id.checkbox_remember);

    }
}