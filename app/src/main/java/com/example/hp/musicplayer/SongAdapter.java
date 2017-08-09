package com.example.hp.musicplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 08-08-2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder>{
    ArrayList<SongInfo> songs;
    Context context;

    OnItemClickListener onItemClickListener;

    SongAdapter(Context context, ArrayList<SongInfo> songs){
        this.context=context;
        this.songs=songs;
    }


    public interface OnItemClickListener{
        void onItemClick(Button b, View v , SongInfo obj, int position);
    }

    public  void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }
    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.raw_song, viewGroup, false);
        return new SongHolder(myView);
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
        final SongInfo c = songs.get(i);
        songHolder.textViewSongName.setText(c.songName);
        songHolder.textViewArtistName.setText(c.artistName);
        songHolder.buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(songHolder.buttonAction, v, c,i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
            TextView textViewSongName, textViewArtistName;
        Button buttonAction;
        public SongHolder(View itemView) {
            super(itemView);
            textViewSongName = (TextView) itemView.findViewById(R.id.textViewSongName);
            textViewArtistName = (TextView) itemView.findViewById(R.id.textViewArtistName);
            buttonAction = (Button) itemView.findViewById(R.id.buttonAction);
        }
    }
}
