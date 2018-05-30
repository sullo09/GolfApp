package Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sullo.golfapp.R;
import com.example.sullo.golfapp.Rounds;

import java.util.Date;
import java.util.List;

import Model.CompletedRound;

/**
 * Created by sullo on 16/05/2018.
 */

public class RoundRecyclerAdapter extends RecyclerView.Adapter<RoundRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<CompletedRound> roundsList;

    public RoundRecyclerAdapter(Context context, List<CompletedRound> roundsList) {
        this.context = context;
        this.roundsList = roundsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.round_row, parent,false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CompletedRound completedRound = roundsList.get(position);

        holder.coursePlayed.setText(completedRound.getCoursePlayed());
        holder.playerName.setText(completedRound.getPlayerName());
        holder.playerHandicap.setText(completedRound.getplayerHandicap());
        holder.playerScore.setText(completedRound.getPlayerScore());
//        holder.playerScoreSford.setText("test");
        holder.playerScoreSford.setText(completedRound.getPlayerScoreSford());
        holder.playerPutts.setText(completedRound.getPlayerPutts());

        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(completedRound.getTimestamp())).getTime());
        //eg April 17 2017
        holder.timestamp.setText(formattedDate);
    }

    @Override
    public int getItemCount() {
        return roundsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView playerName ;
        public TextView coursePlayed;
        public TextView playerHandicap;
        public TextView playerScore;
        public TextView playerScoreSford;
        public TextView playerPutts;

        public TextView timestamp;
        String userid;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            playerName = (TextView) view.findViewById(R.id.playerNameResult);
            coursePlayed = (TextView) view.findViewById(R.id.coursePlayed);
            playerScore = (TextView) view.findViewById(R.id.playerResultScore);
            playerHandicap = (TextView) view.findViewById(R.id.playerResultHandicap);
            playerScoreSford = (TextView) view.findViewById(R.id.playerResultSford);
            playerPutts = (TextView) view.findViewById(R.id.playerResultPutts);
            timestamp = (TextView) view.findViewById(R.id.roundTimestamp);

            userid = null;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to next activity
                }
            });
        }
    }
}
