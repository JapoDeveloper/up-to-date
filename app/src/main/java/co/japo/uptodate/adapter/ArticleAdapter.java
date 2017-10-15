package co.japo.uptodate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.prof.rssparser.Article;

import java.util.List;

import co.japo.uptodate.R;

/**
 * Created by japodeveloper on 10/14/17.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, List<Article> data){
        super(context,0,data);
    }

    @Override
    public View getView(int position, View convertedView, ViewGroup parent){
        if(convertedView == null){
            convertedView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_article_item,parent,false);
        }

        Article current = getItem(position);

        ((TextView) convertedView.findViewById(R.id.articleTitle)).setText(current.getTitle());

        return convertedView;
    }
}
