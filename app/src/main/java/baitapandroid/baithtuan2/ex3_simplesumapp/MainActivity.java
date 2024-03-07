package baitapandroid.baithtuan2.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
    public void congHaiSo(View view){
       EditText editTextSoA= findViewById(R.id.so1);
        EditText editTextSoB = findViewById(R.id.so2);
       EditText editTextKq= findViewById(R.id.edt_kq);
        //Lay su lieu cua a ve ve
       String strA= editTextSoA.getText().toString();
        //Lay su lieu cua b ve ve
        String strB= editTextSoB.getText().toString();
        //Chuyen kieu dl
       int so_A= Integer.parseInt(strA);
        int so_B=Integer.parseInt(strB);
        //Tinh toan
        int tong=so_A + so_B;
        String Str_Kq= String.valueOf(tong); //chuyen kq qua dang chuoi
        //Hien ra man hinh
        editTextKq.setText(Str_Kq);
    }
}