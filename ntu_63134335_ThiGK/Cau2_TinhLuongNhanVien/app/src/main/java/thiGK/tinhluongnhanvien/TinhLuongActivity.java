package thiGK.tinhluongnhanvien;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TinhLuongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tinhluong);
        // Nhận intent
        Intent intent = getIntent();

        // Lấy dữ liệu từ intent (tên nhân viên)
        String tenNhanVien = intent.getStringExtra("");

        // Đặt tên nhân viên vào EditText hoặc TextView
        EditText edtNamenv = findViewById(R.id.edt_namenv);
        edtNamenv.setText(tenNhanVien);
        EditText edtTime = findViewById(R.id.edt_time);
        EditText edtMoney = findViewById(R.id.edt_money);
        Button btnTinhLuong = findViewById(R.id.btn_tinhluong);
        Button btnThoat = findViewById(R.id.btn_thoat);
        btnTinhLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText edt_time
                String timeString = edtTime.getText().toString();

                // Kiểm tra xem đã nhập giá trị hay chưa
                if (timeString.isEmpty()) {
                    Toast.makeText(TinhLuongActivity.this, "Vui lòng nhập số giờ làm", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển đổi giá trị từ chuỗi sang số thực
                float time = Float.parseFloat(timeString);

                // Kiểm tra xem giá trị nhập vào có lớn hơn 0 không
                if (time <= 0) {
                    Toast.makeText(TinhLuongActivity.this, "Số giờ làm phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tính lương dựa trên số giờ làm
                float salary = calculateSalary(time);

                // Hiển thị kết quả lương lên EditText edt_money
                edtMoney.setText(String.valueOf(salary));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để quay lại MainActivity
                Intent intent = new Intent(TinhLuongActivity.this, MainActivity.class);
                startActivity(intent);

                // Kết thúc hoạt động hiện tại (TinhLuongActivity)
                finish();
            }
        });

    }

    // Hàm tính lương
    private float calculateSalary(float time) {
        float luongcoban = 20000; // Lương cơ bản
        float sogiothuong = 150; // Ngưỡng làm thêm giờ
        float sotienthuong = 200000; // Lương làm thêm giờ

        // Nếu số giờ làm lớn hơn ngưỡng làm thêm giờ
        if (time > sogiothuong) {
            // Tính lương với số giờ làm thêm
            return time*luongcoban+sotienthuong;
        } else {
            // Tính lương không có làm thêm giờ
            return time * luongcoban;
        }


    }

}

