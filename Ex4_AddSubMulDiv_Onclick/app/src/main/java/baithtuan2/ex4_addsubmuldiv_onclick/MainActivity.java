package baithtuan2.ex4_addsubmuldiv_onclick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//Khai bao cac doi tuong gan voi dieu khien
    EditText editTextso1;
    EditText editTextso2;
    EditText editTextKq;
    Button nutCong,nutTru,nutNhan,nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //Ham TimDieuKhien
    public void TimDieuKhien(){
      editTextso1=(EditText) findViewById(R.id.edt_so1);
        editTextso2=(EditText) findViewById(R.id.edt_so2);
         editTextKq=(EditText) findViewById(R.id.edt_kq);
         nutCong =(Button) findViewById(R.id.btnCong);
        nutTru =(Button) findViewById(R.id.btnTru);
        nutNhan =(Button) findViewById(R.id.btnNhan);
        nutChia =(Button) findViewById(R.id.btnChia);
    }
    //Ham xu li cong
    public void HamXuLyCong(){
    //b1 Tim dl cua 2 so
        //b1.1 Tim edt so 1 va 2

        //b1.2 lay dl tu 2 dieu khien do kieu dl String
        String sothu1=editTextso1.getText().toString();
        String sothu2 =editTextso2.getText().toString();
        //b1.3 Chuyen tu string sang int
        float soA= Float.parseFloat(sothu1);
        float soB= Float.parseFloat(sothu2);
        //b2: Tinh toan
        float tong= soA+soB;
        //b3: Hien ket qua ve edt_Kq
            //b3.1Tim edt_kq
        EditText editTextKq=(EditText) findViewById(R.id.edt_kq);
            //b3.2 bien dl thanh chuoi
        String chuoiKq = String.valueOf(tong);
            //b3.3 gan kq len dieu khien
        editTextKq.setText(chuoiKq);
    }
    public void HamXuLyTru(){
        //b1 Tim dl cua 2 so
        //b1.1 Tim edt so 1 va 2

        //b1.2 lay dl tu 2 dieu khien do kieu dl String
        String sothu1=editTextso1.getText().toString();
        String sothu2 =editTextso2.getText().toString();
        //b1.3 Chuyen tu string sang int
        float soA= Float.parseFloat(sothu1);
        float soB= Float.parseFloat(sothu2);
        //b2: Tinh toan
        float tru= soA-soB;
        //b3: Hien ket qua ve edt_Kq
        //b3.1Tim edt_kq
        EditText editTextKq=(EditText) findViewById(R.id.edt_kq);
        //b3.2 bien dl thanh chuoi
        String chuoiKq = String.valueOf(tru);
        //b3.3 gan kq len dieu khien
        editTextKq.setText(chuoiKq);
    }
    public void HamXuLyNhan(){
        //b1 Tim dl cua 2 so
        //b1.1 Tim edt so 1 va 2

        //b1.2 lay dl tu 2 dieu khien do kieu dl String
        String sothu1=editTextso1.getText().toString();
        String sothu2 =editTextso2.getText().toString();
        //b1.3 Chuyen tu string sang int
        float soA= Float.parseFloat(sothu1);
        float soB= Float.parseFloat(sothu2);
        //b2: Tinh toan
        float nhan= soA*soB;
        //b3: Hien ket qua ve edt_Kq
        //b3.1Tim edt_kq
        EditText editTextKq=(EditText) findViewById(R.id.edt_kq);
        //b3.2 bien dl thanh chuoi
        String chuoiKq = String.valueOf(nhan);
        //b3.3 gan kq len dieu khien
        editTextKq.setText(chuoiKq);
    }
    public void HamXuLyChia(){
        //b1 Tim dl cua 2 so
        //b1.1 Tim edt so 1 va 2

        //b1.2 lay dl tu 2 dieu khien do kieu dl String
        String sothu1=editTextso1.getText().toString();
        String sothu2 =editTextso2.getText().toString();
        //b1.3 Chuyen tu string sang int
        float soA= Float.parseFloat(sothu1);
        float soB= Float.parseFloat(sothu2);
        //b2: Tinh toan
        float chia= soA/soB;
        //b3: Hien ket qua ve edt_Kq
        //b3.1Tim edt_kq
        EditText editTextKq=(EditText) findViewById(R.id.edt_kq);
        //b3.2 bien dl thanh chuoi
        String chuoiKq = String.valueOf(chia);
        //b3.3 gan kq len dieu khien
        editTextKq.setText(chuoiKq);
    }
    }
