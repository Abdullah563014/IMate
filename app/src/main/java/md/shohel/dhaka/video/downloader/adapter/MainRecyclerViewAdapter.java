package md.shohel.dhaka.video.downloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import md.shohel.dhaka.video.downloader.R;
import md.shohel.dhaka.video.downloader.model.MainModelClass;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<MainModelClass> mainList;

    public MainRecyclerViewAdapter(Context context, ArrayList<MainModelClass> mainList){
        this.context=context;
        this.mainList=mainList;

        removeUnNecessaryFile();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_view_model_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String s=mainList.get(position).getTitle();
        if (!s.equalsIgnoreCase("Today Hot Videos")){
            holder.title.setText(mainList.get(position).getTitle());
            GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
            holder.recyclerView.setHasFixedSize(true);
            holder.recyclerView.setLayoutManager(gridLayoutManager);
            SubAdapter subAdapter=new SubAdapter(context,mainList.get(position).getList());
            holder.recyclerView.setAdapter(subAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View view) {
            super(view);
            title=view.findViewById(R.id.mainRecyclerViewModelLayoutTextViewId);
            recyclerView=view.findViewById(R.id.subRecyclerViewId);
        }
    }


    private void removeUnNecessaryFile(){
        for (int i = 0; i < mainList.size(); i++) {
            if (mainList.get(i).getTitle().equalsIgnoreCase("Today Hot Videos")){
                mainList.remove(i);
                notifyDataSetChanged();
            }
        }
    }
}
