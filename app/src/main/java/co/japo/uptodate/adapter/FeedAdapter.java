package co.japo.uptodate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import co.japo.uptodate.R;
import co.japo.uptodate.entity.Feed;
/**
 * Created by japodeveloper on 10/14/17.
 */

public class FeedAdapter extends ArrayAdapter<Feed> {

    public FeedAdapter(Context context, List<Feed> data){
        super(context,0,data);
    }

    @Override
    public View getView(int position, View convertedView, ViewGroup parent){
        if(convertedView == null){
            convertedView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_feed_item,parent,false);
        }

        Feed current = getItem(position);

        ((TextView) convertedView.findViewById(R.id.feedname)).setText(current.name);
        ((TextView) convertedView.findViewById(R.id.feedUrl)).setText(current.url);

        return convertedView;
    }
}
