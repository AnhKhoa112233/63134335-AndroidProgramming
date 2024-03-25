package thiGK.tinhluongnhanvien;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsNhanVien;//Khai bao
    ArrayAdapter<String> adapterNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //B1: co du lieu
        dsNhanVien= new ArrayList<>();
        dsNhanVien.add("Anh Khoa");
        dsNhanVien.add("Tuan Kiet");
        dsNhanVien.add("Trong Anh");
        dsNhanVien.add("Quoc Hung");
        dsNhanVien.add("Chanh Hung");
        //B2: Tao Adapter
        adapterNhanVien= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsNhanVien);
        //B3 gan vao dieu khien
        //B3.1 Tim
         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView lvNhanVien= findViewById(R.id.lvdsNhanVien);
         //B3.2 Gan
        lvNhanVien.setAdapter(adapterNhanVien);
        //B4 Ham Xu Lu Kien
        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy tên nhân viên từ danh sách
                String tenNhanVien = dsNhanVien.get(position);

                Intent intent = new Intent(MainActivity.this, TinhLuongActivity.class);

                    // Đưa tên nhân viên vào Intent
                intent.putExtra("", tenNhanVien);

                // Chuyển sang TinhLuongActivity
                startActivity(intent);

            }
        });

        // Lấy tham chiếu của EditText
        EditText edtNhanVien = findViewById(R.id.edt_nhanvien);
        // Bộ xử lý cho nút thêm nhân viên
        Button btnThem = findViewById(R.id.btn_them);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên nhân viên từ EditText
                String tenNhanVienMoi = edtNhanVien.getText().toString().trim();

                // Kiểm tra xem người dùng đã nhập tên nhân viên hay chưa
                if (!tenNhanVienMoi.isEmpty()) {
                    // Kiểm tra xem tên nhân viên đã tồn tại trong danh sách hay chưa
                    boolean daTonTai = false;
                    for (String ten : dsNhanVien) {
                        if (ten.equalsIgnoreCase(tenNhanVienMoi)) {
                            daTonTai = true;
                            break;
                        }
                    }

                    if (!daTonTai) {
                        // Thêm nhân viên mới vào danh sách
                        dsNhanVien.add(tenNhanVienMoi);
                        adapterNhanVien.notifyDataSetChanged();

                        // Xóa nội dung của EditText sau khi thêm
                        edtNhanVien.setText("");
                    } else {
                        // Hiển thị thông báo cho người dùng tên nhân viên đã tồn tại
                        Toast.makeText(MainActivity.this, "Tên nhân viên đã tồn tại trong danh sách", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Hiển thị thông báo cho người dùng yêu cầu nhập tên nhân viên
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên nhân viên", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Bộ xử lý cho nút xóa nhân viên
        Button btnXoa = findViewById(R.id.btn_xoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Lấy tên nhân viên từ EditText
                String tenNhanVienXoa = edtNhanVien.getText().toString().trim();

                // Kiểm tra xem tên nhân viên có trong danh sách hay không
                boolean coTrongDanhSach = false;
                for (String ten : dsNhanVien) {
                    if (ten.equalsIgnoreCase(tenNhanVienXoa)) {
                        coTrongDanhSach = true;

                        break;
                    }
                }

                // Nếu tên nhân viên có trong danh sách, thực hiện xóa
                if (coTrongDanhSach) {
                    dsNhanVien.remove(tenNhanVienXoa);
                    adapterNhanVien.notifyDataSetChanged();

                    // Xóa nội dung của EditText sau khi xóa
                    edtNhanVien.setText("");
                } else {
                    // Hiển thị thông báo cho người dùng rằng tên nhân viên không tồn tại trong danh sách
                    Toast.makeText(MainActivity.this, "Tên nhân viên không tồn tại trong danh sách", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    }
