package md.shohel.dhaka.video.downloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import md.shohel.dhaka.video.downloader.R;
import md.shohel.dhaka.video.downloader.model.SubModelClass;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<SubModelClass> list;

    public SubAdapter(Context context, ArrayList<SubModelClass> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_recycler_view_model_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getThumbnailUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(@NonNull View view) {
            super(view);
            imageView=view.findViewById(R.id.subRecyclerViewModelLayoutImageViewId);
        }
    }
}
