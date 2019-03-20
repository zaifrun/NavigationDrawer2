package com.android4dev.navigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    //The navigationview
    private NavigationView navigationView;
    //our layout for the navigationdrawer
    private DrawerLayout drawerLayout;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
      toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


            //Checking if the item is in checked state or not, if not make it in checked state
            if (menuItem.isChecked())
                menuItem.setChecked(false);
            else
                menuItem.setChecked(true);

            //Closing drawer on item click
            drawerLayout.closeDrawers();

            //Check to see which item was being clicked and perform appropriate action
            Fragment fragment = null;
            String title= "";
            switch (menuItem.getItemId()) {

            //Replacing the main content with ContentFragment
            case R.id.main:
                fragment = new HomeFragment();
                title = getResources().getString(R.string.home);
                break;
            case R.id.hyundai:
                fragment = new HyundaiFragment();
                title = getResources().getString(R.string.hyundai);
                break;
            case R.id.skoda:
                fragment = new SkodaFragment();
                title = getResources().getString(R.string.skoda);

                break;
            case R.id.porsche:
                fragment = new PorscheFragment();
                title = getResources().getString(R.string.porsche);

                break;
            default:
                Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();

                return true;

            } //after switch
            if (fragment != null) {
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle(title); //set the title of the action bar
            }
            return true;
            }
        });  //end of nagivation drawer code

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = findViewById(R.id.drawer);

        //Showing how to override onDrawerClosed and onDrawerOpened
        //although in this app we actually dont do anything in there
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
       // doing the fragment transaction here - replacing frame with HomeFragment -
        //which is the startup fragment in the app.
        fragmentTransaction.replace(R.id.frame, new HomeFragment());
        fragmentTransaction.commit(); //set starting fragment

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
            //no settings activity - code does not do anything
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
