package co.japo.uptodate.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import co.japo.uptodate.R;

public class DisplayArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_article);

        Bundle extras = getIntent().getExtras();

        WebView articleScreen = (WebView) findViewById(R.id.articleScreen);
        articleScreen.getSettings().setJavaScriptEnabled(true);
        articleScreen.loadUrl(extras.getString("articleUrl"));

    }
}
