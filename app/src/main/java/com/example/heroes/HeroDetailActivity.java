package com.example.heroes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class HeroDetailActivity extends AppCompatActivity {


    private Hero hero;
    private ImageSwitcher imageViewPortrait;
    public static final String EXTRA = "extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hero_detail);
        Intent lastIntent = getIntent();
       Hero hero = lastIntent.getParcelableExtra(HeroListActivity.EXTRA.);
       int resourceImage = getResources().getIdentifier(hero.getImage(), "drawable", getPackageName());
       imageViewPortrait.setImageDrawable(getResources().getDrawable(resourceImage));
    }

}
