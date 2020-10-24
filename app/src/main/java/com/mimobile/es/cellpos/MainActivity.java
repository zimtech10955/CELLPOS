package com.mimobile.es.cellpos;
/*
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    public final boolean networkCheck() {
        ConnectivityManager connec =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ) {
            return true;
        } else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED || connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {
            return false;
        }
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Splash screen
        setContentView(R.layout.splash);

        if(networkCheck()) {
            String url = "http://cellpos.us/pos";
          //http://cellpos.us/pos
            //  String url = "http://cellpos.us/admin";

            final WebView webview;
            webview = new WebView(MainActivity.this);
            WebSettings webSettings = webview.getSettings();
            webSettings.setDomStorageEnabled(true);
            webSettings.setJavaScriptEnabled(true);
            webview.loadUrl(url);

            webview.setWebViewClient(new WebViewClient(){
                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    // DO NOT CALL SUPER METHOD
                    super.onReceivedSslError(view, handler, error);
                }
            });



            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //view.loadUrl(url);
                    return false;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    setContentView(webview);
                }
            });

        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Fejl");
            alertDialog.setMessage("Ingen forbindelse til internettet");

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }
    }


}



import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    String url="http://cellpos.us/pos";
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webView);
        swipeRefreshLayout=findViewById(R.id.homeswiperefreshayout);

loadwebview();


    }

    public void loadwebview() {

        // fruitewebview.clearCache(true);
        // Enable Javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//faster to load
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      //  webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
      //  webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
       webSettings.setDomStorageEnabled(true);
       webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
       webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webView.loadUrl("http://cellpos.us/pos");


        swipeRefreshLayout.setRefreshing(true);


        //back button implimetation
        webView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });
        // Force links and redirects to open in the WebView instead of in a browser
        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                Toast.makeText(getApplicationContext(), "Failed loading app!, No Internet Connection found.", Toast.LENGTH_SHORT).show();
            }

            public void onPageFinished(WebView view, String url) {

                //Hide the SwipeReefreshLayout


            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.contains("cellpos")) {
                    try {
                        view.loadUrl(url);
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Oups!Can't open Facebook messenger right now. Please install and try again later.", Toast.LENGTH_SHORT)
                                .show();
                        view.loadUrl(url);
                    }
                }
                    else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        Log.d("muzammal3", url);
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Oups!Can't open Facebook messenger right now. Please install and try again later." + e, Toast.LENGTH_LONG)
                                    .show();
                            view.loadUrl(url);
                        }
                    }


                return true;

            }


        });


    }
    */


            import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        private WebView mywebView;
        String url="http://cellpos.us/pos";
        SwipeRefreshLayout swipeRefreshLayout;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //     requestWindowFeature(Window.FEATURE_NO_TITLE);//for full screen
            //    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


            setContentView(R.layout.activity_main);
            mywebView = (WebView) findViewById(R.id.webView);
            swipeRefreshLayout=findViewById(R.id.homeswiperefreshayout);
         //   loadwebview();

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    mywebView.clearFormData();
                    mywebView.clearCache(true);
                    mywebView.clearHistory();
                    //    mywebView.clearCache(true);
                    loadwebview();

                }
            });



loadwebview();

        }




        private void loadwebview() {


            CookieManager.getInstance().setAcceptCookie(true);

            mywebView.loadUrl(url);
            swipeRefreshLayout.setRefreshing(true);

    /*    if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(mywebView, true);
        } else {*/







            mywebView.setOnKeyListener(new View.OnKeyListener(){
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK) && mywebView.canGoBack()) {
                        mywebView.goBack();
                        return true;
                    }
                    return false;
                }
            });


            // Enable Javascript
            WebSettings webSettings = mywebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            //make faster
            mywebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mywebView.getSettings().setAppCacheEnabled(true);
            mywebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webSettings.setDomStorageEnabled(true);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            webSettings.setUseWideViewPort(true);
            webSettings.setSavePassword(true);
            webSettings.setSaveFormData(true);


            // Force links and redirects to open in the WebView instead of in a browser
            mywebView.setWebViewClient(new WebViewClient());
            mywebView.setWebViewClient(new WebViewClient(){

                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {


                    try {
                        mywebView.stopLoading();
                    } catch (Exception e) {
                    }

                    if (mywebView.canGoBack()) {
                        mywebView.goBack();
                    }

                    mywebView.loadUrl("about:blank");
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Check your internet connection and try again.");
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            startActivity(getIntent());
                        }
                    });

                    alertDialog.show();
                    super.onReceivedError(mywebView, errorCode, description, failingUrl);


                    Toast.makeText(getApplicationContext(), "Failed loading app!, No Internet Connection found.", Toast.LENGTH_SHORT).show();

                }

                public  void  onPageFinished(WebView view, String url){
                    //Hide the SwipeReefreshLayout
                    swipeRefreshLayout.setRefreshing(false);
                    CookieManager.getInstance().setAcceptCookie(true);

                }

            });


        }






    }


