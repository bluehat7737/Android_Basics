package com.example.top10downloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutReource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutReource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = layoutInflater.inflate(layoutReource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        TextView iTitel = convertView.findViewById(R.id.iTitel);
//        TextView summary = convertView.findViewById(R.id.summary);
//        TextView episodeType = convertView.findViewById(R.id.episodeType);

        FeedEntry currentApp = applications.get(position);
        viewHolder.iTitel.setText(currentApp.getTitle());
        viewHolder.summary.setText(currentApp.getSummary());
        viewHolder.edisodetype.setText(currentApp.getEpisodeType());

        return convertView;
    }

    private class ViewHolder{
        private TextView iTitel;
        private TextView summary;
        private TextView edisodetype;

        ViewHolder(View view){
            this.iTitel = view.findViewById(R.id.iTitel);
            this.summary = view.findViewById(R.id.summary);
            this.edisodetype = view.findViewById(R.id.episodeType);
        }
    }
}
