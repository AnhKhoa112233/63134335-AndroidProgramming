package bt.examlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class ImageGalleryAdapter extends RecyclerView.Adapter<examViewHolder> {
    List<ExamData> list
            = Collections.emptyList();

    Context context;
    ClickListiner listiner;
    public ImageGalleryAdapter(List<ExamData> list,
                                Context context,ClickListiner listiner)
    {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }
    @NonNull
    @Override
    public examViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.layoutexam,
                        parent, false);

        examViewHolder viewHolder
                = new examViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final examViewHolder viewHolder,
                     final int position)
    {
        int index = viewHolder.getAdapterPosition();
        viewHolder.examName
                .setText(list.get(position).name);
        viewHolder.examDate
                .setText(list.get(position).date);
        viewHolder.examMessage
                .setText(list.get(position).message);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listiner.click(index);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
