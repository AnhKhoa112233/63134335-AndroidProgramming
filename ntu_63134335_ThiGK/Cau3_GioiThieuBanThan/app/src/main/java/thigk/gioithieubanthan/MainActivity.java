package thigk.gioithieubanthan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Button btnThongTin = findViewById(R.id.btn_ThongTin);
        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến ThongTinActivity
                Intent intent_ThongTin = new Intent(MainActivity.this, ThongTinActivity.class);
                startActivity(intent_ThongTin);
            }
        });
        Button btnSoThich = findViewById(R.id.btn_SoThich);
        btnSoThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến SoThichActivity
                Intent intent = new Intent(MainActivity.this, SoThichActivity.class);
                startActivity(intent);
            }
        });


    }

}