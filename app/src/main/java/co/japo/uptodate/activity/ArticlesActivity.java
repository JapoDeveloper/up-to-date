package co.japo.uptodate.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;

import co.japo.uptodate.R;
import co.japo.uptodate.adapter.ArticleAdapter;

public class ArticlesActivity extends AppCompatActivity {

    private ListView articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        Bundle extras = getIntent().getExtras();

        articles = (ListView) findViewById(R.id.articles);
        articles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Article current = (Article) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ArticlesActivity.this,DisplayArticleActivity.class);
                intent.putExtra("articleUrl",current.getLink());
                startActivity(intent);
            }
        });

        loadArticles(extras.getString("feedUrl"));

    }

    private void loadArticles(String url){
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted() {

            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                ArticleAdapter articleAdapter = new ArticleAdapter(ArticlesActivity.this, list);
                articles.setAdapter(articleAdapter);
            }

            @Override
            public void onError() {

            }
        });
        parser.execute(url);
    }
}
