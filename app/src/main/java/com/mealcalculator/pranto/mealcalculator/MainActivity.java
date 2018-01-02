package com.mealcalculator.pranto.mealcalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtoggle;
    ViewPager vp;
    public double meal_rate;
    ArrayList<PersonInfo> list;
    SectionsStatePagerAdapter adapter;
    Toolbar mtoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContent();
    }

    public void getContent()
    {
        list = new ArrayList<>();
        mtoolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mtoolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        vp = (ViewPager) findViewById(R.id.viewpager);
        mtoggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(this);
        setupPager(vp);

    }

    public void setupPager(ViewPager vp)
    {
        adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        Fragment f1 = new HomeFragment();
        Fragment f2 = new CalculateFragment();

        adapter.addFragment(f1, "Home fragment");
        adapter.addFragment(f2, "Calculate fragment");

        vp.setAdapter(adapter);
    }

    public void setScreen(int i)
    {
        if (i == 2)
        {
            Fragment f3 = new ResultFragment();
            adapter.addFragment(f3, "Result Fragment");
            vp.setAdapter(adapter);
        }
        vp.setCurrentItem(i);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home)
        {
            vp.setCurrentItem(0);
        }
        if (item.getItemId() == R.id.calculate_meal)
        {
            vp.setCurrentItem(1);
        }
        if(item.getItemId() == R.id.desktop_version)
        {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://prantoamt.wordpress.com/2016/02/26/meal-calculator-software/"));
            startActivity(i);
        }

        if(item.getItemId() == R.id.share)
        {
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apk_path = api.sourceDir;
            Intent share_intent = new Intent(Intent.ACTION_SEND);
            share_intent.setType("application/vnd.android.package-archive");
            share_intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apk_path)));
            startActivity(Intent.createChooser(share_intent, "Share Using"));
        }

        if(item.getItemId() == R.id.exit)
        {
            setAlert();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        setAlert();
    }

    public void setAlert()
    {
        AlertDialog.Builder mybuilder = new AlertDialog.Builder(MainActivity.this);
        mybuilder.setCancelable(false);
        mybuilder.setMessage("Do you want to Exit?");
        mybuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        mybuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = mybuilder.create();
        alert.show();
    }
}
