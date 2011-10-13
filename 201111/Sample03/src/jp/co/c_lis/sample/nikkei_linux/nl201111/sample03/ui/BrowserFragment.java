
package jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.ui;

import jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserFragment extends Fragment {

    /** 表示しているURLを維持するためのキー */
    public static final String BUNDLE_KEY_URL = "URL";

    private WebView mWebView = null;

    /*
     * (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mWebView = (WebView) inflater.inflate(R.layout.browser, container, false);
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_KEY_URL)) {
            String url = savedInstanceState.getString(BUNDLE_KEY_URL);
            mWebView.loadUrl(url);
        }
        return mWebView;
    }

    /**
     * URLを読み込む.
     * 
     * @param url
     */
    public void loadUrl(String url) {
        mWebView.loadUrl(url);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Fragment#onSaveInstanceState(android.os.Bundle)
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_KEY_URL, mWebView.getUrl());
    }

    /**
     * 現在のURLを取得.
     * 
     * @return
     */
    public String getUrl() {
        return mWebView.getUrl();
    }
}
