package nl.hva.dka.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final public static int RCADD = 1234;
    final public static String NAME = "NAME";
    final public static String URL = "URL";

    private RecyclerView mRecyclerView;
    private PortalAdapter mPortalAdapter;
    private List<Portal> mPortalList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPortal.class);
                startActivityForResult(intent, RCADD);
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);
        mPortalAdapter = new PortalAdapter(mPortalList, this);
        mRecyclerView.setAdapter(mPortalAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPortalList.add(new Portal("Facebook", "http://www.facebook.com"));
        mPortalList.add(new Portal("Google", "http://www.google.com"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateUI() {
        if (mPortalAdapter == null) {
            mPortalAdapter = new PortalAdapter(mPortalList, this);
            mRecyclerView.setAdapter(mPortalAdapter);
        } else {
            mPortalAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RCADD) {
            if (resultCode == Activity.RESULT_OK) {
                String url = data.getStringExtra(URL);
                String name = data.getStringExtra(NAME);
                addToList(url, name);
                updateUI();
            }
            if (resultCode == Activity.RESULT_CANCELED){

            }
        }
    }

    private void addToList(String url, String title) {
        mPortalList.add(new Portal(title, url));
        Snackbar.make(findViewById(R.id.activity_main), "Portal added: " + title, Snackbar.LENGTH_SHORT ).show();
    }

}
