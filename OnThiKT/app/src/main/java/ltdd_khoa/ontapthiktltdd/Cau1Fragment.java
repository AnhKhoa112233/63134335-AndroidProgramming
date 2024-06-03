package ltdd_khoa.ontapthiktltdd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Cau1Fragment extends Fragment {
    EditText edt1, edt2;
    Button doi;
    // Example exchange rate
    private static final double EXCHANGE_RATE = 23000; // 1 USD = 23000 VND
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);
        //Tim dk
        edt1=view.findViewById(R.id.edt_vnd);
        edt2=view.findViewById(R.id.edt_usa);
        doi=view.findViewById(R.id.btn_nut);
        doi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String datavnd=edt1.getText().toString();
            String datausd=edt2.getText().toString();
            //Kiem tra xem doi ra gi
                if(!datavnd.isEmpty()){ //Nhap dl vnd doi ra usa
                     try {
                        double vnd = Double.parseDouble(datavnd);
                        double usd = vnd / EXCHANGE_RATE;
                        edt2.setText(String.format("%.2f", usd));
                        Toast.makeText(getContext(), "VND --> USD", Toast.LENGTH_SHORT).show();
                        edt1.setText("");
                     } catch (NumberFormatException e) {
                        Toast.makeText(getContext(), "Hãy nhập VND", Toast.LENGTH_SHORT).show();
                    }
                }else if (!datausd.isEmpty()) { // Convert USD to VND
                    try {
                        double usd = Double.parseDouble(datausd);
                        double vnd = usd * EXCHANGE_RATE;
                        edt1.setText(String.format("%.0f", vnd));
                        Toast.makeText(getContext(), "USD --> VND", Toast.LENGTH_SHORT).show();
                        edt2.setText("");
                    } catch (NumberFormatException e) {
                        Toast.makeText(getContext(), "Giá trị USD không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Hãy nhập các giá trị", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}