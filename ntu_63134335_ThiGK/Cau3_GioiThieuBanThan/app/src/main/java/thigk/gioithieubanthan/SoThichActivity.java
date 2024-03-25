package thigk.gioithieubanthan;

import android.content.Context;
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
import java.util.List;

public class SoThichActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sothich);
        ArrayList<String> dsSoThich = new ArrayList<>();
        dsSoThich.add("Xem phim");
        dsSoThich.add("Đá bóng");
        dsSoThich.add("Lập trình");
        dsSoThich.add("Chơi game");
        dsSoThich.add("Nghe nhạc");
        dsSoThich.add("Đi bộ");
        dsSoThich.add("Ngủ 8 tiếng");
        dsSoThich.add("Đọc sách");
        ArrayAdapter<String> adapterSoThich= new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1,  dsSoThich);
        /* Tim dk */
        ListView lvSoThich= findViewById(R.id.ds_SoThich);
        //Gan
        lvSoThich .setAdapter(adapterSoThich);
    }
}
