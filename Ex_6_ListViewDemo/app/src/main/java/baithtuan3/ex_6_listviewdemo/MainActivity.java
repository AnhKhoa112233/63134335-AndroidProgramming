package baithtuan3.ex_6_listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTinhThanh;//Khai bao
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Hiển thị dữ liệu lên ListView
        //B1: Cần có dữ liệu

        dsTinhThanh= new ArrayList<>();//Tao the hien cu the
        //Them du lieu
        dsTinhThanh.add("Hà Nội");
        dsTinhThanh.add("Thành phố Hồ Chí Minh");
        dsTinhThanh.add("Khánh Hòa");
        dsTinhThanh.add("Đồng Nai");
        dsTinhThanh.add("Bình Định");
        dsTinhThanh.add("Phú Yên");
        //B2.Taoj Adapter
        ArrayAdapter<String> adapterTinhThanh =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dsTinhThanh);
        //B3: Gan adapter vao dieu khien hien thi
        //3.1 Tim thong qua id da dat
        ListView lvTinhThanh = findViewById(R.id.lv_DSTT);
        //3.2 Gan
        lvTinhThanh.setAdapter(adapterTinhThanh);
        //3.3 Lang nghe va xu li su kien
        //Gan bo lang nghe vao
        lvTinhThanh.setOnItemClickListener(BoLangNghevaXL);
    }
    //Tao bo lang nghe va su li su kien OnItemClick,dat vao 1 bien
    //Vd:BoLangNghevaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Code xu li o day
            //positon vị trí phần tử vừa click
            //vd: Hien len man hinh thong báo nhanh về vị trí và giá trị của phần tử vừa chọn
            String strTenTinhChon=dsTinhThanh.get(position);
            //Hien thi gia tri phan tu
            Toast.makeText(MainActivity.this,strTenTinhChon,Toast.LENGTH_LONG).show();//Hien thi vi tri



        }
    };
}