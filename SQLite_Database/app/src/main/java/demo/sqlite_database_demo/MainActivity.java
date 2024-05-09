package demo.sqlite_database_demo;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
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


        // Bước 0. Tạo file cơ sở dữ liệu
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", // tên file = tên DB
                MODE_PRIVATE,  // giới hạn truy cập
                null          // con trỏ bản ghi
        );
        // B1. Tạo bảng
        // câu lêệnh tạo bảng
        String sqlXoaBangNeuDaCo="DROP TABLE IF EXISTS Books;";

        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
                "BookName text, " +
                "Page integer, " +
                "Price Float, " +
                "Description text);";
        // thực hiện lệnh sql
        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);
        // Ta đóng lại để check
        db.close();
        // TRUY VẤN SELECT
        //B1. Mở CSDL
         db = openOrCreateDatabase("QLSach.db", // tên file = tên DB
                MODE_PRIVATE,  // giới hạn truy cập
                null          // con trỏ bản ghi
        );
        //B2. Thực thi câu lệnh select
        String sqlSelect ="Select * from Books;";
        Cursor cs = db.rawQuery(sqlSelect,null);
        cs.moveToFirst(); // đưa con trỏ bản ghi về hàng đầu tiên
        // B3: Đổ vào biến nào đó để xử lý
        // 3.1. Xây dựng model/class cho bảng Books, vi dụ: Book.java
        // 3.2. Tạo biến ArrayList<Book> dsSach;
        ArrayList<Books> dsSach = new ArrayList<Books>();
        //3.3. Duyệt qua lần lượt từng bản ghi và thêm vào danhSach
        while (cs.moveToNext()) // còn bản ghi để chuyển tới
        {
            // Lấy dữ liệu từng côột ở dòng hiện tại
            int idSach = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            // Tạo một đối tượng sách và thêm vào danh sách
            Books b = new Books(idSach,tenSach,soTrang,gia,mota);
            dsSach.add(b);
        }
        //B4, Hiện lên listview, recylerview,..
        // để cho nhanh, ở đây thầy chỉ hiện tên sách
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for (int i=0; i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());
        // Phần việc hiện lên là của SV


    }
//
  ArrayList<Books> getDataForRY() {
//        //B1. Mở CSDL
      SQLiteDatabase db = openOrCreateDatabase("QLSach.db", // tên file = tên DB
            MODE_PRIVATE,  // giới hạn truy cập
             null          // con trỏ bản ghi
        );
       //B2. Thực thi câu lệnh select
       String sqlSelect ="Select * from Books;";
       Cursor cs = db.rawQuery(sqlSelect,null);
     cs.moveToFirst(); // đưa con trỏ bản ghi về hàng đầu tiên
        // B3: Đổ vào biến nào đó để xử lý
        // 3.1. Xây dựng model/class cho bảng Books, vi dụ: Book.java
        // 3.2. Tạo biến ArrayList<Book> dsSach;
       ArrayList<Books> dsSach = new ArrayList<Books>();
        //3.3. Duyệt qua lần lượt từng bản ghi và thêm vào danhSach
       while (cs.moveToNext()) // còn bản ghi để chuyển tới
       {
            // Lấy dữ liệu từng côột ở dòng hiện tại
            int idSach = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String tenSach = cs.getString(1);
           int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            // Tạo một đối tượng sách và thêm vào danh sách
            Books b = new Books(idSach,tenSach,soTrang,gia,mota);
           dsSach.add(b);
        }
       return  dsSach;
    }

    ArrayList<String> getTenSachForRY(ArrayList<Books> dsSach) {
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for (int i=0; i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());
       return dsTenSach;
    }
}