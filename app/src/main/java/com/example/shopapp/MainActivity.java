package com.example.shopapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shopapp.adapter.HomeSliderAdapter;
import com.example.shopapp.fragment.FavoriteFragment;
import com.example.shopapp.fragment.HistoryFragment;
import com.example.shopapp.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_FAVORITE = 1;
    private static final int FRAGMENT_HISTORY = 2;
    private int mCurrentFragment = FRAGMENT_HOME;
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView mbottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        mbottomNavigationView = findViewById(R.id.bottom_navigation);

        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());

        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
        mbottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);

        //bottom
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        if(mCurrentFragment != FRAGMENT_HOME){
                            replaceFragment(new HomeFragment());
                            mCurrentFragment = FRAGMENT_HOME;
                            navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        }
                        break;
                    case R.id.action_favorite:
                        if(mCurrentFragment != FRAGMENT_FAVORITE){
                            replaceFragment(new FavoriteFragment());
                            mCurrentFragment = FRAGMENT_FAVORITE;
                            navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                        }
                        break;
                    case R.id.action_history:
                        if(mCurrentFragment != FRAGMENT_HISTORY){
                            replaceFragment(new HistoryFragment());
                            mCurrentFragment = FRAGMENT_HISTORY;
                            navigationView.getMenu().findItem(R.id.nav_history).setChecked(true);
                        }
                        break;
                }
                return true;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.MenuSettings:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuContract:
                Toast.makeText(MainActivity.this, "Contract", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuEmail:
                Toast.makeText(MainActivity.this, "Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuExit:
                Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuPhone:
                Toast.makeText(MainActivity.this, "Phone", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuSearch:
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuShares:
                Toast.makeText(MainActivity.this, "Shares", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_home){
            if(mCurrentFragment != FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                mCurrentFragment = FRAGMENT_HOME;
                mbottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
            }

        }else if(id == R.id.nav_favorite){
            if(mCurrentFragment != FRAGMENT_FAVORITE){
                replaceFragment(new FavoriteFragment());
                mCurrentFragment = FRAGMENT_FAVORITE;
                mbottomNavigationView.getMenu().findItem(R.id.action_favorite).setChecked(true);
            }

        }else if(id == R.id.nav_history){
            if(mCurrentFragment != FRAGMENT_HISTORY){
                replaceFragment(new HistoryFragment());
                mCurrentFragment = FRAGMENT_HISTORY;
                mbottomNavigationView.getMenu().findItem(R.id.action_history).setChecked(true);
            }
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;

    }
    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }


}