package bt.examlist;
import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView
        .OnNavigationItemSelectedListener{

    ImageGalleryAdapter adapter;
    RecyclerView recyclerView;
    ClickListiner listiner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar
                = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        List<ExamData> list = new ArrayList<>();
        list = getData();

        recyclerView
                = (RecyclerView)findViewById(
                R.id.recyclerView);
        listiner = new ClickListiner() {
            @Override
            public void click(int index){

            }
        };
        adapter
                = new ImageGalleryAdapter(
                list, getApplication(),listiner);
        recyclerView.setAdapter(adapter);
        MainActivity mainActivity = this;
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
    }

    private void setSupportActionBar(Toolbar toolbar) {
        
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    // Sample data for RecyclerView
    private List<ExamData> getData()
    {
        List<ExamData> list = new ArrayList<>();
        list.add(new ExamData("First Exam",
                "May 23, 2015",
                "Best Of Luck"));
        list.add(new ExamData("Second Exam",
                "June 09, 2015",
                "b of l"));
        list.add(new ExamData("My Test Exam",
                "April 27, 2017",
                "This is testing exam .."));

        return list;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}