package com.example.heroes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeroListActivity extends AppCompatActivity {

    private String jsonFileText;
    private List<Hero> heroesList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_heroes_list );
        InputStream jsonInputStream = getResources().openRawResource(R.raw.heroes);
        jsonFileText = readTextFile(jsonInputStream);
        wireWidgets();
        createGson();
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    private void wireWidgets(){
        listView = findViewById(R.id.main_ListView_listView);
    }


    public class Collections {
        Collections.sort(HeroAdapter.heroesList, new Comparator)

        {
            // use the autocomplete when typing new Comparator() { ... }
            // overrides compare method
        }
    }

    private class HeroAdapter extends ArrayAdapter<Hero> {
        // make an instance variable to keep track of the hero list

        public HeroAdapter(List<Hero> heroesList) {
            // since we're in the HeroListActivity class, we already have the context
            // we're hardcoding in a particular layout, so don't need to put it in
            // the constructor either
            // we'll send a placeholder resource to the superclass of -1
            super(HeroListActivity.this, -1, heroesList );
            heroesList = objects;
        }

        // The goal of the adapter is to link the your list to the listview
        // and tell the listview where each aspect of the list item goes.
        // so we override a method called getView


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 1. inflate a layout
            LayoutInflater inflater = getLayoutInflater();

            // check if convertview is null, if so, replace it
            if (convertView == null) {
                // R.layout.item_hero is a custom layout we make that represents
                // what a single item would look like in our listview
                convertView = inflater.inflate( R.layout.item_hero, parent, false );
            }

            // 2. wire widgets & link the hero to those widgets
            // instead of calling findViewById at the activity class level,
            // we're calling it from the inflated layout to find THOSE widgets
            TextView textViewHeroRanking = convertView.findViewById( R.id.textView_heroitem_ranking);
            TextView textViewHeroItem = convertView.findViewById( R.id.textView_heroitem_name);
            TextView textViewDescription = convertView.findViewById( R.id.textView_heroitem_description);
            // do this for as many widgets as you need

            // set the values for each widget. use the position parameter variable
            // to get the hero that you need out of the list
            // and set the values for widgets.
            Hero hero = heroesList.get(postion);

            // 3. return inflated view
            return convertView;
        }
    }
    private class listViewAdapter extends ArrayAdapter<Hero> {
        
    }
    public void createGson()
    {
        Gson gson = new Gson();
        // read your json file into an array of questions
        Hero[] questions =  gson.fromJson(jsonFileText, Hero[].class);
        // convert your array to a list using the Arrays utility class
        heroesList = Arrays.asList(questions);
        // verify that it read everything properly
        Log.d("O no", "onCreate: " + heroesList.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hero_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                newGame();
                return true;
            case R.id.help:
                showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
