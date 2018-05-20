package Adaptor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sullo.golfapp.RoundType;
import com.example.sullo.golfapp.R;

import java.util.List;

import Model.CourseItem;

/**
 * Created by sullo on 14/05/2018.
 */

//
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<CourseItem> listItems;

    public MyAdapter(Context context, List listitem){
        this.context = context;
        this.listItems = listitem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        CourseItem item = listItems.get(position);

        holder.courseName.setText(item.getCourseName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    // set up all our widgets
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView courseName;
        public  TextView description;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            courseName = (TextView) itemView.findViewById(R.id.courseName);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v) {
            // position of cardview
            int position = getAdapterPosition();

            CourseItem item = listItems.get(position);
            //Toast.makeText(context, item.getCourseName(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, RoundType.class);
            intent.putExtra("courseName", item.getCourseName());
            intent.putExtra("courseDescription", item.getDescription());
            intent.putExtra("CourseID", item.getID());


            context.startActivity(intent);
        }
    }
}
