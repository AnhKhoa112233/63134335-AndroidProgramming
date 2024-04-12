package bt.demo_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View vItem=  cai_bom.inflate(R.layout.item_land,parent,false);
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

    class ItemLandHoder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView ivLandscape;


        public ItemLandHoder(@NonNull View itemView) {
            super(itemView);
            //Tim dk
            tvCaption= itemView.findViewById(R.id.textViewCaption);
            ivLandscape=itemView.findViewById(R.id.imageViewLand);
        }
    }
}
