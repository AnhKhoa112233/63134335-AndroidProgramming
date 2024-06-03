package ltdd_khoa.ontapthiktltdd;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Cau3Fragment extends Fragment {

    //Khai bao cac bien toan cuc
    LandScapeAdater adapter;
    ArrayList <LandScape> list;
    RecyclerView recyclerViewLandscape;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Chuan bi du lieu cho list
        list= new ArrayList<LandScape>();
        list.add(new LandScape("hanoi","Cột cờ Hà Nội"));
        list.add(new LandScape("eiffel","Tháp Eiffel"));
        list.add(new LandScape("buckingham","Buckkingham"));
        list.add(new LandScape("nuthan","Tượng nữ thần tự do"));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cau3, container, false);
        //B4.Tim dk
        recyclerViewLandscape= view.findViewById(R.id.ry_cau3);

        //5
        //Theo chieu tu tren xuong
        RecyclerView.LayoutManager layoutLinear= new LinearLayoutManager(view.getContext());
        recyclerViewLandscape.setLayoutManager(layoutLinear);
        //Tu trai sang phai
        /*RecyclerView.LayoutManager layoutGrid= new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewLandscape.setLayoutManager(layoutGrid);*/
        //6 Gan nguon vao dl
        adapter= new LandScapeAdater(view.getContext(),list);
        //7 Gan adapter vao recycler
        recyclerViewLandscape.setAdapter(adapter);
        return view;
    }
}