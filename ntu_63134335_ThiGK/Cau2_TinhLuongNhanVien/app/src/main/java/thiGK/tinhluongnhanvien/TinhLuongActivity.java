package thiGK.tinhluongnhanvien;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TinhLuongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tinhluong);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String tenNhanVien = intent.getStringExtra("");

        // Đặt tên nhân viên vào EditText hoặc TextView trong layout tinhluong
        EditText edtNamenv = findViewById(R.id.edt_namenv);
        edtNamenv.setText(tenNhanVien);
        //Tim dia chi edt_time edt_money
        EditText edtTime= findViewById(R.id.edt_time);
        EditText edtMoney= findViewById(R.id.edt_money);

    }
}

