package Adaptor;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sullo.golfapp.R;
import com.example.sullo.golfapp.YardageFinder;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

import Model.Shot;

/**
 * Created by sullo on 17/05/2018.
 */

public class ShotAdapter extends RecyclerView.Adapter<ShotAdapter.ViewHolder>{

    private Context context;
    private List<Shot> shotList;
    private Bundle extras;

    public ShotAdapter(Context context, List<Shot> shotList) {
        this.context = context;
        this.shotList = shotList;
    }

//return viewholder with all its properties
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shot_row, parent, false);


        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Shot shot = shotList.get(position);

        holder.titleShot.setText(shot.getTitleShot());
        holder.timestampShot.setText(shot.getDescription());
//        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
//        String formattedDate = dateFormat.format(new Date(Long.valueOf(shot.getTimestampShot())).getTime());
//        holder.timestampShot.setText(formattedDate);
    }

    @Override
    public int getItemCount() {
        return shotList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleShot;
        public TextView timestampShot;
        String shotid;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            titleShot = (TextView) view.findViewById(R.id.shot);
            timestampShot = (TextView) view.findViewById(R.id.shotTimestamp);

            shotid = null;
        }
    }
}
