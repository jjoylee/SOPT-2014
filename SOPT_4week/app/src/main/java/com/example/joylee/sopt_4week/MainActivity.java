package com.example.joylee.sopt_4week;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


// 주석은 fragment 예제
public class MainActivity extends AppCompatActivity {
    Button first_btn;
    Button second_btn, third_btn, tag_btn;
    ViewPager viewPager;
    CustomPagerAdapter customPagerAdapter;
    TabLayout tabLayout;

//    EditText editText;
//    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        first_btn = (Button)findViewById(R.id.first_btn);
//        second_btn = (Button)findViewById(R.id.second_btn);
//        third_btn = (Button)findViewById(R.id.third_btn);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("1번"));
        tabLayout.addTab(tabLayout.newTab().setText("2번"));
        tabLayout.addTab(tabLayout.newTab().setText("3번"));

        viewPager = (ViewPager)findViewById(R.id.fragment_container);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        tag_btn = (Button)findViewById(R.id.tag_btn);
//        editText = (EditText) findViewById(R.id.edit);
//        container = (FrameLayout)findViewById(R.id.fragment_container);

//        first_btn.setOnClickListener(this);
//        second_btn.setOnClickListener(this);
//        third_btn.setOnClickListener(this);
//        tag_btn.setOnClickListener(this);

        customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(customPagerAdapter);
        viewPager.setCurrentItem(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        if(savedInstanceState == null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("title", "first");
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            Fragment_First fragment_first = new Fragment_First();
            fragment_first.setArguments(bundle);

            transaction.add(R.id.fragment_container, fragment_first, "first");
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch(v.getId())
//        {
//            case R.id.first_btn :
//                viewPager.setCurrentItem(0);
//                break;
//            case R.id.second_btn :
//                viewPager.setCurrentItem(1);
//                break;
//            case R.id.third_btn :
//                viewPager.setCurrentItem(2);
//                break;
//        }


//        switch (v.getId())
//        {
//            case R.id.first_btn:

//                Bundle bundle1 = new Bundle();
//                bundle1.putString("title", first_btn.getText().toString());
////                ReplaceFragment(new Fragment_First(), bundle1, "first");
//
//                break;
//            case R.id.second_btn:

//                Bundle bundle2 = new Bundle();
//                bundle2.putString("title", second_btn.getText().toString());
//                ReplaceFragment(new Fragment_Second(), bundle2, "second");
//
//                break;
//            case R.id.third_btn:

//                Bundle bundle3 = new Bundle();
//                bundle3.putString("title", third_btn.getText().toString());
//                ReplaceFragment(new Fragment_Third(), bundle3, "third");
//
//                break;

//            case R.id.tag_btn:
//                TagFragment(editText.getText().toString());
//                break;
//        }
//    }


//    public void AddFragment(Fragment fragment1, Fragment fragment2, Bundle bundle, String tag){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.remove(fragment2);
//        fragment1.setArguments(bundle);
//        transaction.add(R.id.fragment_container, fragment1, tag);
//        //transaction.addToBackStack(null);
//        transaction.commit();
//    }

//    public void TagFragment(String tag)
//    {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
//       // transaction.remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container));
//        transaction.add(R.id.fragment_container,fragment,tag);
//
//        transaction.commit();
//    }

//    public void ReplaceFragment(Fragment fragment, Bundle bundle, String tag)
//    {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        fragment.setArguments(bundle);
//        transaction.replace(R.id.fragment_container, fragment, tag);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
