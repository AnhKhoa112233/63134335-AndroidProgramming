package bt.demo_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdater landScapeAdater;
    ArrayList <LandScape> recyclerViewData;
    RecyclerView recyclerViewLandscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //B3 gan
        recyclerViewData= getDataForRecyclerView();
        //B4.Tim dk
        recyclerViewLandscape= findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutLinear= new LinearLayoutManager(this);
        recyclerViewLandscape.setLayoutManager(layoutLinear);
        //6
        landScapeAdater= new LandScapeAdater(this,recyclerViewData);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdater);
    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList dsDuLieu= new ArrayList<LandScape>();
        LandScape landScape1= new LandScape("hanoi","Cột cờ Hà Nội");
        dsDuLieu.add (landScape1);
        dsDuLieu.add(new LandScape("euffel","Tháp Eiffel"));
        dsDuLieu.add(new LandScape("buckingham","Cung điện Buckingham"));
        return dsDuLieu;
    }
}