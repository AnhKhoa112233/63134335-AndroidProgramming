package ltdd_khoa.ontapthiktltdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdater extends RecyclerView.Adapter<LandScapeAdater.ItemLandHoder> {
   Context context;
   ArrayList<LandScape> listData;

    public LandScapeAdater(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom= LayoutInflater.from(context);
        View vItem=  cai_bom.inflate(R.layout.layout_recycleview,parent,false);
        ItemLandHoder viewholderCreater = new ItemLandHoder(vItem);
        return viewholderCreater ;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHoder holder, int position) {
        //Lay dt hien thi
        LandScape landScapeHienThi= listData.get(position);
        //Trich thong tin
        String caption = landScapeHienThi.landCaption;
        String tenFileAnh= landScapeHienThi.getLandImageFileName();
        //Dat vao cac truong thong tin
        //Dat ten
        holder.tvCaption.setText(caption);
        //Dat anh
        String packetName = holder.itemView.getContext().getPackageName();
        int imageID= holder.itemView.getResources().getIdentifier(tenFileAnh,"mipmap",packetName);
        holder.ivLandscape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHoder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandscape;


        public ItemLandHoder(@NonNull View itemView) {
            super(itemView);
            //Tim dk
           this. tvCaption= itemView.findViewById(R.id.textViewCaption);
            this.ivLandscape=itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTridclick = getAdapterPosition();
            LandScape phanTuDuocClick= listData.get(viTridclick);
            //Boc thong tin
            String ten= phanTuDuocClick.getLandImageFileName();
            String tenFile= phanTuDuocClick.getLandCaption();
            //Toast ten
            String chuoiThongBao= "Ban da click vao "+ten;
            Toast.makeText(context, chuoiThongBao, Toast.LENGTH_SHORT).show();
        }
    }
}
