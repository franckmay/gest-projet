package com.example.android.employeesmanagementsoftware;

import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.android.employeesmanagementsoftware.DepartmentDB.DepFragment;
import com.example.android.employeesmanagementsoftware.TaskCreation.TaskCreation;
import com.example.android.employeesmanagementsoftware.Utilities.SectionsPageAdapter;
import com.example.android.employeesmanagementsoftware.taskDB.TasksFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class StartingPageActivity extends AppCompatActivity {


    private SectionsPageAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        TextView nom = findViewById(R.id.tv_us_nom);
        nom.setText("Connecté sur " + getIntent().getExtras().getString("email"));
        //Add ACTION BAR
        toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle("Department");
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the two
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager =  findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(0);
        setupViewPager(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DepartmentCreation.class);
                intent.putExtra("IsEdit", false);
                startActivity(intent);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    toolbar.setTitle(R.string.tache);
                    setSupportActionBar(toolbar);
                    fab = findViewById(R.id.fab);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), TaskCreation.class);
                            intent.putExtra("task_id",(long)-1);
                            startActivity(intent);
                        }
                    });


                }else {
                    toolbar.setTitle(R.string.departement);
                    setSupportActionBar(toolbar);
                    fab =  findViewById(R.id.fab);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), DepartmentCreation.class);
                            intent.putExtra("IsEdit", false);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new DepFragment(), "DEPARTEMENTS");
        adapter.addFragment(TasksFragment.newInstance(), "TACHES");

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }



    public static class PlaceholderFragment extends Fragment {

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_starting_page, container, false);
        }
    }

}
