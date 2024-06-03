package ltdd_khoa.ontapthiktltdd;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    FrameLayout fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fragment = findViewById(R.id.frame);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemID = menuItem.getItemId();
                if(itemID == R.id.home){
                    loadFragment(new HomeFragment(),false);
                }else if (itemID == R.id.cau1){
                    loadFragment(new Cau1Fragment(),false);
                }else if (itemID == R.id.cau2) {
                    loadFragment(new Cau2Fragment(), false);
                }else if (itemID == R.id.cau3) {
                    loadFragment(new Cau3Fragment(), false);
                }else{
                    loadFragment(new Cau4Fragment(), false);
                }

                return true;
            }

        });
        loadFragment(new HomeFragment(),true);
    }
    private void loadFragment(Fragment fragment,boolean isApp){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isApp){
            fragmentTransaction.add(R.id.frame,fragment);
        }else {
            fragmentTransaction.add(R.id.frame,fragment);
        }
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}