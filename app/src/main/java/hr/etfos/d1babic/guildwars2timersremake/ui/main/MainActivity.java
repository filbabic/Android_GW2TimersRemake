package hr.etfos.d1babic.guildwars2timersremake.ui.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.common.Constants;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.EventsFragment;
import hr.etfos.d1babic.guildwars2timersremake.ui.main.adapter.ViewPagerAdapter;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.SubscriptionsFragment;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initAdapter();
    }

    private void initUI() {
        ButterKnife.bind(this);

        initToolbar();
        initTabLayout();
        setupViewPager(viewPager);
    }

    private void initToolbar() {
        actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
            actionBar.setDisplayUseLogoEnabled(true);
        }
    }

    private void initTabLayout() {
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        if(viewPager != null) {
            viewPager.setOffscreenPageLimit(Constants.viewPagerTabLimit);
        }
    }

    private void initAdapter() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new EventsFragment(), Constants.KEY_EVENTSFRAGMENT_TITLE);
        viewPagerAdapter.addFragment(new SubscriptionsFragment(), Constants.KEY_SUBSFRAGMENT_TITLE);

        viewPager.setAdapter(viewPagerAdapter);
    }
}
