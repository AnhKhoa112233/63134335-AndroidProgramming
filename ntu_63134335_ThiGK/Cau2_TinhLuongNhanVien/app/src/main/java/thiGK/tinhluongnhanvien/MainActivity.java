package thiGK.tinhluongnhanvien;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        //B4
    }
}