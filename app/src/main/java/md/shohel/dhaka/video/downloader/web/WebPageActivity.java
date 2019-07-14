package md.shohel.dhaka.video.downloader.web;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import md.shohel.dhaka.video.downloader.MainActivity;
import md.shohel.dhaka.video.downloader.R;
import md.shohel.dhaka.video.downloader.download.DownloadActivity;

public class WebPageActivity extends AppCompatActivity {

    WebView webView;
    private Toolbar toolbar;
    SearchView searchView;
    ImageView downloadImageViewIcon;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        toolbar=findViewById(R.id.webViewToolbar);
        setSupportActionBar(toolbar);

        initializeAll();

        String url=getIntent().getExtras().getString("myUrl");
        if (url!=null){
            openWebPage(url);
        }else {
            Toast.makeText(this, "Url not detected", Toast.LENGTH_SHORT).show();
        }


        downloadImageViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent downloadActivityIntent=new Intent(WebPageActivity.this, DownloadActivity.class);
                startActivity(downloadActivityIntent);
                finish();
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.browserBackMenuId:
                        if (webView.canGoBack()){
                            webView.goBack();
                        }else {
                            finish();
                        }
                        break;

                    case R.id.browserForwardMenuId:
                        if (webView.canGoForward()){
                            webView.goForward();
                        }else {
                            Toast.makeText(WebPageActivity.this, "No Available Page Found", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.browserMenuMenuId:
                        Toast.makeText(WebPageActivity.this, "Not available menu yet", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.browserRefreshMenuId:
                        webView.reload();
                        break;

                    case R.id.browserHomeMenuId:
                        Intent homeIntent=new Intent(WebPageActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                        finish();
                        break;
                }
                return true;
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                openWebPage(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }


    private void initializeAll(){
        webView=findViewById(R.id.webViewId);
        searchView=findViewById(R.id.webViewSearchViewId);
        downloadImageViewIcon=findViewById(R.id.webViewToolbarDownloadImageViewId);
        bottomNavigationView=findViewById(R.id.browserBottomNavigationViewId);

    }


    public void openWebPage(String text){
        String myUrl="";
        if (Patterns.WEB_URL.matcher(text).matches()) {
            if (!text.startsWith("http")) {
                myUrl = "http://" + text;
            }

        } else {
//            myUrl = "https://google.com/search?q=" + text;
            myUrl = "https://www.youtube.com/results?search_query=" + text;

        }


        webView.setWebChromeClient(new WebChromeClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                searchView.setQuery(url,false);
            }

            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                super.doUpdateVisitedHistory(view, url, isReload);
                searchView.setQuery(url,false);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });

        webView.loadUrl(myUrl);
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
