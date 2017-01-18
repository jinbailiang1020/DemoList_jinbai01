package com.example.jinbailiang;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinbailiang.demos_jinbai.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class ListViewItemClickActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item_click);
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            l.add("item：" + i);
        }
        lv.setAdapter(new Myadater(l, this));//grid_icon
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ListViewItemClick Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    class Myadater extends BaseAdapter {
        private ArrayList<String> l;
        private Context context;

        public Myadater(ArrayList<String> l, ListViewItemClickActivity context) {
            this.l = l;
            this.context = context;
        }


        @Override
        public int getCount() {
            return l.size();
        }

        @Override
        public Object getItem(int position) {
            return l.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder vh;
            if (convertView == null) {
                vh = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
                vh.iv = (ImageView) convertView.findViewById(R.id.grid_icon);
                vh.tv = (TextView) convertView.findViewById(R.id.grid_name);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            vh.tv.setText(position+"--");
            vh.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,position+";;;;",Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }

    }

    class ViewHolder {

        public TextView tv;
        public ImageView iv;

    }

}
