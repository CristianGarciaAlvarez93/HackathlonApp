package eu.thirdspaceauto.akka.hacksprint.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.security.auth.Subject;

import eu.thirdspaceauto.akka.hacksprint.Models.Excavators;
import eu.thirdspaceauto.akka.hacksprint.R;

public class ModelViewAdapter extends RecyclerView.Adapter<ModelViewAdapter.ViewHolder> {
    List<Excavators> excavatorsList;
    Activity activity;
    LayoutInflater mInflater;
    String TAG="ModelViewAdapter";
    private ItemClickListener clickListener;

    public ModelViewAdapter(List<Excavators> productList, Activity activity) {
        this.excavatorsList = productList;
        this.activity = activity;
        mInflater = ((LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }
    

    @Override
    public ModelViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.single_model_view, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ModelViewAdapter.ViewHolder holder, final int position) {
        Excavators excavator = excavatorsList.get(position);
        holder.name.setText(excavator.name);
        holder.info.setText(excavator.info);
        holder.image.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.tsa));

    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public interface ItemClickListener {
        public void itemClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return excavatorsList.size();
    }

    public void delete(int position) {
        excavatorsList.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView  name;
        TextView info;
        ImageView image;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            name= (TextView) itemLayoutView.findViewById(R.id.list_title);
            info= (TextView) itemLayoutView.findViewById(R.id.list_desc);
            image=(ImageView) itemLayoutView.findViewById(R.id.model_avatar);
        }
    }
}
