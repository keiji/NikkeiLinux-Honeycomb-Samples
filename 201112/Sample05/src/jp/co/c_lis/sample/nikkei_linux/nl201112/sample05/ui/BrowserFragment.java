
package jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.ui;

import jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WebView webView = (WebView) inflater.inflate(R.layout.webview, container, false);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://itpro.nikkeibp.co.jp/linux/");
        return webView;
    }
}
