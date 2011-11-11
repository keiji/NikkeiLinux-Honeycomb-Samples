
package jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.ui.honeycomb;

import java.util.HashMap;

import jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class TabBrowserActivity extends Activity implements ActionBar.TabListener {

    private ActionBar mActionbar = null;
    private final HashMap<String, Fragment> mFragmentBin = new HashMap<String, Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_browser);

        mActionbar = getActionBar();
        mActionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        addTab();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.actionbar_with_tab, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_tab:
                addTab();
                break;
            case R.id.menu_about:
                Toast.makeText(this, "Sample05", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addTab() {
        String tag = "Tab" + mFragmentBin.size();
        Tab tab = mActionbar.newTab().setText(tag).setTabListener(this).setTag(tag);

        Fragment fragment = new BrowserFragment();
        mFragmentBin.put(tag, fragment);

        mActionbar.addTab(tab, true);
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.root, mFragmentBin.get(tab.getTag()), tab.getTag().toString());
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
}
