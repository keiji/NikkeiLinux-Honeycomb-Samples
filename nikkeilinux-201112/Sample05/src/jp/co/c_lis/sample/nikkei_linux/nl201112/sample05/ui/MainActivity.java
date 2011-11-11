
package jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.ui;

import jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private static final boolean IS_HONEYCOMB = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (IS_HONEYCOMB) {
            Intent intent = new Intent(
                    this,
                    jp.co.c_lis.sample.nikkei_linux.nl201112.sample05.ui.honeycomb.MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.main);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                Toast.makeText(this, "Sample05", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
