package info.mysterio.android;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webi;
    WebSettings webSettings;
    SharedPreferences opsione;
    String url;
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webi=(WebView)findViewById(R.id.webview);
        webSettings = webi.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webi.setWebViewClient(new Callback());
        opsione=getSharedPreferences("settings", 0);
        url =opsione.getString("url", "error");
        if(URLUtil.isValidUrl(url)){
            webi.loadUrl(url);

        }else{
            Toast.makeText(getApplicationContext(),"Url e dhene nuk eshte e sakte" , Toast.LENGTH_LONG).show();
        }
        Log.e("Devel",url);
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {

            startActivity(new Intent("info.mysterio.android.SettingsActivity"));

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Problem me hapjen e settings" , Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
