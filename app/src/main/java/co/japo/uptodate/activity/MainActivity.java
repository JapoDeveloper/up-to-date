package co.japo.uptodate.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import co.japo.uptodate.R;
import co.japo.uptodate.entity.Feed;
import co.japo.uptodate.adapter.FeedAdapter;
import co.japo.uptodate.repository.FeedRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView feedsListView = (ListView) findViewById(R.id.feedsListView);
        feedsListView.setAdapter(new FeedAdapter(this,FeedRepository.feeds));
        feedsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Feed current = (Feed) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ArticlesActivity.class);
                intent.putExtra("feedUrl", current.url);
                startActivity(intent);
            }
        });
    }
}
