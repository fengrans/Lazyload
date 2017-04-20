package fengras.com.lazyload;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager vp;
    private ViewPager viewPager;
    private List<String> list=new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        list.add("周一");
        list.add("周二");
        list.add("周三");
        list.add("周四");
        viewPager = (ViewPager) findViewById(R.id.viewpagers);
        getdata();
    }

    private void getdata() {
        FragmentPagerAdapter addadapter = Addapter(list);
        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE );
        viewPager.setAdapter(addadapter);
        tabLayout.setTabsFromPagerAdapter(addadapter);//数据传给Tab
        tabLayout.setupWithViewPager(viewPager); //关联ViewPager
    }
    //将list传入fragment这里复用的fragment的个数就是集合的长度
    private FragmentPagerAdapter Addapter(final List<String> list ){
        FragmentPagerAdapter  fra=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment01 fragment01=new Fragment01();
                Bundle bundle = new Bundle();
                Log.e("ss",list.get(position));
                bundle.putString("str",list.get(position));
                fragment01.setArguments(bundle);
                //将cattegory传到fragment中
                return fragment01;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        };
        return  fra;


    }






}



