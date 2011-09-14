
package jp.co.c_lis.sample.nikkei_linux.nl201110.sample01.ui;

import jp.co.c_lis.sample.nikkei_linux.nl201110.sample01.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        showActivity2();
                        break;
                }
            }
        });
    }

    private void showActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
