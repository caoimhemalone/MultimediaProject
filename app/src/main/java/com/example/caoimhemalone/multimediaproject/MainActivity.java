package com.example.caoimhemalone.multimediaproject;

//Code for slider taken from https://www.android-examples.com/android-multiple-auto-image-slider-example-tutorial-using-online-url/

//Code for hamburger menu taken from http://codetheory.in/android-navigation-drawer/

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import java.util.HashMap;

import static com.example.caoimhemalone.multimediaproject.R.layout.activity_main;


public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;



    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout) findViewById(R.id.slider);


        Hash_file_maps.put("Restaurant Name1", "https://storage.googleapis.com/lg_meetup_images/street-food-tracking.jpg");
        Hash_file_maps.put("Restaurant Name2", "https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg");
        Hash_file_maps.put("Restaurant Name3", "https://assets.epicurious.com/photos/596d14096c42213eb20a2b65/2:1/w_1260%2Ch_630/How-To-Make-Boneless-Buffalo-Chicken-Wings-071220172005.jpg");
        Hash_file_maps.put("Restaurant Name4", "http://images.media-allrecipes.com/userphotos/960x960/3757728.jpg");
        Hash_file_maps.put("Restaurant Name5", "http://zznbobs.com/wp-content/uploads/2015/03/Cheese-Fries.jpg");


        for (String name : Hash_file_maps.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(this);
    }

        @Override
        protected void onStop() {

            sliderLayout.stopAutoCycle();

            super.onStop();
        }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PlaceActivity.class);
        startActivity(intent);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}


    private void addDrawerItems() {
        String[] navArray = {  "Home", "Top Restaurants", "Contact Us" };
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, navArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent;
                switch(position){
                    case 0:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);


                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, TopRest.class);
                        startActivity(intent);


                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Contact.class);
                        startActivity(intent);

                        break;


                }
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Select an option");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //For opening new food dish page
    public void openDish(View view)
    {
        Intent intent = new Intent(this, DishActivity.class);
        startActivity(intent);
    }
    public void openHome(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}