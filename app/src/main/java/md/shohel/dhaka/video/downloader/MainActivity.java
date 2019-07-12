package md.shohel.dhaka.video.downloader;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import md.shohel.dhaka.video.downloader.adapter.FragmentPagerAdapter;
import md.shohel.dhaka.video.downloader.adapter.MainRecyclerViewAdapter;
import md.shohel.dhaka.video.downloader.fragments.FeatureFragment;
import md.shohel.dhaka.video.downloader.fragments.VideoFragment;
import md.shohel.dhaka.video.downloader.model.MainModelClass;
import md.shohel.dhaka.video.downloader.model.SubModelClass;

public class MainActivity extends AppCompatActivity{

    
    private Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initializeAll();

    }


    private void initializeAll(){
        tabLayout=findViewById(R.id.homeActivityTabLayoutId);
        viewPager=findViewById(R.id.mainActivityViewPagerId);
        viewPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FeatureFragment(),"Features");
        viewPagerAdapter.addFragment(new VideoFragment(),"Videos");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }
    }
}
