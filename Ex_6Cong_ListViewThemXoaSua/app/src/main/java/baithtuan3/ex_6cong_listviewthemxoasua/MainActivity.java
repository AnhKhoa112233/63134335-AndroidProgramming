package baithtuan3.ex_6cong_listviewthemxoasua;

import android.annotation.SuppressLint;
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

    ArrayList<String> dsTenTinhThanhVN;//khai bao
    ArrayAdapter<String> adapterTinhThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Hiển thị dữ liệu trên list viewbtn_them
         @SuppressLint({"MissingInflatedId", "LocalSuppress"})
         Button nut= findViewById(R.id.btn_them);
        //B1+:cần có dữ liệu

        dsTenTinhThanhVN = new ArrayList<String>();//tao the hien cu the
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành Phố Hồ CHí Minh");
        dsTenTinhThanhVN.add("Nha Trang");
        dsTenTinhThanhVN.add("Phú Yên");
        dsTenTinhThanhVN.add("Cà Mau");
        //Buoc 2 tao Adapter
        adapterTinhThanh = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1
                ,dsTenTinhThanhVN);
        //buoc 3 gan vao dieu khiien list view
        //3.1,Tim
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        //3.2 Gan
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        //3.3 gan bo lang nghe
        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXL);

    }
    //Tao bo lang nghe va xu li su kien Onclick
    //Vd:BolangNgheVaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //i la vi tri phan tu vua click
            //hien thong bao vi tri khi chon
            String strTEnTinhTHhanh = dsTenTinhThanhVN.get(position);
            Toast.makeText(MainActivity.this,strTEnTinhTHhanh , Toast.LENGTH_SHORT).show();
        }
    };

    public void ThemPhanTu(View v){
        EditText edtTenMoi = findViewById(R.id.edt);
        String tenNhap = edtTenMoi.getText().toString();

        // Kiểm tra xem tên đã có trong danh sách hay chưa
        if(dsTenTinhThanhVN.contains(tenNhap)) {
            Toast.makeText(MainActivity.this, "Tên đã tồn tại trong danh sách", Toast.LENGTH_SHORT).show();
        } else {
            //Thêm vào danh sách và thông báo thành công
            dsTenTinhThanhVN.add(tenNhap);
            adapterTinhThanh.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        }
    }
    public void XoaPhanTu(View v)
    {
        EditText edtTenMoi = findViewById(R.id.edt);
        String tenNhap = edtTenMoi.getText().toString();
        // Kiểm tra xem tên co trong ds khong trong danh sách hay chưa
        if(!(dsTenTinhThanhVN.contains(tenNhap))) {
            Toast.makeText(MainActivity.this, "Tên không có  trong danh sách", Toast.LENGTH_SHORT).show();
        } else {
            //xóa tên danh sách và thông báo thành công
            dsTenTinhThanhVN.remove(tenNhap);
            adapterTinhThanh.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }

    }
}