
package jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.ui;

import jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.R;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity implements BookmarkFragment.OnBookmarkListener {

    private BrowserFragment mBrowser = null;
    private BookmarkFragment mBookmark = null;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager fm = getFragmentManager();
        mBrowser = (BrowserFragment) fm.findFragmentById(R.id.browser_fragment);
        mBookmark = (BookmarkFragment) fm.findFragmentById(R.id.bookmark_fragment);
    }

    /*
     * (non-Javadoc)
     * @see
     * jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.ui.BookmarkFragment
     * .OnBookmarkListener#onBookmarkSelected(java.lang.String)
     */
    @Override
    public void onBookmarkSelected(String url) {
        mBrowser.loadUrl(url);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.browser_actionbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_bookmark:
                mBookmark.addBookmark(mBrowser.getUrl());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
