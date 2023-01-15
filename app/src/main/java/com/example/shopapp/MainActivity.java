package com.example.shopapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shopapp.adapter.HomeSliderAdapter;
import com.example.shopapp.fragment.AccountFragment;
import com.example.shopapp.fragment.FavoriteFragment;
import com.example.shopapp.fragment.HistoryFragment;
import com.example.shopapp.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  {

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_FAVORITE = 1;
    private static final int FRAGMENT_HISTORY = 2;
    private static final int FRAGMENT_EXP = 3;
    private static final int FRAGMENT_ACCOUNT = 4;
    private int mCurrentFragment = FRAGMENT_HOME;
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView mbottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ẩn thanh task bar
//       hideSystemBars();

        mDrawerLayout = findViewById(R.id.drawer_layout);

        mbottomNavigationView = findViewById(R.id.bottom_navigation);
        replaceFragment(new HomeFragment());
        mbottomNavigationView.getMenu().findItem(R.id.shopFragment).setChecked(true);
        //bottom
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.shopFragment:
                        if(mCurrentFragment != FRAGMENT_HOME){
                            replaceFragment(new HomeFragment());
                            mCurrentFragment = FRAGMENT_HOME;

                        }
                        break;
                    case R.id.exploreFragment:
                        if(mCurrentFragment != FRAGMENT_FAVORITE){
                            replaceFragment(new FavoriteFragment());
                            mCurrentFragment = FRAGMENT_FAVORITE;

                        }
                        break;
                    case R.id.cartFragment:
                        if(mCurrentFragment != FRAGMENT_HISTORY){
                            replaceFragment(new HistoryFragment());
                            mCurrentFragment = FRAGMENT_HISTORY;

                        }
                        break;
                    case R.id.favoriteFragment:
                        if(mCurrentFragment != FRAGMENT_HISTORY){
                            replaceFragment(new HistoryFragment());
                            mCurrentFragment = FRAGMENT_HISTORY;

                        }
                        break;
                    case R.id.accountFragment:
                        if(mCurrentFragment != FRAGMENT_ACCOUNT) {
                            replaceFragment(new AccountFragment());
                            mCurrentFragment = FRAGMENT_ACCOUNT;

                        }
                        break;
                }
                return true;
            }
        });

    }
    private void hideSystemBars() {
        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController == null) {
            return;
        }
        // Configure the behavior of the hidden system bars
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
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