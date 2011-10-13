
package jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.ui;

import java.util.LinkedList;

import jp.co.c_lis.sample.nikkei_linux.nl201111.sample03.R;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BookmarkFragment extends Fragment implements OnItemClickListener {

    /**
     * ブックマーク.
     */
    private LinkedList<String> mBookmarks = new LinkedList<String>();

    /**
     * ブックマークを追加.
     * 
     * @param url
     */
    public void addBookmark(String url) {
        mBookmarks.add(url);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * ブックマークの初期化.
     */
    private void initBookmarks() {
        mBookmarks.add("http://itpro.nikkeibp.co.jp/linux/");
        mBookmarks.add("http://www.google.co.jp");
    }

    /**
     * ブックマークが選択された時に実行されるリスナ.
     */
    public interface OnBookmarkListener {
        public void onBookmarkSelected(String url);
    }

    private OnBookmarkListener listener = null;

    /**
     * コンストラクタ.
     */
    public BookmarkFragment() {
        initBookmarks();
    }

    /**
     * リストに表示する内容.
     */
    private BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String url = (String) getItem(position);

            TextView view = (TextView) View.inflate(parent.getContext(), R.layout.bookmark_row,
                    null);
            view.setText(url);

            return view;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return mBookmarks.get(position);
        }

        @Override
        public int getCount() {
            return mBookmarks.size();
        }
    };

    /*
     * (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView view = (ListView) inflater.inflate(R.layout.bookmark, container, false);
        view.setAdapter(mAdapter);
        view.setOnItemClickListener(this);
        return view;
    }

    /*
     * (non-Javadoc)
     * @see android.app.Fragment#onAttach(android.app.Activity)
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnBookmarkListener) {
            listener = (OnBookmarkListener) activity;
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget
     * .AdapterView, android.view.View, int, long)
     */
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        String url = (String) adapter.getItemAtPosition(position);
        if (listener != null) {
            listener.onBookmarkSelected(url);
        }
    }
}
