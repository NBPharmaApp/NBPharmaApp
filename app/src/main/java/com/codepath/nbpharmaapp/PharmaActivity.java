package com.codepath.nbpharmaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.SearchView;

import de.greenrobot.event.EventBus;

import static android.support.v4.view.MenuItemCompat.getActionView;

public class PharmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharma);

        ListView lvMedoc=  findViewById(R.id.lvMedicament);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
       final MenuItem searchitem= menu.findItem(R.id.menu_Search);
        SearchView searchView= (SearchView) getActionView(searchitem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                EventBus.getDefault().post(new QueryEvent(query));

                invalidateOptionsMenu();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }
}
